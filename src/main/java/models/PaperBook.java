package models;

public class PaperBook extends Book {
    private int pageCount;

    public PaperBook(String title, String author, String isbn, int pageCount) {
        super(title, author, isbn);
        this.pageCount = pageCount;
    }

    public int getPageCount() { return pageCount; }

    @Override
    public String getBookType() { return "كتاب ورقي"; }

    @Override
    public String toString() {
        return super.toString() + " | عدد الصفحات: " + pageCount;
    }
}