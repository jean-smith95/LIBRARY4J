import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class dashboard_controller {
    public  dashboard_controller()
    {

    }
    @FXML
    private Button m_users;
    @FXML
    private Button history;
    @FXML
    private Button m_books;
    @FXML
    private Button settings;
    @FXML
    private Button logout;
    @FXML
    private Button home;



    
    public  void M_UsersCliked(ActionEvent event) throws IOException
    {
        GoToBooks();
    }
    private void GoToUsers() throws IOException
    {
        Main m = new Main();
        m.changeScene("Manage_Users.fxml");
    }
    public void M_BooksClicked(ActionEvent event) throws IOException
    {
        GoToBooks();
    }
    private void GoToBooks() throws IOException
    {
        Main m = new Main();
        m.changeScene("borrowBook.fxml");
    }



    public void HistoryClicked(ActionEvent event) {
    }

    public void SettingsClicked(ActionEvent event) {
    }

    public void LogoutClicked(ActionEvent event) {
        Main m = new Main();
        try {
            m.changeScene("Login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void HomeClicked(ActionEvent event) {
        Main m = new Main();

        try {

            m.changeScene("login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
