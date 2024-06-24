
<%
request.getAttribute("booking");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Booking Confirmation</h2>
    <p>Your booking has been placed successfully.</p>
    <p>Booking ID: ${booking.getId()}</p>
    <p>Package ID: ${booking.getPackageId()}</p>
    <p>Booking Date: ${booking.getBookingDate()}</p>
    <p>Status: ${booking.getStatus()}</p>
    <a href="tourpackages.jsp">Back to Packages</a>
    <a href="payment.jsp">Payment</a>
</body>
</html>
