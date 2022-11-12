package com.harsh.airline_reservation_system.StartingPrograms;

import java.sql.Connection;
import java.util.Scanner;

import com.harsh.airline_reservation_system.UserInfo;
import com.harsh.airline_reservation_system.Operations.OperationsImpl;

public class StartHere {

	private UserInfo userInfo;
	private boolean isAuth = false; // If user is signed in or not
	String email, password;

	public void TakeUserInput(Connection conn) {
		Scanner sc = new Scanner(System.in);
		int choice;
		OperationsImpl ops = new OperationsImpl();
		do {
			System.out.println("\n------------------Start----------------\n\n 0. Exit");
			if (!isAuth)
				System.out.println(" 1. Signin\n 2. Signup\n 3. Forgot Password");
			if (isAuth)
				System.out.println(" 4. Change Password\n 5. Logout\n");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				if (isAuth) {
					System.out.println("Invalid choice");
					break;
				}
				userInfo = getUserInfo(sc);
				if (ops.login(userInfo, conn)) {
					System.out.println("Logged in successfully");
					isAuth = true;

				} else {
					System.out.println("Invalid credentials");
				}
				break;
			case 2:
				if (isAuth) {
					System.out.println("Invalid choice");
					break;
				}
				userInfo = getUserInfo(sc);
				if (ops.signup(userInfo, conn))
					System.out.println("Signup completed");
				else
					System.out.println("Signup failed - Account with email already exists or email is invalid");
				break;
			case 3:
				System.out.println("Enter email");
				email = sc.next().trim();
				System.out.println("Please check your inbox for a changing password, " + email);
				break;
			case 4:
				if (!isAuth) {
					System.out.println("Invalid choice");
					break;
				}
				System.out.println("Enter new password");
				String newPassword = sc.next();
				if (ops.changePassword(userInfo, newPassword, conn)) {
					System.out.println("Password successfully changed - changes reflect when you login next time");
				} else {
					System.out.println("There was an internal error");
				}
				break;
			case 5:
				if (!isAuth) {
					System.out.println("Invalid choice");
					break;
				}
				isAuth = false;
			case 0:
				System.out.println("\nThank you for using our sevice");
				break;
			default:
				System.out.println("Enter valid choice!!");
			}
		} while (choice != 0);
		sc.close();
	}

	private static UserInfo getUserInfo(Scanner sc) {
		System.out.println("Enter email: ");
		String email = sc.next().trim();
		System.out.println("Enter current password: ");
		String password = sc.next();
		return new UserInfo(email, password);

	}
}
