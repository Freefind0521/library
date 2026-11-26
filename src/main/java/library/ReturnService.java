package library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class ReturnService {
    private final Map<String, String> records;
    private final Map<String, Book> books;

    public ReturnService(Map<String, String> records, Map<String, Book> books) {
        this.records = records;
        this.books = books;
    }

    public String borrowedIsbn(String sid) {
        String isbn = records.get(sid);
        if (isbn == null) {
            throw new IllegalStateException("没有借阅记录");
        }
        return isbn;
    }

    public boolean needsReturnReminder(LocalDate dueDate, LocalDate today, int reminderDays) {
        if (dueDate == null || today == null) {
            throw new IllegalArgumentException("日期不能为空");
        }
        if (reminderDays < 0) {
            throw new IllegalArgumentException("提醒天数不能为负");
        }
        long daysLeft = ChronoUnit.DAYS.between(today, dueDate);
        return daysLeft >= 0 && daysLeft <= reminderDays;
    }

    public void giveBack(String sid, String isbn) {
        String recordedIsbn = borrowedIsbn(sid);
        if (!recordedIsbn.equals(isbn)) {
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
