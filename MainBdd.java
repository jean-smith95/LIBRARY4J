import java.sql.*;
import java.util.Scanner;

public class MainBdd {

    public static void main(String[] args) throws SQLException {

        Connection cnt = Connexion.connectorDB();
        Statement st = cnt.createStatement();
        //Execute th
        ResultSet res = st.executeQuery("SELECT * FROM books");
        //Saisie d'un pseudo et mdp
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisissez un pseudo : ");
        String pseudo = sc.nextLine();
        System.out.println("Saisissez un mot de passe : ");
        String password = sc.nextLine();
        System.out.println("FIN ! ");
      // Management.registrer(pseudo,password);
       //Management.connection(pseudo,password);
       // Management.deleteUser(pseudo);
        Management.ReturnBooktoUser("One piece");
        while(res.next()){
           System.out.println("Livre :\nId :"+res.getString("idBook")+
                   "\nAuteur : "+res.getString("author")+
                  "\nTitre : "+res.getString("Title"));
       }
      //  Management.loanBooktoUserDB("js",2);
    }


}

