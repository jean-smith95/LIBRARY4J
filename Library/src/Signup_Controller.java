import BDD.Connexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Signup_Controller {
    public Signup_Controller(){

    }

    @FXML
    private Button buttonRegister;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label regSuccess;


    public void SignupRegister(ActionEvent actionEvent) throws IOException{
        UserRegistration();

    }
    public void UserRegistration(){
        Connection cnt = Connexion.connectorDB(); // normalement c'est connectorDB() ici
        Statement st = null;
        String user = username.getText();
        String mdp = password.getText();
        String req = "INSERT into users(pseudo,password,Type) VALUES ( '"+user+"', '"+mdp+"','User');";
        System.out.println(req);
        try {
            //execute
            st = cnt.createStatement();
            st.execute(req);

            System.out.println("Inscription réussie");
            regSuccess.setText("Success !!!");
            Main m = new Main();
            m.changeScene("Login.fxml");
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }


    }

    public void SignupClicked(ActionEvent actionEvent) {

        Main m = new Main();
        try {
            m.changeScene("Signup.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void LoginClicked(javafx.event.ActionEvent actionEvent) {

        Main m = new Main();
        try {
            m.changeScene("Signup.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

