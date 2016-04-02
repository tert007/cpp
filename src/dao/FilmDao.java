package dao;

import entity.Film;

import java.sql.Date;
import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public interface FilmDao {
    Film findFilmByTitle(String title);
    Film findFilmById(int id);
    List<Film> findFilmsByDate(Date date);
    List<Film> getFilmsCollections();
}
