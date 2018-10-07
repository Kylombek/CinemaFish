package kg.neobis.cinemafish.cinemasModel;

public class Film {
    private int id;
    private String name;
    private String image;
    private String imdb;
    private String premier_ua;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getPremier_ua() {
        return premier_ua;
    }

    public void setPremier_ua(String premier_ua) {
        this.premier_ua = premier_ua;
    }
}
