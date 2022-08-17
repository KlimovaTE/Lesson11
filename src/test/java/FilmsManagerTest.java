import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FilmsManagerTest {


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
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);
        repo.addNewFilm(item7);


        Film[] expected = {item1, item2, item7};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddNewFilm2() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item10);

        Film[] expected = {item10};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testAddNewFilm3() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item10);
        repo.addNewFilm(item1);

        Film[] expected = {item10, item1};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll1() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);

        Film[] expected = {item1, item2};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll2() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item2);

        Film[] expected = {item2};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindAll3() {
        FilmsManager repo = new FilmsManager();

        Film[] expected = {};
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms1() {
        FilmsManager repo = new FilmsManager(2);
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);
        repo.addNewFilm(item3);
        repo.addNewFilm(item4);
        repo.addNewFilm(item5);
        repo.addNewFilm(item6);
        repo.addNewFilm(item7);
        repo.addNewFilm(item8);
        repo.addNewFilm(item9);
        repo.addNewFilm(item10);
        repo.addNewFilm(item11);

        Film[] expected = {item11, item10};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms2() {
        FilmsManager repo = new FilmsManager(6);
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);

        Film[] expected = {item2, item1};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithNumberRecentlyAddedFilms3() {
        FilmsManager repo = new FilmsManager(6);

        Film[] expected = {};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms1() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);
        repo.addNewFilm(item3);
        repo.addNewFilm(item4);
        repo.addNewFilm(item5);
        repo.addNewFilm(item6);
        repo.addNewFilm(item7);
        repo.addNewFilm(item8);
        repo.addNewFilm(item9);
        repo.addNewFilm(item10);
        repo.addNewFilm(item11);

        Film[] expected = {item11, item10, item9, item8, item7, item6, item5, item4, item3, item2};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms2() {
        FilmsManager repo = new FilmsManager();
        repo.addNewFilm(item1);
        repo.addNewFilm(item2);
        repo.addNewFilm(item3);
        repo.addNewFilm(item4);
        repo.addNewFilm(item5);
        repo.addNewFilm(item6);
        repo.addNewFilm(item7);

        Film[] expected = {item7, item6, item5, item4, item3, item2, item1};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWithOutNumberRecentlyAddedFilms3() {
        FilmsManager repo = new FilmsManager();

        Film[] expected = {};
        Film[] actual = repo.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}

