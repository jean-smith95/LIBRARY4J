package Classes;

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
        return " ID=";
    }






    public String getListofBorrowedBooksbyUser(User p1){
        return "User:"+p1.Name+" "+p1.getListofBorrwedBooks();
    }



}
