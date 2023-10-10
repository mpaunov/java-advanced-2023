import java.util.Comparator;

public class BookComparatorByYear implements Comparator<Book> {

    @Override
    public int compare(Book first, Book second) {
        return Integer.compare(second.getYear(), first.getYear());
    }

}
