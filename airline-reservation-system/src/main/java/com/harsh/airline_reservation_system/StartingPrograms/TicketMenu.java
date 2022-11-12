package com.harsh.airline_reservation_system.StartingPrograms;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Scanner;

import com.harsh.airline_reservation_system.ReservationInfo;
import com.harsh.airline_reservation_system.Operations.BookingOperationsImpl;

public class TicketMenu {

	private Connection conn;
	private String email;

	public TicketMenu(Connection conn, String email) {
		this.conn = conn;
		this.email = email;
	}

	public void ticketMenu() {
		int choice;
		Scanner sc = new Scanner(System.in);
		BookingOperationsImpl bOps = new BookingOperationsImpl();
		do {
			System.out.println("-------------------------------");
			System.out.println("Select choice");
			System.out.println("-------------------------------");
			System.out.println(" 1. Book flight\n 2. Cancel flight\n 3. View booked flights\n 0. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				var reservationInfo = bookTicketInput(email, sc);
				if(bOps.bookTicket(reservationInfo, conn)) {
					System.out.println("Booking successful");
				}
				else {
					System.out.println("Booking unsuccessful - Internal error");
				}
				break;
			}
		} while (choice != 0);
		sc.close();
	}

	private static ReservationInfo bookTicketInput(String email, Scanner sc) {
		int choice;
		String to = "", from = "";
		int year, month, dayOfMonth;
		do {
			System.out
					.println(" Select destination\n 1. New York\n 2. Mumbai\n 3. Dubai\n 4. Bangladesh\n 5. Toronto\n");
			choice = sc.nextInt();
			to = switch (choice) {
			case 1 -> "New York";
			case 2 -> "Mumbai";
			case 3 -> "Dubai";
			case 4 -> "Bangladesh";
			case 5 -> "Toronto";
			default -> "";
			};
		} while (to.equals(""));// invalid choice

		do {
			System.out.println(
					" Select Departing location\n 1. New York\n 2. Mumbai\n 3. Dubai\n 4. Bangladesh\n 5. Toronto\n");
			choice = sc.nextInt();
			from = switch (choice) {
			case 1 -> "New York";
			case 2 -> "Mumbai";
			case 3 -> "Dubai";
			case 4 -> "Bangladesh";
			case 5 -> "Toronto";
			default -> "";
			};
		} while (from.equals("") || from.equals(to));// invalid choice or to == from
		
		System.out.println("Enter number of people");
		int people = sc.nextInt();
		LocalDate dateNow = LocalDate.now();
		LocalDate dateDeparture;
		do {
			System.out.println("Enter a valid date in the future");
			do {
			System.out.println("Enter year");
			year = sc.nextInt();
			}while(year<2000 || year>dateNow.getYear() + 6);
			do {
			System.out.println("Enter month");
			month = sc.nextInt();
			}while(month>=1 && month<=12);
			do {
				System.out.println("Enter day of month");
				dayOfMonth = sc.nextInt();
			}while(dayOfMonth>=1 && dayOfMonth<=30);
			
			dateDeparture = LocalDate.of(year, month, dayOfMonth);
		}while(dateNow.compareTo(dateDeparture) <=0);
		return new ReservationInfo(email, to, from, people, dateDeparture);
	}
}
