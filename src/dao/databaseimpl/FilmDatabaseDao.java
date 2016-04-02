package dao.databaseimpl;

import dao.FilmDao;
import entity.Film;
import entity.FilmGenre;

import java.sql.Date;
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
    private final String AllFromFilmsQuery = "SELECT * FROM films";
    public static final  String columnId = "id";
    public static final String columnTitle = "title";
    public static final String columnDescription = "description";
    public static final String columnDirector = "director";
    public static final String columnGenre = "genre";
    public static final String columnDate = "date";



    private FilmDatabaseDao() {
        //Создаст Connector, т.е соедеение бд
        super();
    }

    public static FilmDatabaseDao getInstance(){
        return instance;
    }


    @Override
    public Film findFilmByTitle(String title) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                                                " WHERE " + FilmDatabaseDao.columnTitle + "='" + title + "'" );
            return this.setToFilm(resultSet);
        }
        catch (SQLException ex){

        }
        finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    @Override
    public Film findFilmById(int id) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                    " WHERE " + FilmDatabaseDao.columnId + "='" + id + "'" );
            return this.setToFilm(resultSet);
        }
        catch (SQLException ex){

        }
        finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    @Override
    public List<Film> findFilmsByDate(Date date) {
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery +
                    " WHERE " + FilmDatabaseDao.columnDate + "='" + date + "'" );
            return this.filmsToCollection(resultSet);
        }
        catch (SQLException ex){

        }
        finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    @Override
    public List<Film> getFilmsCollections() {
        List<Film> films = new ArrayList<Film>();
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(AllFromFilmsQuery);
            return this.filmsToCollection(resultSet);
        }
        catch (SQLException ex){

        }
        finally {
            closeResultSet(resultSet);
        }
        return null;
    }

    private List<Film> filmsToCollection(ResultSet filmsSet){
        List<Film> result = new ArrayList<Film>();
        try {
            while (filmsSet.next()) {
                result.add(this.setToFilm(filmsSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    private Film setToFilm(ResultSet film){
        Film result = new Film();
        try {
            result.setId(film.getInt(FilmDatabaseDao.columnId));
            result.setTitle(film.getString(FilmDatabaseDao.columnTitle));
            result.setDescription(film.getString(FilmDatabaseDao.columnDescription));
            result.setDirector(film.getString(FilmDatabaseDao.columnDirector));
            result.setGenre(FilmGenre.valueOf(film.getString(FilmDatabaseDao.columnGenre)));
            result.setDate(film.getDate(FilmDatabaseDao.columnDate));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
