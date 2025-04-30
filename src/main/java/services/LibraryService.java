package services;

import interfaces.Borrowable;
import models.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService implements Borrowable {
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowingProcess> borrowingProcesses;

    public LibraryService() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.borrowingProcesses = new ArrayList<>();
    }

    // إدارة الكتب
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book findBookByIsbn(String isbn) {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
    }

    // إدارة المستعيرين
    public void addBorrower(Borrower borrower) {
        borrowers.add(borrower);
    }

    public List<Borrower> getAllBorrowers() {
        return borrowers;
    }

    public Borrower findBorrowerById(String studentId) {
        return borrowers.stream()
                .filter(borrower -> borrower.getStudentId().equals(studentId))
                .findFirst()
                .orElse(null);
    }

    // عمليات الإعارة
    @Override
    public void borrowBook(Book book, Borrower borrower) {
        if (book.isBorrowed()) {
            System.out.println("الكتاب معار بالفعل!");
            return;
        }

        book.setBorrowed(true);
        borrower.borrowBook(book);
        borrowingProcesses.add(new BorrowingProcess(book, borrower, LocalDate.now()));
        System.out.println("تم إعارة الكتاب بنجاح!");
    }

    @Override
    public void returnBook(Book book, Borrower borrower) {
        if (!book.isBorrowed()) {
            System.out.println("الكتاب غير معار!");
            return;
        }

        book.setBorrowed(false);
        borrower.returnBook(book);
        
        borrowingProcesses.stream()
            .filter(process -> process.getBook().equals(book) && 
                    process.getBorrower().equals(borrower) && 
                    process.getReturnDate() == null)
            .findFirst()
            .ifPresent(process -> process.setReturnDate(LocalDate.now()));
        
        System.out.println("تم إعادة الكتاب بنجاح!");
    }

    public List<BorrowingProcess> getBorrowingHistory() {
        return borrowingProcesses;
    }

    public List<Book> getBorrowedBooksByBorrower(Borrower borrower) {
        return borrower.getBorrowedBooks();
    }
}