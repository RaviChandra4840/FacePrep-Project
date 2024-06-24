<%@ page import="java.util.List" %>
<%@ page import="yourpackage.PackageDAO" %>
<%@ page import="yourpackage.Package" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Initialize PackageDAO
    PackageDAO packageDAO = new PackageDAO();
    
    // Retrieve list of packages from DAO
    List<Package> packages = packageDAO.getAllPackages();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tour Packages</title>
    <link rel="stylesheet" href="tourpackagescss.css">
   
</head>
<body>
    <h2>Available Tour Packages</h2>
    
    <div class="package-list">
        <% if (packages != null && !packages.isEmpty()) { %>
            <% for (Package pkg : packages) { %>
                <div class="package">
                    <h3><%= pkg.getDestination() %></h3>
                    <p>Price: $<%= pkg.getPrice() %></p>
                    <p>Duration: <%= pkg.getDuration() %> days</p>
                    <p><%= pkg.getDescription() %></p>
                    <form action="bookPackage.jsp" method="post">
                        <input type="hidden" name="packageId" value="<%= pkg.getId() %>">
                        <input type="submit" value="Book Now">
                    </form>
                </div>
            <% } %>
        <% } else { %>
            <p>No tour packages available at the moment.</p>
        <% } %>
    </div>
    
    <a href="index.jsp">Back to Home</a>
</body>
</html>