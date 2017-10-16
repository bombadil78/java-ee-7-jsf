public enum Genre {
    ACTION(0), HORROR(1), DRAMA(2), COMEDY(3);

    private final int ordering;

    Genre(int ordering) {
        this.ordering = ordering;
    }

    public static Genre fromOrdering(int ordering) {
        for (Genre g : values()) {
            if (g.ordering == ordering) return g;
        }
        throw new RuntimeException("Unknown ordering: " + ordering);
    }
}