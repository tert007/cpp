package controller.commandimpl;

import com.sun.deploy.net.HttpRequest;
import controller.Command;
import dao.DaoFactory;
import entity.User;

import java.util.List;

public class GetUsersCollections implements Command{

    @Override
    public String execute(HttpRequest request) {
        return null;

        //return DaoFactory.getDaoFactory().getUserDao().getUsersCollection();
    }
}
