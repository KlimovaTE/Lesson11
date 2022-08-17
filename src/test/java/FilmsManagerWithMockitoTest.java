import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class FilmsManagerWithMockitoTest {

    FilmRepository repo = Mockito.mock(FilmRepository.class);
    FilmsManager manager = new FilmsManager(repo);

    Film item1 = new Film("Бладшот", 1);
    Film item2 = new Film("Вперед", 2);
    Film item3 = new Film("Отель 'Белград'", 4);
    Film item4 = new Film("Джентльмены", 100);
    Film item5 = new Film("Человек-невидимка", 5);
    Film item6 = new Film("Тролли. Мировой тур", 6);
    Film item7 = new Film("Номер один", 7);
    Film item8 = new Film("Вверх", 8);
    Film item9 = new Film("Элементарно", 9);
    Film item10 = new Film("Шерлок", 10);
    Film item11 = new Film("Чёрное зеркало", 11);

    @Test
    public void testFindAll1() {
        Film[] films = {item1, item6, item2};
        doReturn(films).when(repo).findAll();

        Film[] expected = {item1, item6, item2};
        Film[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testFindLastWithNumberRecentlyAddedFilms2() {
        FilmsManager manager = new FilmsManager(repo,20);
        Film[] films = {item1, item2, item1, item10};
        doReturn(films).when(repo).findAll();

        Film[] expected = {item10,item1,item2,item1};
        Film[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}
