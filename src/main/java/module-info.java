module com.example.tugasterakhirpbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tugasterakhirpbo to javafx.fxml;
    exports com.example.tugasterakhirpbo;
}