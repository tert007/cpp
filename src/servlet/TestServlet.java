package servlet;

import dao.DaoFactory;
import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Alexander on 16.02.2016.
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");

        PrintWriter pw = resp.getWriter();

        if (req.getParameter("getUsersCollections") != null) {


            DaoFactory daoFactory = DaoFactory.getDaoFactory();

            for (User user: daoFactory.getReadDao().getUserCollection()) {
                pw.println(user.getId() + user.getLogin());
            }

        }
    }
}
