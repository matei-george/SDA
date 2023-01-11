package com.example.demo1;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OBradFrumos extends Application {
    private static TextArea rezultatCautare;
    private static Label nrInregistrari;
    private ImageView imageView = new ImageView();
    private Text topText;
    private Label eticValSelectata;
    private ListaMosului listaMosului;
    //
// puteti COMPLETA cu campuri și metode
//
    private static TextArea getTextArea(String textInitial) {
        TextArea ta = new TextArea();
        ta.appendText(textInitial);
        ta.setPrefWidth(400);
        ta.setPrefHeight(370);
        ta.setWrapText(true);
        return ta;
    }
    private ChoiceBox getChoiceBox(Map<String, List<Student>> map) {
        ObservableList<String> listaItemi;
//
// DE COMPLETAT listaItemi cu valorile cheilor din map
//
// sugestie clasa ConsultareDictionar din aplicația Dictionar ilustrat prezentata
// la cursul Controale grafice
//
        ChoiceBox<String> list = new ChoiceBox<>(listaItemi);
        list.getSelectionModel().selectedItemProperty()
                .addListener(new SelectareItem(map));
// este necesar sa scrieti clasa SelectareItem care sa implementeze ChangeListener
// scheletul clasei SelectareItem este prezentat în continuare
        return list;
    }
    Slider getSlider() {
        Slider valMedie;
//
// DE COMPLETAT
// sugestie pentru Slider: cursul Scurt tutorial (JavaFX),
// aplicația FORMULARE CU CONTROALE GRAFICE DIVERSE
//
        valMedie.valueProperty().addListener ( new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                double valSelectata = new_val.doubleValue();
                eticValSelectata.setText(String.format("Stud. cu media >= %.2f", new_val));
                List <Student> lstDupaMedie;
//
// DE COMPLETAT cu instructiunile pentru obtinerea listei studentilor
// lstDupaMedie care au media cel putin egala cu new_val
//
                afișareRezultat(lstDupaMedie);
            }
        });
        return valMedie;
    }
    // package protected
    static void afișareRezultat(List<Student> lstud) {
        //
// DE COMPLETAT
//
    }
    private BorderPane getPanou() {
        BorderPane panou = new BorderPane();
//
// DE COMPLETAT
//
// sugestie: aplicația Dictionar ilustrat prezentata
// la cursul Controale grafice
//
        Slider valMedie = getSlider();
// sugestie pentru Slider: cursul Scurt tutorial JavaFX,
// aplicația FORMULARE CU CONTROALE GRAFICE DIVERSE
        eticValSelectata = new Label(" . . . DE COMPLETAT . . . " );
        panou.setBottom(new HBox(10, valMedie, eticValSelectata));
        return panou;
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        listaMosului = new ListaMosului();
        Scene scena = new Scene(getPanou(), 700, 500);
        primaryStage.setScene(scena);
        primaryStage.setTitle("O, brad frumos!");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}