import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {

    FilmRepository repo= new FilmRepository();
    FilmsManager manager = new FilmsManager(repo);

    Film item1 = new Film("Бладшот");
    Film item2 = new Film("Вперед");
    Film item3 = new Film("Отель 'Белград'");
    Film item4 = new Film("Джентльмены");
    Film item5 = new Film("Человек-невидимка");
    Film item6 = new Film("Тролли. Мировой тур");
    Film item7 = new Film("Номер один");
    Film item8 = new Film("Вверх");
    Film item9 = new Film("Элементарно");
    Film item10 = new Film("Шерлок");
    Film item11 = new Film("Чёрное зеркало");

    @Test
    public void testAddNewFilm1() {
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item7);


        Film[] expected = {item1, item2, item7};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddNewFilm2() {
        manager.addNewFilm(item10);

        Film[] expected = {item10};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddNewFilm3() {
        manager.addNewFilm(item10);
        manager.addNewFilm(item1);

        Film[] expected = {item10, item1};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll1() {
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);

        Film[] expected = {item1, item2};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll2() {
        manager.addNewFilm(item2);

        Film[] expected = {item2};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll3() {

        Film[] expected = {};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms1() {
        FilmsManager manager = new FilmsManager(repo,2);
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);
        manager.addNewFilm(item5);
        manager.addNewFilm(item6);
        manager.addNewFilm(item7);
        manager.addNewFilm(item8);
        manager.addNewFilm(item9);
        manager.addNewFilm(item10);
        manager.addNewFilm(item11);

        Film[] expected = {item11, item10};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms2() {
        FilmsManager manager = new FilmsManager(repo,6);
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);

        Film[] expected = {item2, item1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms3() {
        FilmsManager manager = new FilmsManager(repo,6);

        Film[] expected = {};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms1() {
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);
        manager.addNewFilm(item5);
        manager.addNewFilm(item6);
        manager.addNewFilm(item7);
        manager.addNewFilm(item8);
        manager.addNewFilm(item9);
        manager.addNewFilm(item10);
        manager.addNewFilm(item11);

        Film[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms2() {
        manager.addNewFilm(item1);
        manager.addNewFilm(item2);
        manager.addNewFilm(item3);
        manager.addNewFilm(item4);
        manager.addNewFilm(item5);
        manager.addNewFilm(item6);
        manager.addNewFilm(item7);

        Film[] expected = {item7, item6, item5, item4, item3, item2, item1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms3() {

        Film[] expected = {};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}

