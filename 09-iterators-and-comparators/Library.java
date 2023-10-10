import java.util.Iterator;

public class Library implements Iterable<Book> {

    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private class LibIterator implements Iterator<Book> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < books.length;
        }

        @Override
        public Book next() {
            Book book = books[index];
            index++;
            return book;
        }

    }

}
