package yourpackage;

import java.sql.*;
public class UserDAO {
	public User getUserByUsername(String username){
		User user = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		try{
			connection = DBUtil.getConnection();
			preparedStatement = connection.prepareStatement("select * from user where username=?");
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				 user = new User();
				 user.setId(resultSet.getInt("id"));
				 user.setUsername(resultSet.getString("username"));
				 user.setPassword(resultSet.getString("password"));
				 user.setEmail(resultSet.getString("email"));
				 user.setRole(resultSet.getString("role"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			if(resultSet != null){
				try{
					resultSet.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			if(preparedStatement != null){
				try{
					preparedStatement.close();
				}catch(SQLException e){
					e.printStackTrace();
				}
			}
			DBUtil.closeConnection(connection);
		}
		return user;
	}
	public void addUser(User user) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBUtil.closeConnection(connection);
        }
    }
}
