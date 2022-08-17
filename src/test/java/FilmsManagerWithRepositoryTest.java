import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FilmsManagerWithRepositoryTest {

    FilmRepository repo = new FilmRepository();

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

    @BeforeEach
    public void Setup() {
        repo.save(item1);
        repo.save(item2);
        repo.save(item3);
        repo.save(item4);
        repo.save(item5);
        repo.save(item6);
        repo.save(item7);
        repo.save(item8);
        repo.save(item9);
        repo.save(item10);
        repo.save(item11);
    }

    @Test
    public void getFindById1() {
        Film expected = null;
        Film actual = repo.findById(15);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getFindById2() {
        Film expected = item5;
        Film actual = repo.findById(5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getRemoveById() {
        Film[] expected = {item2, item3, item4, item5, item6, item7, item8, item9, item10, item11};
        repo.removeById(1);
        Film[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void getRemoveAll() {
        Film[] expected = {};
        repo.removeAll();
        Film[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}