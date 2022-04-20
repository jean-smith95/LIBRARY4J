import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Login_Controller  {
    public Login_Controller(){

   }
    @FXML
    private Button buttonlogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label wrongcred;




    public void LoginClicked(ActionEvent event) throws IOException{
        CheckLogin();
    }

    private void CheckLogin() throws IOException {
        Main m = new Main();
        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin123"))
        {
            wrongcred.setText("Success !!!");

            m.changeScene("dashboard.fxml");
        }
        else if(username.getText().isEmpty() && password.getText().isEmpty())
        {
            wrongcred.setText("PLEASE ENTER YOUR CREDS");
        }
        else
    {
        wrongcred.setText("WRONG CREDENTIALS!!!");
    }
    }

    public void SignupClicked(ActionEvent event) throws IOException
    {
        GoToSignup();
    }
    private void GoToSignup() throws IOException{
        Main m = new Main();
        m.changeScene("Signup.fxml");
    }

}
