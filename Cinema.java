package CollectionLesson.HomeTask.List.LinkedMap;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив, где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */

import java.time.Month;
import java.util.*;

public class Cinema {


    private Map<Integer, TreeSet<Film>> filmByYear = new LinkedHashMap<>();

    public Cinema() {
    }

    public Cinema(Map<Integer, TreeSet<Film>> filmByYear) {
        this.filmByYear = filmByYear;
    }

    public void addFilm(Film film) {
        filmByYear.putIfAbsent(film.getYear(), new TreeSet<>());
        filmByYear.get(film.getYear()).add(film);
    }


    public void getFilmYear(int year) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            if (entry.getKey() == year) {
                System.out.println("Получить все фильмы по переданному году " + entry.getKey() + "  " + entry.getValue());
            }
        }
    }

    public void getFilmYearAndMonth(int year, Month month) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            if (entry.getKey() == year) {
                for (Film next : entry.getValue()) {
                    if (next.getMonth() == month) {
                        System.out.println("Получить все фильмы по переданному году и месяцу "+ next);
                    }
                }
            }
        }
    }

    public void getFilmGenre(Genre genre) {
        for (Map.Entry<Integer, TreeSet<Film>> entry : filmByYear.entrySet()) {
            for (Film next : entry.getValue()) {
                if (next.getGenre() == genre) {
                    System.out.println("получить все фильмы по переданному жанру " + next);
                }
            }
        }
    }

    public Set<Film> getListTop10(Map<Integer, TreeSet<Film>> film) {

        Set<Film> result = new TreeSet<>(new CompareRaiting());
        for (Map.Entry<Integer, TreeSet<Film>> entry : film.entrySet()) {
            TreeSet<Film> value = entry.getValue();
            result.addAll(value);
        }

        return result;
    }

    public static class CompareRaiting implements Comparator<Film> {
        @Override
        public int compare(Film o1, Film o2) {
            return Integer.compare(o2.getRating(), o1.getRating());
        }
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "films=" + filmByYear +
                '}';
    }

}
