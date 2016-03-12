package dao;

import entity.User;

import java.util.List;

/**
 * Created by Alexander on 23.02.2016.
 */
public interface UserDao {
    User findUserById(int id);
    List<User> getUsersCollection();
}
