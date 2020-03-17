<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
	<c:when test="${!empty listDTO}">
		<h1 style="color:blue;text-align: center;">WELCOME TO HOTEL@PAY</h1>
		<h2 style="color:green;text-align: center;">DISPLAYING RECORDS</h2>
		<hr>
		<p style="text-align: center;background-color: yellow">
			${result}
		</p>
		<hr>
		<br><br>
		<table align="center" border="2" bordercolor="blue">
			<tr bgcolor="cyan">
				<th>S.NO</th><th>GUEST ID</th><th>GUEST NAME</th><th>GUEST AGE</th><th>GUEST ADDRESS</th>
				<th>GUEST PH NUMBER</th><th>ROOM NUMBER</th><th>CHECKED IN</th><th>CHECKED OUT</th><th>OPERATIONS</th>
			</tr>
			<c:forEach var="dto" items="${listDTO}">
				<tr bgcolor="yellow">
					<td>${dto.serialNo}</td>
					<td>${dto.guestId}</td>
					<td>${dto.guestName}</td>
					<td>${dto.guestAge}</td>
					<td>${dto.guestAddress}</td>
					<td>${dto.phoneNumber}</td>
					<td>${dto.roomNumber}</td>
					<td>${dto.checkedIn}</td>
					<td>${dto.checkedOut}</td>
					<td><a href="edit_record.htm?id=${dto.guestId}"><img src="images/edit.jpg" title="edit guest record" width="30" height="30"></a>&nbsp;&nbsp;&nbsp;&nbsp;
					<a href="remove_record.htm?id=${dto.guestId}" onclick="return confirm('!!SURE, YOU WANT TO DELETE RECORD!!')"><img src="images/delete.jpg" title="delete guest record" width="30" height="30"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
	<c:otherwise>
		<h1 style="color:blue;text-align: center;">WELCOME TO HOTEL@PAY</h1>
		<h2 style="color:green;text-align: center;">DISPLAYING RECORDS</h2>
		<hr>
		<table align="center" border="2" bordercolor="blue">
			<tr>
				<th>S.NO</th><th>GUEST ID</th><th>GUEST NAME</th><th>GUEST AGE</th>
				<th>GUEST ADDRESS</th><th>GUEST PH NUMBER</th><th>ROOM NUMBER</th><th>CHECKED IN</th><th>CHECKED OUT</th>
			</tr>
			<tr>
				<td colspan="9" align="center" bgcolor="red" >SORRY NO RECORDS TO DISPLAY!! TRY AGAIN LATER</td>
			</tr>
		</table>
	</c:otherwise>
</c:choose>
<p style="text-align:center;background-color: pink">
			<b>CLICK HERE TO INSERT NEW RECORD-></b><a href="insert_guest.htm"><img src="images/insert.jpg" title="click to insert" width="60" height="60"></a>
</p>
<hr>
<br>
<p style="text-align: center;">
	<a href="welcome.htm"><img src="images/home.jpg" title="back to home" width="70" height="70"></a>&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="JavaScript:doPrint()"><img src="images/print.jpg" width="70" height="70" title="click here to print"></a>
</p>
<script language="JavaScript" >
	function doPrint(){
			frames.focus();
			frames.print();
		}
</script>