package com.example.laborator_11;

 import javafx.application.Application;
 import javafx.beans.value.ChangeListener;
 import javafx.beans.value.ObservableValue;
 import javafx.collections.FXCollections;
 import javafx.collections.ObservableList;
 import javafx.geometry.Insets;
 import javafx.scene.Node;
 import javafx.scene.Scene;
 import javafx.scene.control.*;
 import javafx.scene.layout.*;
 import javafx.stage.FileChooser;
 import javafx.stage.Stage;
 import java.io.*;
 import java.util.Scanner;


public class PanouGrafic extends Application {
    private Stage mainStage;
    private String sirIntrodus="";

    private TextField nodCrt = new TextField();
    private Button btnInserare = new Button("OK");
    private Button btnInserareNod = new Button("Nod frunza");
    //private Button btnCauta=new Button("Cauta");
    //private Button btnEliminare= new Button("Elimina");
    private Button btnOpen=new Button("Citeste fisier");
    private Button btnSave=new Button("Salvare in fisier");
    private TextArea zonaTextArea=new TextArea();
    private ArboreBinarSir arb= new ArboreBinarSir();
    private Label Insert = new Label("Introduceti fiul stang al nodului a:");


    private HBox operatiiArbore() {
        HBox panou = new HBox(10,Insert, nodCrt, btnInserare,btnInserareNod, /*btnCauta, btnEliminare,*/ btnOpen, btnSave);
        btnInserare.setOnAction(a -> {
                    sirIntrodus = nodCrt.getText().trim();
                    zonaTextArea.appendText("\n" + sirIntrodus);
                    if( sirIntrodus.length() != 0) {
                        zonaTextArea.appendText(arb.add(sirIntrodus) ? " a fost inserat" : " este deja in arbore");
                        nodCrt.setText("");
                    }
                }
        );

        btnInserareNod.setOnAction(a -> {
                    sirIntrodus = nodCrt.getText().trim();
                    zonaTextArea.appendText("\n" + sirIntrodus);
                    if( sirIntrodus.length() != 0) {
                        zonaTextArea.appendText(arb.add(sirIntrodus) ? " s-a inserat" : " este deja in arbore");
                        nodCrt.setText("");
                    }
                }
        );

       /* btnCauta.setOnAction(a -> {
            sirIntrodus = nodCrt.getText().trim();
            zonaTextArea.appendText("\nCauta "+sirIntrodus);
            if( sirIntrodus.length() != 0) {
                zonaTextArea.appendText(arb.contains(sirIntrodus) ? ": este in arbore" :": nu este in arbore");
                nodCrt.setText("");
            }



        }); */
       /* btnEliminare.setOnAction(a -> {
            sirIntrodus = nodCrt.getText().trim();
            zonaTextArea.appendText("\n"+sirIntrodus);
            if( sirIntrodus.length() != 0) {
                zonaTextArea.appendText(arb.remove(sirIntrodus) ? " s-a eliminat din arbore" :" nu este in arbore");
                nodCrt.setText("");
            }


        }); */
        btnOpen.setOnAction(e -> {
            File fin = deschideFisier(true);
            if(fin == null)
                return;
            try {
                Scanner scan=new Scanner(fin);
                int nr=0;
                while(scan.hasNextLine())
                {
                    arb.add(scan.nextLine());
                    nr++;
                }
                zonaTextArea.setText("Din fisierul\n\t >"+fin+"< \nS-au citit "+nr+ " elemente.");
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
        });
        btnSave.setOnAction(e -> {
            if(arb == null){
                zonaTextArea.appendText("\n--Nimic de salvat--\n");
            }else{
                File f = deschideFisier(false);
                PrintWriter prt = null;
                try{
                    prt = new PrintWriter(new FileWriter(f));
                    prt.print(arb.RSD());
                }catch (IOException eroare){
                }finally{
                    prt.close();
                }
            }
        });
        return panou;
    }

    private HBox traversari() {
        zonaTextArea = getTextArea("Operatii:");
        return new HBox(10, getListaSelectie(), zonaTextArea);
    }

    private Node getListaSelectie() {
        ListView<String> list = new ListView<>();
        list.setPrefWidth(200);
        list.setPrefHeight(100);
        ObservableList<String> data = FXCollections.observableArrayList(
                "Introducere arb.","RSD", "SRD", "SDR", "Nivele","_____________________________","Informatii");
        list.setItems(data);

        list.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                                 int nr = 1;
                                 public void changed(ObservableValue<? extends String> ov, final String oldvalue, final String newvalue) {
                                     zonaTextArea.appendText("\n" + "- " + newvalue+": ");
                                     if(newvalue instanceof String) {
                                         switch (newvalue) {
                                             case "Informatii":
                                                 zonaTextArea.appendText("Murarasu Matei - George, 3131b");
                                                 break;
                                             case "Introducere arb.":
                                                 //TODO
                                                 zonaTextArea.appendText("Nu functioneaza | In constructie");
                                                 break;
                                             case "RSD":
                                                 zonaTextArea.appendText(arb.RSD());
                                                 break;
                                             case "SRD":
                                                 zonaTextArea.appendText(arb.SRD());
                                                 break;
                                             case "SDR":
                                                 zonaTextArea.appendText(arb.SDR());
                                                 break;
                                             case "Nivele":
                                                 zonaTextArea.appendText(String.valueOf(arb.Nivele()+1));
                                                 break;
                                         }
                                     }
                                 }
                             }
                );
        return list;

    }


    private TextArea getTextArea(String s) {
        return zonaTextArea;
    }

    @Override
    public void start(Stage primaryStage) {
        mainStage = primaryStage;
        VBox panouGrafic = new VBox(20, operatiiArbore(), traversari());
        panouGrafic.setPadding(new Insets(10));
        Scene scena = new Scene(panouGrafic, 720, 250);
        primaryStage.setScene(scena);
        primaryStage.setTitle("Arbore binar de cautare");
        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
    private File deschideFisier(boolean citire) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Deschide fisier cu cuvinte");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        File selectedFile = citire ? fileChooser.showOpenDialog(mainStage)
                : fileChooser.showSaveDialog(mainStage);
        if (selectedFile != null) {
            zonaTextArea.appendText("\n" + selectedFile);
        }
        return selectedFile;
    }

}





