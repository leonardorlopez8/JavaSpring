<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
<title>Login general</title>
</head>
<body>
	<br>
	<br>
	
	<table style="width: 100%">
		
		<tr>
			<td align="center">
			${SPRING_SECURITY_LAST_EXCEPTION.message}
				<form name="f" action="j_spring_security_check" method="POST">
					<table style="width: 300px;">
						<tr>
							<td colspan="2" style="background-color: #F6A20E; font-size: 30px; text-align: center;">AutoParts</td>
						</tr>
						<tr>
							<td>Usuario:</td>
							<td><input type='text' name='j_username' />
							</td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input type='password' name='j_password' />
							</td>
						</tr>
					
						<tr>
							<td colspan='2'><input name="submit" type="submit" value="Login" />
							</td>
						</tr>
					</table>
				</form>
				
			</td>
		</tr>
	</table>

</body>
</html>