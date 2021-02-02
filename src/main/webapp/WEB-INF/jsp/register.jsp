<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login.jsp"method=post>
	<h1>New Employee Registration</h1>
        
         <p>
                First Name: <input type="text" name="first_name" />
            </p>
             <p>
                Last Name: <input type="text" name="last_name" />
            </p>
            <p>
                Username: <input type="text" name="username" />
            </p>
            <p>
                Password: <input type="text" name="password" />
            </p>
            <p>${message}</p>
            <p>
        </form>
	<form:form action="returnWelcomeButton" method="post">
	<input type = "submit" name = "button_clicked" value="Submit"/>

	</form:form>

</body>
</html>