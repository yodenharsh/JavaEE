# Harsh's Airline Reservation System (With Web front-end)

### A flight booking web application made using Java servlets, JSPs, JDBC and bootstrap. Most of the business logic was reused from [my previous project](https://github.com/yodenharsh/JavaEE/tree/main/airline-reservation-system) which was completely made for CLI. Most of the UI was reused from [this project](https://github.com/yodenharsh/fwt-php-lab/tree/main/assignment).

<br/>
Features include:

- Authentication: Signing in, logging in, etc with password stored as encrypted text
- Booking flights: If logged in, user can book flights
- MySQL DB: All user information and flight bookings get stored in the database
- Web-based front-end: An attractive yet simple GUI for the user to use and perform all operations

To run the program:

1. Clone the repository
2. Open in any IDE of your choice preferrably, Eclipse for Java EE developers
3. Make sure the MySQL server is running
4. Configure the db.properties in src/main/resources to match your server's info
5. Make sure the tables reservationsList and userList exist with [this schema](#schema-definitions)
6. Configure project as a JDK 17 project
7. Make sure Tomcat 10 is installed
8. OPTIONAL, use a MySQL management software to make sure every DB-side operation is being successfully performed
9. Run project as _maven install_ to make sure all the dependencies have been installed.
10. Run the program on the Tomcat server

### External Dependencies

`org.jasypt.jasypt` - Used for encryption and decryption of password

### Table list

- userList: Contains email as primary key and an encrypted password along with it.
- reservationsList: Contains a randomly generated tripID as primary key and other necessary information about any flight bookings.

### Schema definitions

- For userList:

```
CREATE TABLE userList(
    email varchar(255) PRIMARY KEY NOT NULL,
    password varchar(255) NOT NULL
);
```

- For reservationsList:

```
CREATE TABLE reservationsList(
    tripId int PRIMARY KEY NOT NULL,
    email varchar(255) NOT NULL,
    toWhere varchar(127) NOT NULL,
    fromWhere varchar(127) NOT NULL,
    people int NOT NULL,
    date date NOT NULL
)
```

### Known Issues

- Eclipse might show an error on every .jsp file saying the javax library was not found. However, since Tomcat 10, the javax._ namespace is no longer used but rather the jakarta._ namespace is used. **The project however functions normally.**
- Multiple IllegalStateException (s) arise during the execution. This might be due to the hot reload feature. Nevertheless, functionality _seems_ to be unaffected.
- The application misses some preferrable client-side validation. This was kept on hold because the project is mainly focuses towards Java and it's tools. This might be implemented later.
- The JSPs folder structure is not upto the current standards
- The sql driver needs to be manually registered even though it should have been automatic.
