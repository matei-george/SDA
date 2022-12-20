module com.example.laborator10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laborator10 to javafx.fxml;
    exports com.example.laborator10;
}