package dao.databaseimpl;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Alexander on 20.02.2016.
 */
public class Connector {
    private static final String url = "jdbc:mysql://localhost:3306/cinema";
    private static final String login = "root";
    private static final String password = "root";

    protected static Connection connection = null;

    protected Connector(){
        try {
            if (connection == null){
                Class.forName("com.mysql.jdbc.Driver");

                Driver driver = new FabricMySQLDriver();
                DriverManager.registerDriver(driver);

                connection = DriverManager.getConnection(url, login, password);
            }
        }
        catch (ClassNotFoundException | SQLException ex) {
            //throw new DatabaseDaoException;
        }
    }

    protected void closeConnection(){
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException ex) {
                //throw new DaoException(ex);
            }
        }
    }

    protected void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            //throw new DaoException(ex);
        }
    }

    protected void closeResultSet(ResultSet resultSet){
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            //throw new DaoException(ex);
        }
    }
}
