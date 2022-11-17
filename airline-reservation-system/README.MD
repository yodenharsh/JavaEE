# Harsh's Airline Reservation System

## A CLI-based airline reservation system developed by yodenharsh using JDBC.

<br/>
The feautures includes:

- Authentication: Signing in, logging in, etc with password stored as encrypted text
- Booking flights: If logged in, user can book flights
- MySQL DB: All user information and flight bookings get stored in the database

To run the program,

1. Clone the repository
2. Open in any IDE
3. Make sure MySQL server is running
4. Configure the db.properties and match it's info to your database
5. Make sure the tables reservationsList and userList exist with [this schema](#schema-definitions)
6. Make sure JDK 17 is installed
7. Run project as _maven install_ to download all the dependencies
8. Run the program using `App.java`

### External Dependencies

`org.jasypt.jasypt` - Used for encryption and decryption of password

`org.bethecoder.ascii-table` - Used to generate a decent-looking table on the console

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
