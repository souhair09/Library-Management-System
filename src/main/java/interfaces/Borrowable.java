package interfaces;

import models.Book;
import models.Borrower;

public interface Borrowable {
    void borrowBook(Book book, Borrower borrower);
    void returnBook(Book book, Borrower borrower);
}