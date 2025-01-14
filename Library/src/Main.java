import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application{

    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        primaryStage.setResizable(false);



           Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));

        //  primaryStage.setTitle("Hello World!");

        primaryStage.setScene(new Scene(root, 1280, 800));
        primaryStage.show();
    }


    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
// write your code here
        Application.launch(args);
    }
}
