import BDD.Connexion;
import BDD.UserSession;
import Classes.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
        String user = username.getText();
        String mdp = password.getText();
        if(username.getText().isEmpty() && password.getText().isEmpty())
        {
            wrongcred.setText("PLEASE ENTER YOUR CREDS");
        }
        else{
            Connection cnt = Connexion.connectorDB();
            try {
                Statement st = cnt.createStatement();
                ResultSet res = st.executeQuery("SELECT * FROM users WHERE pseudo = '" + user + "' AND password =  '" + mdp+"'");
                res.next();
                User user1 = new User(res.getString("pseudo"), "fd", res.getInt("idUser"), res.getString("password"));
                if(res.getString("Type").equals("User")) {
                    if (user.equals(user1.getName()) && mdp.equals(user1.getPassword())) {
                         UserSession session = UserSession.getInstance(res.getString("pseudo"),res.getInt("idUser"));


                        m.changeScene("dashboard.fxml");
                        wrongcred.setText("Success !!!");
                    }
                }
                else{
                    if (user.equals(user1.getName()) && mdp.equals(user1.getPassword())) {
                        wrongcred.setText("Success Librarian !!!");
                        UserSession.getInstance(res.getString("pseudo"),res.getInt("idUser"));

                        m.changeScene("LibrarianDashboard.fxml");
                    }


                }
            } catch (SQLException throwables) {
                wrongcred.setText("Wrong credentials");
                throwables.printStackTrace();

            }
        }
    /*    if(user.toString().equals("admin") && password.getText().toString().equals("admin123"))
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
        }*/
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




       /* else if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin123"))
        {
            wrongcred.setText("Success !!!");

            m.changeScene("dashboard.fxml");
        }
        else
    {
        wrongcred.setText("WRONG CREDENTIALS!!!");
    }
    } */

    /*public void SignupClicked(ActionEvent event) throws IOException
    {
        GoToSignup();
    }

        private void GoToSignup() throws IOException {
            Main m1 = new Main();
            m1.changeScene("Signup.fxml");
        }

    } */



/*
*public class Main extends Application{
}
*/
