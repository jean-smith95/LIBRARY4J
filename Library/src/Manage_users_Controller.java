import javafx.event.ActionEvent;

import java.io.IOException;

public class Manage_users_Controller {
    public Manage_users_Controller()
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

    public void LogoutClicked(ActionEvent event) {
        Main m = new Main();
        try {
            m.changeScene("Login.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SearchUserClicked(ActionEvent event) {
    }

    public void ListUsersClicked(ActionEvent event) {
    }

    public void DeleteUserClicked(ActionEvent event) {
    }

    public void AddUserClicked(ActionEvent event) {
    }
}
