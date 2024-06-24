<%@ page import="java.sql.Connection" %>
<%@ page import="yourpackage.DBUtil" %>
<%@ page import="yourpackage.PaymentDAO" %>
<%@ page import="yourpackage.Payment" %>
<%@ page import="yourpackage.User" %>
<%@ page import="java.sql.Date" %>
<%
    // Check if user is logged in
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    // Retrieve bookingId from request parameter
    int bookingId = Integer.parseInt(request.getParameter("bookingId"));
    double amount = Double.parseDouble(request.getParameter("amount")); // Assuming amount is passed in the request

    // Process payment on form submission
    if ("POST".equalsIgnoreCase(request.getMethod())) {
        Connection connection = null;
        try {
            connection = DBUtil.getConnection();
            PaymentDAO paymentDAO = new PaymentDAO(connection);

            // Create and populate Payment object
            Payment payment = new Payment();
            payment.setBookingId(bookingId);
            payment.setAmount(amount);
            payment.setPaymentDate(new Date(System.currentTimeMillis()));

            // Add payment to the database
            paymentDAO.addPayment(payment);

            // Redirect to a confirmation page or display a success message
            request.setAttribute("payment", payment);
            RequestDispatcher dispatcher = request.getRequestDispatcher("paymentConfirmation.jsp");
            dispatcher.forward(request, response);
            return;
        } catch (Exception e) {
            e.printStackTrace(); // Handle or log the exception as needed
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Handle or log the exception as needed
            }
        }
    }
%>