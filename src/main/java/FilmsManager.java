
public class FilmsManager {
    private FilmRepository repo;
    int numberRecentlyAddedFilms = 10;

    public FilmsManager(FilmRepository repo) {
        this.repo = repo;
    }


    public FilmsManager(FilmRepository repo, int numberRecentlyAddedFilms) {
        this.repo = repo;
        this.numberRecentlyAddedFilms = numberRecentlyAddedFilms;
    }


    public Film[] findAll() {
        return repo.findAll();
    }

    public void addNewFilm(Film newFilm) {
        repo.save(newFilm);
    }

    public Film[] findLast() {
        Film[] all = findAll();
        int resultLength = all.length;
        if (resultLength > numberRecentlyAddedFilms) {
            resultLength = numberRecentlyAddedFilms;
        }
        Film[] reversed = new Film[resultLength];
        for (int i = 0; i < resultLength; i++) {
            reversed[i] = all[all.length - 1 - i];
        }
        return reversed;
    }
}