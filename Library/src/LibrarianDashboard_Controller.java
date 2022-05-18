import BDD.Connexion;
import Classes.Book;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LibrarianDashboard_Controller {
    public LibrarianDashboard_Controller(){

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
    private TableColumn<Book,Integer> idBorrower;
    @FXML
    private TextField txt_title;
    @FXML
    private TextField txt_author;
    @FXML
    private TextField txt_isbn;
    @FXML
    private TextField txt_id;


    public void initialize()  {
        Connection cnt = Connexion.connectorDB();
        ObservableList<Book> list = FXCollections.observableArrayList();
        try {
            Statement st = cnt.createStatement();

            //Execute th
            ResultSet res = st.executeQuery("SELECT * FROM books ");
            while (res.next()) {
                list.add(new Book(res.getString("title"),res.getString("author"),res.getInt("idBook"),res.getInt("isbn"),res.getInt("idUser")));

            }
            idBook.setCellValueFactory(new PropertyValueFactory<Book,Integer>("idBook"));
            title.setCellValueFactory(new PropertyValueFactory<Book,String>("title"));
            author.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
            isbn.setCellValueFactory(new PropertyValueFactory<Book,Integer>("isbn"));
            idBorrower.setCellValueFactory(new PropertyValueFactory<Book,Integer>("idUser"));
            book_table.setItems(list);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void updateClicked(ActionEvent actionEvent){
        updateBook();

    }
    public void updateBook(){
        String title = txt_title.getText();
        String author = txt_author.getText();
        String isbn = txt_isbn.getText();

        Connection cnt = Connexion.connectorDB();
        try {
            Statement st = cnt.createStatement();
            if(!(title.isEmpty())) {
                String req = "UPDATE books  SET title = '" + title + "' WHERE idBook = " + txt_id.getText() + ";";
                st.execute(req);
            }
            if(!(author.isEmpty())) {
                String req2 = "UPDATE books  SET author = '" + author + "' WHERE idBook = " + txt_id.getText() + ";";
                st.execute(req2);
            }
            if(!(isbn.isEmpty())) {
                String req3 = "UPDATE books  SET isbn = " + isbn + " WHERE idBook = " + txt_id.getText() + ";";
                st.execute(req3);
            }



            initialize();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
    public void addClicked(ActionEvent actionEvent){
        try {
            addBooktoDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addBooktoDB() throws SQLException {
        String title = txt_title.getText();
        String author = txt_author.getText();
        String isbn = txt_isbn.getText();
        Connection cnt = Connexion.connectorDB();
        try{
            Statement st = cnt.createStatement();
             st.execute("INSERT into`books`(title,author,isbn) VALUES ('"+title+"','"+author+"',"+isbn+");");
             initialize();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteClicked(ActionEvent actionEvent){
        try {
            deleteBooktoDB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deleteBooktoDB() throws SQLException{
        String id = txt_id.getText();
        Connection cnt = Connexion.connectorDB();
        try{
            Statement st = cnt.createStatement();
            st.execute("DELETE FROM books WHERE idBook ="+id+";");
            initialize();
        }
        catch(SQLException e){
            e.printStackTrace();
        }

    }
}
