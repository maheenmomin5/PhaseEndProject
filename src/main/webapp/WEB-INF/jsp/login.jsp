<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<html>

<head>
<title>First Web Application</title>
</head>

<body>
	<h1>Employee Login Page</h1>
        <div>
            <p>
                Username: <input type="text" name="username" />
            </p>
            <p>
                Password: <input type="text" name="password" />
            </p>
            <p>${message}</p>
            <p>
                <input type="submit" /> <br>
            </p>
        </div>
</body>
	
</html>
