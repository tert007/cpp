package controller.commandimpl;

import controller.Command;
import dao.DaoFactory;
import dao.factoryimpl.DatabaseDaoFactory;
import entity.Film;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class GetFilmsCollection implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        DaoFactory daoFactory = DaoFactory.getDaoFactory();
        List<Film> films = daoFactory.getFilmDao().getFilmsCollections();

        request.setAttribute("films", films);

        //Будет Enum со страницами
        return "/result.jsp";
    }
}
