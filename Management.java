import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Management {



    public static void registrer(String pseudo, String password){
        Connection cnt = Connexion.connectorDB();
        Statement st = null;
        pseudo = "\'"+pseudo +"\'";
        password = "\'"+password+"\'";
        String req = "INSERT into users(pseudo,password) VALUES ( "+pseudo+", "+password+");";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);

            System.out.println("Inscription réussie");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
       }


    }


}
