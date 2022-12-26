module com.example.laborator_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laborator_11 to javafx.fxml;
    exports com.example.laborator_11;
}