public abstract class AbstractMovieListBean implements MovieListAction {

    private String searchString;

    @Override
    public void search() {
        System.out.println(String.format("searchString = %s", searchString));
    }

    @Override
    public String getBeanIdentity() {
        return String.valueOf(hashCode());
    }

    @Override
    public String getSearchString() {
        return searchString;
    }

    @Override
    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
