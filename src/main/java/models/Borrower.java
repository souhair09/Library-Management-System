package models;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private String name;
    private String studentId;
    private List<Book> borrowedBooks;

    public Borrower(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return String.format("المستعير: %s | الرقم الجامعي: %s | عدد الكتب المعارة: %d",
                name, studentId, borrowedBooks.size());
    }
}