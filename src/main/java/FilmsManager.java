
public class FilmsManager {
    int numberRecentlyAddedFilms = 10;

    public FilmsManager() {
    }

    public FilmsManager(int numberRecentlyAddedFilms) {
        this.numberRecentlyAddedFilms = numberRecentlyAddedFilms;
    }

    public Film[] posters = new Film[0];

    public void addNewFilm(Film newFilm) {
        Film[] tmp = new Film[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = newFilm;
        posters = tmp;
    }

    public Film[] findAll() {
        return posters;
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