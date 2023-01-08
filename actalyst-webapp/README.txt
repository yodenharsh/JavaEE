Hello, this is my (Harsh Morayya's) submission for the Actalyst Coding Challenge


- The project can be built by running the project as maven install
- src/main/resources cotains dbAndTableCreation.sql which is a script that creates the db and table
	 used in this project
- DB properties hard-coded into code (See /actalyst-webapp/src/main/java/com/harsh/actalyst_webapp/API/RequestOps.java)
	but can be a shifted to a .properties file with a bit of tinkering
- Can only be ran on Tomcat 10.0. Version 10.5 or 9.0 WILL break things. This is because of the namespace change from
	javax.* to jakarta.* among other things.
- Older versions of IDEs may show a lot of errors when opening the project. Almost all of these errors are related
	to a javax library not being found and are not valid since we are using the jakarta.* namespace (see point above)
- Some major dependencies include Spring MVC, Hibernate Validator, etc
- Project can also be found on GitHub: https://github.com/yodenharsh/JavaEE/tree/main/actalyst-webapp

