package BDD;
import Classes.Librarian;
import Classes.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Management {
    /*exemple
    private void insertButton() {
        String query = "insert into books values("+idField.getText()+",'"+titleField.getText()+"','"+authorField.getText()+"',"+yearField.getText()+","+pagesField.getText()+")";
        executeQuery(query);
        showBooks();
    }*/



        // method to register
    public static void registrer(String pseudo, String password) throws Exception{
        Connection cnt = Connexion.connectorDB(); // normalement c'est connectorDB() ici
        Statement st = null;
        pseudo = "\'"+pseudo +"\'";
        password = "\'"+password+"\'";
        //SQL request
        String req = "INSERT into users(pseudo,password) VALUES ( "+pseudo+", "+password+");";
        System.out.println(req);
        try {
            //execute
            st = cnt.createStatement();
            st.execute(req);

            System.out.println("Inscription réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
       }


    }
    //method to login
    public static User connection(String pseudo, String password) throws SQLException {
        Connection cnt = Connexion.connectorDB();
        Statement st = cnt.createStatement();
        pseudo = "\'"+pseudo +"\'";
        password = "\'"+password+"\'";
        User user1 = null;

        try {
            ResultSet res = st.executeQuery("SELECT * FROM users WHERE pseudo =" + pseudo + " AND password =  " + password);



            res.next();
            //SQL request to find the ID of the user
            int Id = res.getInt("idUser");
            System.out.println("Vous êtes bien connecté ");
            //SQL request for find the book that the user borrowed
            if(res.getString("Type")== "User") {
                user1 = new User(res.getString("pseudo"), "fd", Id, res.getString("password"));

                ResultSet res2 = st.executeQuery("SELECT * FROM books WHERE idUser = " + Id);
                System.out.println(user1);

                while (res2.next()) {
                    // print the borrowed books
                    System.out.println("Vous avez emprunté " + res2.getString("title"));
                }

            }
            if(res.getString("Type")=="Librarian"){
                user1 = new Librarian(res.getString("pseudo"), "fd", Id, res.getString("password"));
            }
        }

        catch(SQLException throwables){
            throwables.printStackTrace();
            System.out.println("L'utilisateur n'existe pas");
            System.exit(-1);

        }

        return user1;
    }
    //method to borrow books
    public static void loanBooktoUserDB(String pseudo,int IDBook) throws SQLException {
        Connection cnt = Connexion.connectorDB();
        Statement st = null;
        pseudo = "\'"+pseudo +"\'";
        //SQL Request for say which user has borrowed the book
        String req = "UPDATE books  SET idUser = (SELECT idUser FROM users WHERE pseudo = "+pseudo+") WHERE idBook = "+IDBook+";";
       String req2 = "INSERT into `loans`(idUser,idBook) VALUES ((SELECT idUser FROM users WHERE pseudo = "+pseudo+"), "+IDBook+");";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);
            st.execute(req2);
            System.out.println("Emprunt Réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void ReturnBooktoUser(String title,int NULL) throws SQLException {
        Connection cnt = Connexion.connectorDB();
        Statement st = null;

        //SQL Request for deleting the current
        String req = "UPDATE books SET idUser = "+NULL+"WHERE idBook = (SELECT idBook FROM books WHERE title="+title+");";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);

            System.out.println("Retour Réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
