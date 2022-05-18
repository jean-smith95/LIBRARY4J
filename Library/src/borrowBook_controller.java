import BDD.Connexion;
import BDD.UserSession;
import Classes.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class borrowBook_controller {
    public borrowBook_controller(){

    }
    @FXML
    private TableView<Book> book_table;
    @FXML
    private TableColumn<Book,Integer> idBook;


    @FXML
    private TableColumn<Book,String> title;
    @FXML
    private TableColumn<Book,String> author;
    @FXML
    private TableColumn<Book,Integer> isbn;
    @FXML
    private TextField id;
    @FXML
    private Button borrow_Button;
    @FXML
    private Label Sucess;




    public void initialize()  {
        Connection cnt = Connexion.connectorDB();
        ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            Statement st = cnt.createStatement();

            //Execute th
            ResultSet res = st.executeQuery("SELECT * FROM books WHERE idUser IS NULL ");
            while (res.next()) {
                list.add(new Book(res.getString("title"),res.getString("author"),res.getInt("idBook"),res.getInt("isbn"),res.getInt("idUser")));

            }
                idBook.setCellValueFactory(new PropertyValueFactory<Book,Integer>("idBook"));
                title.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
            author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
            isbn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("isbn"));

            book_table.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void borrowClicked(ActionEvent actionEvent){
        BorrowBook();
    }
    public void BorrowBook(){
        String idBook = id.getText();
        Connection cnt = Connexion.connectorDB();
        Statement st = null;
        String state= "\'En attente\'";

        //SQL Request for say which user has borrowed the book
        String req = "UPDATE books  SET idUser = "+UserSession.instance.getIdUser()+" WHERE idBook = "+idBook+";";
        String req2 = "INSERT into `loans`(idUser,idBook,borrowDate,Statut) VALUES ((SELECT idUser FROM users WHERE pseudo ='"+ UserSession.instance.getUserName() +"'), "+idBook+",NOW(),"+state+" );";
        System.out.println(req);
        try {
            st = cnt.createStatement();
            st.execute(req);
            st.execute(req2);
            System.out.println("Emprunt Réussie");
            Sucess.setText("Success loan");
            initialize();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }





}
