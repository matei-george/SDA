package com.example.laborator10;

import com.example.laborator10.ArboreBinarDeCautare;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class PanouGrafic extends Application {
    private Stage mainStage;
    private String sirIntrodus = "";

    private TextField nodCrt = new TextField();
    private TextArea zonaTextArea = getTextArea("Observatii:");
    private Button btnInserare = new Button("Inserare");
    private Button btnCauta = new Button("Cauta");
    private Button btnEliminare = new Button("Elimina");
    private Button btnOpen = new Button("Citire fisier");
    private Button btnSave = new Button("Salvare in fisier");
    ArboreBinarDeCautare arb = new ArboreBinarDeCautare();

    private File deschideFisier(boolean citire) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Deschide fisier cu cuvinte");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));

        File selectedFile = citire ? fileChooser.showOpenDialog(mainStage) : fileChooser.showSaveDialog(mainStage);

        if (selectedFile != null) {
            zonaTextArea.appendText("\n" + selectedFile);
        }

        return selectedFile;
    }


    private static TextArea getTextArea(String text){
        TextArea textAreaComponent = new TextArea();
        textAreaComponent.appendText(text);
        textAreaComponent.setPrefWidth(500);
        return textAreaComponent;
    }

    private String formatTree(String tree) {
        return "[ " + tree.substring(0, tree.length() - 2) + " ]";
    }

    private ListView getSelectionList() {
        ListView<String> list = new ListView<>();
        list.setPrefWidth(100);
        list.setPrefHeight(100);
        ObservableList<String> data = FXCollections.observableArrayList("RSD", "SRD", "SDR", "Nivele");
        list.setItems(data);

        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue) {
                String val = "";
                switch (newvalue) {
                    case "RSD":
                        val = arb.RSD();
                        break;
                    case "SRD":
                        val = arb.SRD();
                        break;
                    case "SDR":
                        val = arb.SDR();
                        break;
                    case "Nivele":
                        val = ", ";
                        break;
                }

                val = formatTree(val);
                zonaTextArea.setText("Observatii:\n" + val);
            }
        });

        return list;
    }

    private HBox operatiiArbore() {
        HBox panou = new HBox(10, nodCrt, btnInserare, btnCauta, btnEliminare, btnOpen, btnSave);

        btnInserare.setOnAction(a -> {
            sirIntrodus = nodCrt.getText().trim();

            if( sirIntrodus.length() != 0) {
                zonaTextArea.appendText("\n" + sirIntrodus);
                zonaTextArea.appendText(arb.add(sirIntrodus) ? " s-a inserat" : " este deja in arbore");
                nodCrt.setText("");
            }
        });

        btnCauta.setOnAction(a -> {
            sirIntrodus = nodCrt.getText().trim();

            if( sirIntrodus.length() != 0) {
                zonaTextArea.appendText("\n" + sirIntrodus);
                zonaTextArea.appendText(arb.contains(sirIntrodus) ? " exista in arbore" : " nu exista in arbore");
                nodCrt.setText("");
            }
        });

        btnEliminare.setOnAction(a -> {
            sirIntrodus = nodCrt.getText().trim();

            if( sirIntrodus.length() != 0) {
                zonaTextArea.appendText("\n" + sirIntrodus);
                zonaTextArea.appendText(arb.removeRec(sirIntrodus) ? " a fost eliminat" : " nu exista in arbore");
                nodCrt.setText("");
            }
        });

        btnOpen.setOnAction(e -> {
            File fin = deschideFisier(true);
            if(fin == null) return;

            Scanner myReader = null;

            try {
                myReader = new Scanner(fin);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                arb.add(data);
            }
            myReader.close();

            zonaTextArea.setText("Observatii:\n" + formatTree(arb.RSD()));
        });

        btnSave.setOnAction(e -> {
            String fileName = "C:\\Users\\Danicu\\Desktop\\lab9.txt";

            String str = arb.RSD();
            str = str.substring(0, str.length() - 2);

            BufferedWriter writer = null;

            try {
                writer = new BufferedWriter(new FileWriter(fileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                writer.write(str.replace(", ", "\n"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            try {
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        return panou;
    }

    private HBox traversari() {
        return new HBox(10, getSelectionList(), zonaTextArea);
    }



    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        VBox panouGrafic = new VBox(20, operatiiArbore(), traversari());
        panouGrafic.setPadding(new Insets(10));
        Scene scena = new Scene(panouGrafic, 640, 250);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Arbore binar de cautare");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}