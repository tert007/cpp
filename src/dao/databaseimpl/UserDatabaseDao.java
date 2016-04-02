package dao.databaseimpl;

import entity.User;
import dao.UserDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public class UserDatabaseDao extends Connector implements UserDao {

    private static UserDatabaseDao instance = new UserDatabaseDao();

    private UserDatabaseDao() {
        super();
    }

    public static UserDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public User findUserById(int id) {
        return null;
    }

    @Override
    public List<User> getUsersCollection() {
        List<User> users = new ArrayList<User>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");

            while (resultSet.next()) {
                users.add(new User(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getInt(5)));
            }

            return users;
        }
        catch (SQLException ex){
            //throw new DaoException
        }
        finally {
            closeStatement(statement);
            closeResultSet(resultSet);
        }
        return null;
    }
}
