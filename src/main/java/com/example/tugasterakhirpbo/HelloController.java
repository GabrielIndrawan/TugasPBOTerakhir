package com.example.tugasterakhirpbo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/tugaspboterakhir";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    @FXML
    private TableView<Mahasiswa> mhsTabel = new TableView<Mahasiswa>();
    @FXML
    private TextField textfieldNim;
    @FXML
    private TextField textfieldNama;
    @FXML
    private TextField textfieldNilai;
    @FXML
    private TableColumn<Mahasiswa,String> clmNim = new TableColumn<Mahasiswa, String>();
    @FXML
    private TableColumn<Mahasiswa,String> clmNama = new TableColumn<Mahasiswa, String>();
    @FXML
    private TableColumn<Mahasiswa, Integer> clmNilai = new TableColumn<Mahasiswa, Integer>();
    private ObservableList<Mahasiswa> data = FXCollections.observableArrayList();;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            rs = conn.createStatement().executeQuery("SELECT * FROM mhs");
            while(rs.next()){
                data.add(new Mahasiswa(rs.getString("nim"),rs.getString("nama"),rs.getInt("nilai")));
            }
            clmNim.setCellValueFactory(new PropertyValueFactory<>("nim"));
            clmNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
            clmNilai.setCellValueFactory(new PropertyValueFactory<>("nilai"));
            mhsTabel.setItems(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void input()
    {
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO mhs(nim,nama,nilai) VALUES(?,?,?)");
            statement.setString(1,textfieldNim.getText());
            statement.setString(2,textfieldNama.getText());
            statement.setString(3,textfieldNilai.getText());
            statement.execute();
            data.add(new Mahasiswa(textfieldNim.getText(),textfieldNama.getText(),Integer.valueOf(textfieldNilai.getText())));
            mhsTabel.setItems(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete(){
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            PreparedStatement statement = conn.prepareStatement("INSERT INTO mhs(nim,nama,nilai) VALUES(?,?,?)");
            statement.setString(1,textfieldNim.getText());
            statement.setString(2,textfieldNama.getText());
            statement.setString(3,textfieldNilai.getText());
            statement.execute();
            data.add(new Mahasiswa(textfieldNim.getText(),textfieldNama.getText(),Integer.valueOf(textfieldNilai.getText())));
            mhsTabel.setItems(data);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}