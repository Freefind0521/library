package library;

import java.util.Map;

public class BorrowService {
    private final Map<String, Book> books;
    private final Map<String, String> records;

    public BorrowService(Map<String, Book> books, Map<String, String> records) {
        this.books = books;
        this.records = records;
    }

    public void borrow(String sid, String isbn) {
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalStateException("书不存在");
        }
        if (book.getStock() <= 0) {
            throw new IllegalStateException("库存不足");
        }
        records.put(sid, isbn);
        book.setStock(book.getStock() - 1);
    }
}
