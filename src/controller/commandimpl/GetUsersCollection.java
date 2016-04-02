package controller.commandimpl;

import com.sun.deploy.net.HttpRequest;
import controller.Command;
import dao.DaoFactory;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersCollection implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
