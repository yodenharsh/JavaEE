<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Student registration</title>
</head>

<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName" />
 <br><br>
 Last name: <form:input path="lastName"/>
 <br><br>
 <form:select path="country">
 	<form:options items="${student.countryOptions}" />
 </form:select>
 <br><br>
 Language: 
 
 English <form:radiobutton path="lang" value="English"/>
 French <form:radiobutton path="lang" value="French"/>
 German <form:radiobutton path="lang" value="German"/>
 <br><br>

Operating Systems: 

Linux<form:checkbox path="OS" value="Linux"/> 
Windows<form:checkbox path="OS" value="Windows"/> 
MacOS<form:checkbox path="OS" value="MacOS"/> 

 <br><br>
 <input type="submit" value="Submit"/>
 </form:form>
</body>

</html> 