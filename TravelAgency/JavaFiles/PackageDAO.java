package yourpackage;

import java.sql.*;
import java.util.*;

public class PackageDAO {
    public List<Package> getAllPackages() {
        List<Package> packages = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DBUtil.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM packages");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Package pkg = new Package();
                pkg.setId(resultSet.getInt("id"));
                pkg.setDestination(resultSet.getString("destination"));
                pkg.setPrice(resultSet.getDouble("price"));
                pkg.setDuration(resultSet.getInt("duration"));
                pkg.setDescription(resultSet.getString("description"));
                packages.add(pkg);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DBUtil.closeConnection(connection);
        }

        return packages;
    }
}