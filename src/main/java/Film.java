public class Film {
    private String nameMovie;
    private int id;

    public Film() {
    }

    public Film(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public Film(int id) {
        this.id = id;
    }

    public Film(String nameMovie, int id) {
        this.nameMovie = nameMovie;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }
}