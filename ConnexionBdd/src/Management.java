import Classes.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Management {


        // method to register
    public static void registrer(String pseudo, String password){
        Connection cnt = Connexion.connectorDB();
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
                  user1 = new User(res.getString("pseudo"),"fd",Id,res.getString("password"));

                 ResultSet res2 = st.executeQuery("SELECT * FROM books WHERE idUser = " + Id);
                System.out.println(user1);
                while (res2.next()) {
                    // print the borrowed books
                    System.out.println("Vous avez emprunté " + res2.getString("title"));
                }


            }

        catch(SQLException throwables){
                throwables.printStackTrace();
                System.out.println("L'utilisateur n'existe pas");

            }

       return user1;
    }
    // sql request to delete a user
    public static void deleteUser(String pseudo){
        Connection cnt  = Connexion.connectorDB();
        pseudo = "\'"+pseudo+"\'";
        String req =  "DELETE FROM users WHERE pseudo= "+pseudo+";";
        try {
            Statement st = cnt.createStatement();
            st.execute(req);
            System.out.println(pseudo+" a été supprimé");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    //method to borrow books
    public static void loanBooktoUserDB(String pseudo,int IDBook){
        Connection cnt = Connexion.connectorDB();
        Statement st = null;
        pseudo = "\'"+pseudo +"\'";
        //SQL Request for say which user has borrowed the book
        String req = "UPDATE books  SET idUser = (SELECT idUser FROM users WHERE pseudo = "+pseudo+") WHERE idBook = "+IDBook+";";
       String req2 = "INSERT into `loans`(idUser,idBook,borrowDate) VALUES ((SELECT idUser FROM users WHERE pseudo = "+pseudo+"), "+IDBook+",NOW(),NOW());";
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
    public static void ReturnBooktoUser(String title) {
        Connection cnt = Connexion.connectorDB();
        Statement st = null;


        //SQL Request for deleting the current
        String req = "UPDATE books SET idUser = null WHERE title = '"+title+"';";
        String req2 = "UPDATE loans SET currentDate = NOW() WHERE idBook = (SELECT idBook FROM books WHERE title = '"+title+"');";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);
            st.execute(req2);
            System.out.println("Retour Réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
