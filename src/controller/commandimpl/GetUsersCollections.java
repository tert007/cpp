package controller.commandimpl;

import controller.Command;
import dao.DaoFactory;
import entity.User;

import java.util.List;

public class GetUsersCollections implements Command{

    @Override
    public Object execute(String[] params) {
        return DaoFactory.getDaoFactory().getUserDao().getUsersCollection();
    }
}
