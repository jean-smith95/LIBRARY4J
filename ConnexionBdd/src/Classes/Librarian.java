package Classes;

import Classes.User;
import Classes.Book;

public class Librarian extends User{
    public Librarian(String Name, String LastName, int ID, String Password) {
        super(Name, LastName, ID, Password);
    }

    public String getUserName(User p1){
        return p1.Name;
    }
    public String getUserLastName(User p1){
        return p1.LastName;
    }

    public String getUserID(User p1){
        return  p1.Name+" ID="+p1.ID;
    }

    public String getBookID(Book b1){
        return b1.title+" ID="+b1.ID;
    }

    public void getBookQuantity(Book b1){
        System.out.println(b1.title+" Quantity="+b1.quantity);
    }


    public void LoanBooktoUser(Book b1,User p1){
        if(b1.quantity == 0){
            System.out.println(b1.title+" by "+b1.author+" is not available");
        }
        else{
            b1.quantity--;
        }
        p1.addBook(b1);

    }

    public void ReturnBook(Book b1,User p1){
        b1.quantity++;
        p1.removeBooks(b1);
    }

    public String getListofBorrowedBooksbyUser(User p1){
        return "User:"+p1.Name+" "+p1.getListofBorrwedBooks();
    }



}
