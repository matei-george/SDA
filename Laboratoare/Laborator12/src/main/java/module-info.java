module com.example.laborator12 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laborator12 to javafx.fxml;
    exports com.example.laborator12;
}