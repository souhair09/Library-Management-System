import models.*;
import services.LibraryService;
import java.util.Scanner;

public class Main {
    private static LibraryService library = new LibraryService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== نظام المكتبة =====");
            System.out.println("1. إضافة كتاب");
            System.out.println("2. إضافة مستعير");
            System.out.println("3. إعارة كتاب");
            System.out.println("4. إعادة كتاب");
            System.out.println("5. عرض الكتب");
            System.out.println("0. خروج");
            System.out.print("اختر: ");
            
            switch (scanner.nextInt()) {
                case 1: addBook(); break;
                case 2: addBorrower(); break;
                case 3: borrowBook(); break;
                case 4: returnBook(); break;
                case 5: library.getAllBooks().forEach(System.out::println); break;
                case 0: System.exit(0);
                default: System.out.println("خيار غير صحيح!");
            }
            scanner.nextLine();
        }
    }

    private static void addBook() {
        System.out.print("نوع الكتاب (1. إلكتروني / 2. ورقي): ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("العنوان: ");
        String title = scanner.nextLine();
        
        System.out.print("المؤلف: ");
        String author = scanner.nextLine();
        
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        
        if (type == 1) {
            System.out.print("صيغة الملف: ");
            library.addBook(new EBook(title, author, isbn, scanner.nextLine()));
        } else {
            System.out.print("عدد الصفحات: ");
            library.addBook(new PaperBook(title, author, isbn, scanner.nextInt()));
        }
    }

    private static void addBorrower() {
        System.out.print("اسم المستعير: ");
        String name = scanner.nextLine();
        
        System.out.print("الرقم الجامعي: ");
        library.addBorrower(new Borrower(name, scanner.nextLine()));
    }

    private static void borrowBook() {
        System.out.print("أدخل ISBN الكتاب: ");
        Book book = library.findBookByIsbn(scanner.nextLine());
        
        System.out.print("أدخل الرقم الجامعي: ");
        Borrower borrower = library.findBorrowerById(scanner.nextLine());
        
        if (book != null && borrower != null) {
            library.borrowBook(book, borrower);
        }
    }

    private static void returnBook() {
        System.out.print("أدخل ISBN الكتاب: ");
        Book book = library.findBookByIsbn(scanner.nextLine());
        
        System.out.print("أدخل الرقم الجامعي: ");
        Borrower borrower = library.findBorrowerById(scanner.nextLine());
        
        if (book != null && borrower != null) {
            library.returnBook(book, borrower);
        }
    }
}