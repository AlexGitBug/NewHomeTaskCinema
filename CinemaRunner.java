package CollectionLesson.HomeTask.List.LinkedMap;

import com.sun.security.jgss.GSSUtil;
import com.sun.source.tree.Tree;

import java.time.Month;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CinemaRunner {

    public static void main(String[] args) {

        Map<Integer, TreeSet<Film>> findFilm = new LinkedHashMap<>();
        findFilm.put(2022, new TreeSet<>(List.of(new Film(100, 2022, Month.JANUARY, Genre.COMEDY, 8))));

        Cinema cinema = new Cinema(findFilm);
        cinema.addFilm(new Film(9, 2023, Month.JULY, Genre.ACTION, 7));
        cinema.addFilm(new Film(123, 2021, Month.APRIL, Genre.MUSICAL, 9));
        cinema.addFilm(new Film(1001, 2021, Month.MAY, Genre.MELODRAMA, 10));
        cinema.addFilm(new Film(145, 2022, Month.AUGUST, Genre.COMEDY, 5));
        cinema.addFilm(new Film(345, 2021, Month.AUGUST, Genre.ACTION, 3));

     //   System.out.println("Вывести на консоль все фильмы по порядку добавления " + findFilm);
        for (Map.Entry<Integer, TreeSet<Film>> entry : findFilm.entrySet()) {
            System.out.println("Вывод всех фильмов по порядку добавления(по годам): " + entry);
        }

        cinema.getFilmYear(2022);
        cinema.getFilmYearAndMonth(2021, Month.JULY);
        cinema.getFilmGenre(Genre.MUSICAL);
        System.out.println("Топ 10 фильмов из ассоц. массива: ");
        Set<Film> top10 = cinema.getListTop10(findFilm);
        for (Film film : top10) {
            System.out.println(film);
        }

    }
}

