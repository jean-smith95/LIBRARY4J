package Classes;


import Classes.Book;

import java.util.ArrayList;
import java.util.List;

public class User {
    final String Name;
    final String LastName;
    public int ID;
    protected String Password;
    private List<Book> Books;

    public User(String Name, String LastName, int ID , String Password){
        this.Name = Name ;
        this.LastName = LastName;
        this.ID = ID;
        this.Password = Password;
        this.Books = new ArrayList<>();
    }

    public int getID(){
        return this.ID;
    }

    public String AsktoBorrowBook(Book b1){
        if(b1.quantity == 0){
        return "Sorry "+this.Name+" the book you asked for : "+b1.title+" is currently unavailable";
        }
        else {
            return this.Name + " ask to borrow the book: " + b1.title;
        }
    }

    public String ReturnBorrowedBook(Book b1){
        return this.Name+" wants to return the book: "+b1.title;
    }

    public String getCurrentBorrowedBooks(Book b1){
        return this.Name+" currently you have loan"+b1.title;
    }

    public void addBook(Book b1){
        this.Books.add(b1);
    }

    public void removeBooks(Book b1){

        this.Books.remove(b1);

    }

    public String getListofBorrwedBooks(){
        return "Borrowed Books:"+Books;
    }
}
