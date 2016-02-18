package dao.database;

import java.sql.*;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import dao.ReadDao;
import entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 16.02.2016.
 */
public class DatabaseReadDao implements ReadDao {

    private final static DatabaseReadDao instance = new DatabaseReadDao();

    public final static DatabaseReadDao getInstance() {
        return instance;
    }

    private DatabaseReadDao() {
    }

    @Override
    public User findUser() {
        return new User();
    }

    private static final String url = "jdbc:mysql://localhost:3306/cinema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    @Override
    public List<User> getUserCollection() {
        List<User> users = new ArrayList<>();

        try {
            Class.forName("com.mysql.jdbc.Driver");

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cinema", "root", "root");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)));
            }
        }
        catch (ClassNotFoundException | SQLException ex) {

        }
        finally {
            //return null;
        }

        return users;
    }
}


