public final class MovieFilter {

    private String namePattern;
    private Genre genre;

    public String getNamePattern() {
        return namePattern;
    }

    public void setNamePattern(String namePattern) {
        this.namePattern = namePattern;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return String.format("Filter with genre = %s and name = %s", genre, namePattern);
    }
}
