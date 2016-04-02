package dao.databaseimpl;

import dao.FilmDao;
import entity.Film;
import entity.FilmGenre;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public class FilmDatabaseDao extends Connector implements FilmDao {

    private static FilmDatabaseDao instance = new FilmDatabaseDao();

    private FilmDatabaseDao() {
        //Создаст Connector, т.е соедеение бд
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }


    @Override
    public Film findFilmByTitle() {
        return null;
    }

    @Override
    public List<Film> getFilmsCollections() {
        List<Film> films = new ArrayList<Film>();

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM films");

            while (resultSet.next()) {

                Film film = new Film();
                film.setId(resultSet.getInt("id"));
                film.setTitle(resultSet.getString("title"));
                film.setDescription(resultSet.getString("description"));
                film.setDirector(resultSet.getString("director"));
                film.setGenre(FilmGenre.valueOf(resultSet.getString("genre")));
                film.setDate(resultSet.getDate("date"));

                films.add(film);
            }

            return films;
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
