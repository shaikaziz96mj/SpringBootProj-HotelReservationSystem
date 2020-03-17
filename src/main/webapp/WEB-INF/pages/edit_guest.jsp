<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<h1 style="color:blue;text-align: center;">WELCOME TO SO AND SO HOSPITAL</h1>
	<h2 style="color:blue;text-align: center;">ENTER NEW GUEST DETAILS BELOW TO UPDATE RECORD</h2>
	<hr><br><br>
	<form:form method="POST" modelAttribute="guestCmd">
		<table border="2" bordercolor="blue" align="center">
			<tr>
				<td>GUEST ID</td>
				<td><form:input path="guestId" readonly="true"/></td>			
			</tr>
			<tr>
				<td>GUEST NAME</td>
				<td><form:input path="guestName"/></td>			
			</tr>
			<tr>
				<td>GUEST AGE</td>
				<td><form:input path="guestAge"/></td>			
			</tr>
			<tr>
				<td>GUEST ADDRESS</td>
				<td><form:textarea path="guestAddress"/></td>			
			</tr>
			<tr>
				<td>GUEST PHONE NUMBER</td>
				<td><form:input path="phoneNumber"/></td>			
			</tr>
			<tr>
				<td>ALLOTED ROOM NUMBER</td>
				<td><form:input path="roomNumber"/></td>			
			</tr>
			<tr>
				<td>CHECKED IN</td>
				<td><form:input path="checkedIn"/>(dd-MM-yyyy)</td>			
			</tr>
			<tr>
				<td>CHECKED OUT</td>
				<td><form:input path="checkedOut"/>(dd-MM-yyyy)</td>			
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;"><input type="submit" value="UPDATE">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="reset" value="CLEAR"></td>
			</tr>
		</table>
		<p style="text-align: center;">
		<a href="getdetails.htm"><img src="images/home.jpg" title="back to result page" width="70" height="70"></a>
		</p>
		<br><br>
		<h1 style="color:green;text-align:center">THANK YOU</h1>
	</form:form>