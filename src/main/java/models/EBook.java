package models;

public class EBook extends Book {
    private String fileFormat;

    public EBook(String title, String author, String isbn, String fileFormat) {
        super(title, author, isbn);
        this.fileFormat = fileFormat;
    }

    public String getFileFormat() { return fileFormat; }

    @Override
    public String getBookType() { return "كتاب إلكتروني"; }

    @Override
    public String toString() {
        return super.toString() + " | صيغة الملف: " + fileFormat;
    }
}