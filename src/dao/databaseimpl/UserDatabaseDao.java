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
    private final String AllFromFilmsQuery = "SELECT * FROM users";
    public static final String columnId = "id_user";
    public static final String columnLogin = "login";
    public static final String columnPassword = "password";
    public static final String columnEmail = "email";
    public static final String columnBonus = "bonus_count";


    private UserDatabaseDao() {
        super();
    }

    public static UserDatabaseDao getInstance(){
        return instance;
    }

    @Override
    public User findUserById(int id) {
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(AllFromFilmsQuery + " WHERE " +
                                                UserDatabaseDao.columnId + "=" + id);
            return this.setToUser(resultSet);
        }
        catch (SQLException ex){
            return  null;
        }
    }

    @Override
    public List<User> getUsersCollection() {
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM users");
            return usersToCollection(resultSet);
        }
        catch (SQLException ex){
            //throw new DaoException
        }
        finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    private List<User> usersToCollection(ResultSet usersSet){
        List<User> result = new ArrayList<User>();
        try {
            while (usersSet.next()) {
                result.add(this.setToUser(usersSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private User setToUser(ResultSet user){
        User result = new User();
        try {
            result.setId(user.getInt(UserDatabaseDao.columnId));
            result.setLogin(user.getString(UserDatabaseDao.columnLogin));
            result.setPassword(user.getString(UserDatabaseDao.columnPassword));
            result.setEmail(user.getString(UserDatabaseDao.columnEmail));
            result.setBonusCount(Integer.parseInt(user.getString(UserDatabaseDao.columnBonus)));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



}
