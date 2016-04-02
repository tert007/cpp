package entity;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Vadim on 02.04.2016.
 */
public class FilmGenreHelper {
    private Map<FilmGenre,String> genres = new HashMap<FilmGenre,String>();

    public FilmGenreHelper(){
        genres.put(FilmGenre.COMEDY,"Комедия");
        genres.put(FilmGenre.DRAMA,"Драмма");
    }

    public String GetGenreString(FilmGenre genre){
        return genres.get(genre);
    }
}
