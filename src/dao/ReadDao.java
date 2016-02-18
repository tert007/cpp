package dao;

import entity.User;

import java.util.List;

/**
 * Created by Alexander on 16.02.2016.
 */
public interface ReadDao {
    User findUser();
    List<User> getUserCollection();
}
