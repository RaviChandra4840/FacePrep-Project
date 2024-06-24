<%
    // Initialize PackageDAO
    Payment payment = (Payment) request.getAttribute("payment");
    
    // Retrieve list of packages from DAO
   // List<Package> packages = packageDAO.getAllPackages();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Payment</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Make a Payment</h2>
    <form action="paymentfunctionality.jsp" method="post">
        <input type="hidden" name="bookingId" value="${bookingId}">
        <label for="amount">Amount: $</label>
        <input type="text" id="amount" name="amount" value="<%= payment.getPrice() %>" readonly><br>
        <label for="cardNumber">Card Number:</label>
        <input type="text" id="cardNumber" name="cardNumber" required><br>
        <label for="expiryDate">Expiry Date:</label>
        <input type="text" id="expiryDate" name="expiryDate" required><br>
        <label for="cvv">CVV:</label>s
        <input type="text" id="cvv" name="cvv" required><br>
        <input type="submit" value="Pay Now">
    </form>
</body>
</html>
