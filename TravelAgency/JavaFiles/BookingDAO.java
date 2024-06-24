package yourpackage;

import java.sql.*;
public class BookingDAO {
    private Connection connection; // Database connection - should be injected or managed properly
    
    // Constructor to inject or obtain the database connection
    public BookingDAO(Connection connection) {
        this.connection = connection;
    }
    
    // Method to add a booking to the database
    public void addBooking(Booking booking) {
        String sql = "INSERT INTO bookings (user_id, package_id, booking_date, status) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, booking.getUserId());
            statement.setInt(2, booking.getPackageId());
            statement.setDate(3, (Date)booking.getBookingDate());
            statement.setString(4, booking.getStatus());
            
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
    
    // Other methods like retrieveBookingById, updateBookingStatus, etc.
}