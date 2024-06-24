<%@ page import="java.sql.*,yourpackage.UserDAO, yourpackage.User" %>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    /* if (username != null && password != null) {
        UserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        if (user != null) {
            session.setAttribute("user", user);
            response.sendRedirect("tourPackages.jsp");
        } 
        else {
            out.println("Invalid username or password");
        }
    } */
    
    User user = null;
	Connection connection = null;
	ResultSet resultSet = null;
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelagency","root","21082004Ravi@");
	Statement st=connection.createStatement();
	resultSet = st.executeQuery("select * from users where username='"+ username + "' and password='" + password +"'");
	
	if(resultSet.next()){
		 user = new User();
		 user.setId(resultSet.getInt("id"));
		 user.setUsername(resultSet.getString("username"));
		 user.setPassword(resultSet.getString("password"));
		 user.setEmail(resultSet.getString("email"));
		 user.setRole(resultSet.getString("role"));
		 
		 session.setAttribute("user", user);
         response.sendRedirect("tourpackages.jsp");
	}
	else {
           out.println("Invalid username or password");
    }
		
%>