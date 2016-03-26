package controller;

import controller.CommandHelper;
import controller.CommandName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Alexander on 16.02.2016.
 */
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CommandHelper commandHelper = new CommandHelper();

        String command = request.getParameter("command");

        /*
        Map<String, String[]> parameters = request.getParameterMap();
        for (Map.Entry<String, String[]> parameter : parameters.entrySet()) {
            CommandName commandName = CommandName.valueOf(parameter.getKey());
            Object resultObject = commandHelper.getCommand(commandName).execute(parameter.getValue());

            request.setAttribute(parameter.getKey(), resultObject);
        }

        request.getRequestDispatcher("result.jsp").forward(request, response);
        */

    /*
        if (request.getParameter("getUsersCollections") != null){


            //commandHelper.getCommand(CommandName.GET_USERS_COLLECTION).execute(new Object());

            //DaoFactory daoFactory = DaoFactory.getDaoFactory();

            //List<User> usersList = daoFactory.getUserDao().getUsersCollection();
            request.setAttribute("usersList", commandHelper.getCommand(CommandName.GET_USERS_COLLECTION).execute(new Object()));
            request.getRequestDispatcher("result.jsp").forward(request, response);
        }
        */
    }
}
