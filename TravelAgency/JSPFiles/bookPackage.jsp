<%@ page import="yourpackage.Booking, yourpackage.User, yourpackage.Package, yourpackage.BookingDAO,yourpackage.DBUtil" %>
<%
    User user = (User) session.getAttribute("user");
    if (user == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    int packageId = Integer.parseInt(request.getParameter("packageId"));
    Booking booking = new Booking();
    booking.setUserId(user.getId());
    booking.setPackageId(packageId);
    booking.setBookingDate(new java.sql.Date(System.currentTimeMillis()));
    booking.setStatus("Pending");

    BookingDAO bookingDAO = new BookingDAO(DBUtil.getConnection());
    bookingDAO.addBooking(booking);

    request.setAttribute("booking", booking);
    RequestDispatcher dispatcher = request.getRequestDispatcher("confirmBooking.jsp");
    dispatcher.forward(request, response);
%>