package Classes;

public class Book {

    private String title;
    private String author;
    private int idBook;
    private int isbn;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public Book(String title, String author, int ID, int isbn, int idUser){
        this.title = title;
        this.author = author;
        this.idBook = ID;
        this.isbn = isbn;
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getIdBook() {
        return idBook;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Book{" +

                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ID='" + idBook + '\'' +
                '}';
    }
}
