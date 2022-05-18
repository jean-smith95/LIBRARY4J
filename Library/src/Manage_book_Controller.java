import BDD.UserSession;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Manage_book_Controller {

    /*exemple possible
    private void insertButton() {
        String query = "insert into books values("+idField.getText()+",'"+titleField.getText()+"','"+authorField.getText()+"',"+yearField.getText()+","+pagesField.getText()+")";
        executeQuery(query);
        showBooks();
    }*/

    public Manage_book_Controller()
    {

    }

    public void HomeClicked(ActionEvent event) {
        Main m = new Main();
        try {
            m.changeScene("dashboard.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void ReturnBookClicked(ActionEvent event) {

    }

    public void AssignBookClicked(ActionEvent event) {
    }

    public void ListBooksClicked(ActionEvent event) {
    }

    public void IssueBookClicked(ActionEvent event) {
    }

    public void AddBookClicked(ActionEvent event) {
    }

    public void LogoutClicked(ActionEvent event) {
        Main m = new Main();
        try {
            UserSession.instance.cleanUserSession();
            m.changeScene("Login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
