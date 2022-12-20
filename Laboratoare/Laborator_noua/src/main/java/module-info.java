module com.example.laborator_noua {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.laborator_noua to javafx.fxml;
    exports com.example.laborator_noua;
}