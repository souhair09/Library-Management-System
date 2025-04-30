package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public BorrowingProcess(Book book, Borrower borrower, LocalDate borrowDate) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
    }

    // Getters and Setters
    public Book getBook() { return book; }
    public Borrower getBorrower() { return borrower; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getReturnDate() { return returnDate; }
    public void setReturnDate(LocalDate returnDate) { this.returnDate = returnDate; }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String returnStr = (returnDate != null) ? returnDate.format(formatter) : "غير معاد بعد";
        return String.format("عملية الإعارة: %s => %s | تاريخ الإعارة: %s | تاريخ الإعادة: %s",
                borrower.getName(),
                book.getTitle(),
                borrowDate.format(formatter),
                returnStr);
    }
}