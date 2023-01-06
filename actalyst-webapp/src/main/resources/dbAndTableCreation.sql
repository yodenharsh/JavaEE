CREATE DATABASE actalyst;
GO;

use actalyst;

CREATE TABLE requests(
request_id int AUTO_INCREMENT NOT NULL PRIMARY KEY,
dob date NOT NULL,
timestamp timestamp default current_timestamp NOT NULL
);