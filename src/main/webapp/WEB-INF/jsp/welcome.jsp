<html>

<head>
<title>First Web Application</title>
</head>

<body>
	<h1>Welcome!</h1>
<h1><font color="green">${name}</font></h1>
		<br>
	<form:form action="processButton" method="post">
     <input type = "submit" name = "loginBtn" value="Login"/>
     
     <input type = "submit" name = "registerBtn" value="Register"/>
   </form:form>
   <br>
   <h4>${special}</h4>
   <h2><font color="blue">${message}</font></h2>
   
</body>
	
</html>
