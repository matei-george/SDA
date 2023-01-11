package com.example.laborator12;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.zip.CheckedOutputStream;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class OBradFrumos extends Application {
    FileInputStream input = new FileInputStream("D:\\Programare\\SDA\\Laboratoare\\Laborator12\\src\\main\\resources\\images\\741.jpg");
    private static TextArea rezultatCautare;
    private static Label nrInregistrari;
    private Text topText;
    private static Label Nume;
    private static Label Localitate;
    private static Button CitesteFisier;
    private static ChoiceBox NumeBox;
    private static ChoiceBox LocalitateBox;
    private static Label empty;
    private Label eticValSelectata;
    private ListaMosului listaMosului;

    public OBradFrumos() throws FileNotFoundException {
    }

    private static TextArea getTextArea(String textInitial) {
        TextArea ta = new TextArea();
        ta.appendText(textInitial);
        ta.setPrefWidth(400);
        ta.setPrefHeight(370);
        ta.setWrapText(true);
        return ta;
    }
    private ChoiceBox getChoiceBox(Map<String, List<Student>> map) {
        ObservableList<String> listaItemi=FXCollections.observableArrayList(map.keySet());
        //TODO
        ChoiceBox<String> list = new ChoiceBox<>(listaItemi);
        list.getSelectionModel().selectedItemProperty()
                .addListener(new SelectareItem(map));
        //TODO
        return list;
    }
    Slider getSlider() {
        Slider valMedie=new Slider(0,10,0);
        valMedie.setMajorTickUnit(0.5);
        valMedie.setPrefWidth(550);
        valMedie.setShowTickMarks(true);
        valMedie.setShowTickLabels(true);
        valMedie.valueProperty().addListener ( new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov,
                                Number old_val, Number new_val) {
                double valSelectata = new_val.doubleValue();
                eticValSelectata.setText(String.format("Stud. cu media >= %.2f", new_val));
                List <Student> lstDupaMedie;
            //TODO
            //afișareRezultat(lstDupaMedie);
            }
        });
        return valMedie;
    }
    // package protected
    static void afișareRezultat(List<Student> lstud) {
        //TODO
    }
    private BorderPane getPanou() {
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(300);
        imageView.setFitWidth(300);
        imageView.setTranslateY(75);
        BorderPane panou = new BorderPane();
        Slider valMedie = getSlider();
        empty=new Label("   ");
        NumeBox.setPrefWidth(150);
        LocalitateBox.setPrefWidth(150);
        Nume=new Label("        Nume");
        Localitate=new Label("Localitate");
        CitesteFisier=new Button("Citeste din fisier");
        panou.setTop(new HBox(25,Nume,NumeBox,Localitate,LocalitateBox,CitesteFisier));
        panou.setLeft(new HBox(5, empty,getTextArea("")));
        panou.setRight(new HBox(imageView));
        eticValSelectata = new Label("Stud. cu Media >=" );
        panou.setBottom(new HBox(1, valMedie, eticValSelectata));
        return panou;
    }
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        listaMosului = new ListaMosului();
        NumeBox=getChoiceBox(listaMosului.getMapNume());
        LocalitateBox=getChoiceBox(listaMosului.getMapLocalitate());
        Scene scena = new Scene(getPanou(), 700, 500);
        primaryStage.setScene(scena);
        primaryStage.setTitle("O, brad frumos!");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
