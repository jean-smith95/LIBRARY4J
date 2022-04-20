package BDD;


import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {
    public static Connection connectorDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver oki");
            //mdp Jean-Smith
            /*
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "SMith01022001**";
            */
            //mdpBenjamin
            String url = "jdbc:mysql://localhost:3308/library";
            String user = "root";
            String password = "ouy3quoh4aiH";
            Connection cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion bien établie ");

            return cnx;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}