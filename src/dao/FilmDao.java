package dao;

import entity.Film;

import java.util.List;

/**
 * Created by Alexander on 02.04.2016.
 */
public interface FilmDao {
    Film findFilmByTitle();
    List<Film> getFilmsCollections();
}
