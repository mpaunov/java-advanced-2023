import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Book bookOne = new Book("Animal Farm", 3, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 43, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 13);

        if (bookOne.compareTo(bookTwo) < 0) {
            System.out.printf("%s is before %s%n", bookOne.getTitle(), bookTwo.getTitle());
        } else if (bookOne.compareTo(bookTwo) > 0) {
            System.out.printf("%s is before %s%n", bookTwo.getTitle(), bookOne.getTitle());
        } else {
            System.out.println("Book are equal");
        }

        List<Book> books = new ArrayList<>(List.of(bookThree, bookOne, bookTwo));

        books.sort(new BookComparator());

        books.forEach(b -> System.out.println(b.getTitle()));

        books.sort(new BookComparatorByYear());

        books.forEach(b -> System.out.println(b.getTitle()));

        books.sort(Comparator.comparingInt(b -> b.getAuthors().size()));

        books.forEach(b -> System.out.println(b.getTitle()));

        books.sort(new Book.BookComparatorByAuthorsCount());

    }

}
