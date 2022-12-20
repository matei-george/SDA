package com.example.demo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class PanouGrafic extends Application {
    private Stage mainStage;
    private String sirIntrodus="";
    private TextField nodCrt = new TextField();
    private Button btnInserare = new Button("Inserare");
    private Button btnCauta = new Button("Cauta");
    private Button btnEliminare = new Button("Eliminare");
    private Button btnOpen = new Button("Citire Fisier");
    private Button btnSave   = new Button("Salvare in fisier");
    private TextArea zonaTextArea=new TextArea("TextArea");
    private ListView<Object> arb=new ListView<>();

    // . . .
    private HBox operatiiArbore() {

        HBox panou = new HBox(10, nodCrt, btnInserare, btnCauta, btnEliminare,
                btnOpen, btnSave);
        btnInserare.setOnAction(a -> {
                    sirIntrodus = nodCrt.getText().trim();
                    zonaTextArea.appendText("\n" + sirIntrodus);
                    if( sirIntrodus.length() != 0) {
                        zonaTextArea.appendText(arb.add(sirIntrodus) ? " s-a inserat"
                                : " este deja in arbore");
                        nodCrt.setText("");
                    }
                }
        );
        btnCauta.setOnAction(a -> {
// . . .
        });
        btnEliminare.setOnAction(a -> {
// . . .
        }
    });
btnOpen.setOnAction(e -> {
        File fin = deschideFisier(true);
        if(fin == null)
            return;
        try {
// citire fisier . . .
            zonaTextArea.setText("\nS-au citit "+ nr+ " cuvinte.");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    });
btnSave.setOnAction(e -> {
// . . .
    });
return panou;
}
    private HBox traversari() {
        zonaTextArea = getTextArea("Operatii:");
        return new HBox(10, getListaSelectie(), zonaTextArea);
    }
    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        VBox panouGrafic = new VBox(20, operatiiArbore(), traversari());
        panouGrafic.setPadding(new Insets(10));
        Scene scena = new Scene(panouGrafic, 630, 500);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Arbore binar de cautare");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
} // sfarsit clasa PanouGrafic