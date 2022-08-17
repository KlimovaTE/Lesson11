public class FilmRepository {

    public FilmRepository() {
    }

    public FilmRepository(Film[] posters) {
        this.posters = posters;
    }

    private Film[] posters = new Film[0];

    public Film[] findAll() {
        return posters;
    }

    public void save(Film newFilm) {
        Film[] tmp = new Film[posters.length + 1];
        for (int i = 0; i < posters.length; i++) {
            tmp[i] = posters[i];
        }
        tmp[tmp.length - 1] = newFilm;
        posters = tmp;
    }

    public Film findById(int id) {
        if (id < posters.length) {
            return posters[id - 1];
        }
        return null;
    }

    public void removeById(int id) {
        Film[] tmp = new Film[posters.length - 1];
        int copyToIndex = 0;
        for (Film item : posters) {
            if (item.getId() != id) {
                tmp[copyToIndex] = item;
                copyToIndex++;
            }
        }
        posters = tmp;
    }

    public void removeAll() {
        posters = new Film[0];
    }
}
