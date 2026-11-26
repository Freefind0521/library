package library;

import java.util.Map;

public class ReturnService {
    private final Map<String, String> records;
    private final Map<String, Book> books;

    public ReturnService(Map<String, String> records, Map<String, Book> books) {
        this.records = records;
        this.books = books;
    }

    public void giveBack(String sid, String isbn) {
        String borrowedIsbn = records.get(sid);
        if (borrowedIsbn == null) {
            throw new IllegalStateException("没有借阅记录");
        }
        if (!borrowedIsbn.equals(isbn)) {
            throw new IllegalStateException("借阅记录与所还图书不一致");
        }
        Book book = books.get(isbn);
        if (book == null) {
            throw new IllegalStateException("书不存在");
        }
        records.remove(sid);
        book.setStock(book.getStock() + 1);
    }
}
