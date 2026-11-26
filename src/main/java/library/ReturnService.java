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
        if (!records.containsKey(sid)) {
            throw new IllegalStateException("没有借阅记录");
        }
        records.remove(sid);
        Book book = books.get(isbn);
        book.setStock(book.getStock() + 1);
    }
}
