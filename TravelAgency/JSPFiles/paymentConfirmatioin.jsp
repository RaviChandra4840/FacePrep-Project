<%@ page import="yourpackage.Payment" %>
<%
    Payment payment = (Payment) request.getAttribute("payment");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment Confirmation</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Payment Confirmation</h2>
    <p>Your payment has been processed successfully.</p>
    <p>Booking ID: ${payment.getBookingId() }</p>
    <p>Amount: ${payment.getAmount()}</p>
    <p>Payment Date: ${payment.getPaymentDate()}</p>
    <a href="index.jsp">Back to Home</a>
</body>
</html>
