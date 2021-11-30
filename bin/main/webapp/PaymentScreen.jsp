<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Screen</title>
</head>
<body>
	<!--Table for customer to put their information for payment  -->
	<form name="paymentInformation" action="PaymentScreenResults.jsp" method="post">
		<table>
			<tbody>
				<tr>
					<td>First Name:</td>
					<td> <input type="text" name="first" value="" size="50"></td>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td> <input type="text" name="last" value="" size="50"></td>
				</tr>
				<tr>
					<td>Student/Professor:</td>
					<td> <select name="customerType">
						<option>Student</option>
						<option>Professor</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Payment Method:</td>
					<td> <select name="paymentMethod">
							<option>Debit Card</option>
							<option>Credit Card</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Card Number:</td>
					<td> <input type="text" name="cardNumber" value="" size="50"></td>
					<td> EXP Date (MM/YY): </td>
					<td> <input type="text" name="expDate" value="" size="50"></td>
					<td> CCV:</td>
					<td> <input type="text" name="ccv" value="" size="50"></td>
				</tr>
			</tbody>
		</table>
		<!-- Buttons to either clear form or submit payment and move to PaymentScreenResults page. -->
		<input type="reset" value="Clear" id="clear">
		<input type="submit" value="Submit" id="submit">
	</form>
</body>
</html>