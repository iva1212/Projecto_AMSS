/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class AgregarPregunta {
    public static void display(ComboBox comboBox,ComboBox comboBox2){
        
        int numIncisos=4;
        List<Inciso> I= new ArrayList<>();
        for(int i=0;i<numIncisos;++i){
            Inciso in=new Inciso((char) (I.size()+'a'));
            I.add(in);
        }
        Inciso abierta=new Inciso("Respuesta","Respuesta abierta",true);
        Inciso verdad=new Inciso("a","Verdadero",false);
        Inciso falso=new Inciso("b","Falso",false);
        Stage window= new Stage();
        
        TableView table=new TableView();
        TableColumn VariableCol = new TableColumn("Variable");
        TableColumn MinCol = new TableColumn("Rango Min");
        TableColumn MaxCol = new TableColumn("Rango Max");
        VariableCol.setPrefWidth(75);
        MinCol.setPrefWidth(75);
        MaxCol.setPrefWidth(75);
        table.getColumns().addAll(VariableCol,MinCol,MaxCol);
        table.maxHeight(100);
        table.prefWidth(135);
     
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Pregunta");
        window.setMinWidth(800);
        window.setMinHeight(700);
        
        ObservableList<String> options = 
        FXCollections.observableArrayList(
            "Opcion Multiple",
            "Abierta",
            "V o F"
        );
        ComboBox combo3=new ComboBox(options);
        combo3.setPrefSize(150, 30);
        
        TextArea preg=new TextArea();
        preg.setPrefSize(350, 80);
        
        Label text1=new Label("Materia:");
        Label text2=new Label("Tema:");
        Label text3=new Label("Tipo:");
        Label text4=new Label("Pregunta:");
     
        //Styling the main title
        text1.setTextFill(Color.web("#000000"));
        text1.setStyle(Style.Montserrat_Light);
        text2.setTextFill(Color.web("#000000"));
        text2.setStyle(Style.Montserrat_Light);
        text3.setStyle(Style.Montserrat_Light);
        text3.setTextFill(Color.web("#000000"));
        text4.setStyle(Style.Montserrat_Light);
        text4.setTextFill(Color.web("#000000"));
        
        Button btnAgregar=new Button("Agregar");
        Button mas=new Button("+");
        Button menos=new Button("-");
        Button agrVariable=new Button("Agregar Variable");
        
        btnAgregar.setStyle(Style.Lion);
        mas.setStyle(Style.Lion);
        menos.setStyle(Style.Lion);
        agrVariable.setStyle(Style.Lion);
        
        
        btnAgregar.setOnMouseEntered(e->btnAgregar.setStyle(Style.Lion_default));
        btnAgregar.setOnMouseExited(e->btnAgregar.setStyle(Style.Lion));
        mas.setOnMouseEntered(e->mas.setStyle(Style.Lion_default));
        mas.setOnMouseExited(e->mas.setStyle(Style.Lion));
        menos.setOnMouseEntered(e->menos.setStyle(Style.Lion_default));
        menos.setOnMouseExited(e->menos.setStyle(Style.Lion));
        agrVariable.setOnMouseEntered(e->agrVariable.setStyle(Style.Lion_default));
        agrVariable.setOnMouseExited(e->agrVariable.setStyle(Style.Lion));
        
        btnAgregar.setPrefSize(150, 30);
        mas.setPrefSize(25, 25);
        menos.setPrefSize(25, 25);
        
        HBox top=new HBox(10);
        HBox bottom=new HBox(10);
        VBox middle=new VBox(10);
        VBox tabla=new VBox(10);
        HBox secPregunta=new HBox(10);
        HBox masMenos=new HBox(10);
        secPregunta.getChildren().addAll(text4,preg);
        top.setStyle("-fx-background-color: #73A86F");
        top.getChildren().addAll(text1,comboBox,text2,comboBox2,text3,combo3);
        top.setAlignment(Pos.TOP_LEFT);
        top.setPrefSize(800, 100);
        bottom.setAlignment(Pos.TOP_RIGHT);
        tabla.setAlignment(Pos.CENTER_RIGHT);
        bottom.setPrefSize(800, 50);
        bottom.getChildren().addAll(btnAgregar);
        middle.getChildren().addAll(secPregunta);
        masMenos.getChildren().addAll(mas,menos);
        tabla.getChildren().addAll(table,agrVariable);
        combo3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(combo3.getValue()=="Opcion Multiple"){
                    middle.getChildren().clear();
                    middle.getChildren().add(secPregunta);
                    for(int i=0;i<numIncisos;i++){
                        middle.getChildren().add(I.get(i).display());
                    }
                    middle.getChildren().add(masMenos);
                }
                else if(combo3.getValue()=="Abierta"){
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta,abierta.display());
                }
                else if(combo3.getValue()=="V o F"){
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta,verdad.display(),falso.display());
                }
            }
                    
                    });
        btnAgregar.setOnAction(e -> {
            window.close();});
        mas.setOnAction(e->{
            Inciso in=new Inciso((char) (I.size()+'a'));
            I.add(in);
            middle.getChildren().clear();
            middle.getChildren().add(secPregunta);
            for(int i=0;i<I.size();i++){
                middle.getChildren().add(I.get(i).display());
            }
            middle.getChildren().add(masMenos);
        });   
        menos.setOnAction(e ->{
            I.remove(I.size()-1);
            middle.getChildren().clear();
            middle.getChildren().add(secPregunta);
            for(int i=0;i<I.size();i++){
                middle.getChildren().add(I.get(i).display());
            }
            middle.getChildren().add(masMenos);
        });
        
                
        BorderPane borderPane=new BorderPane();
        borderPane.setStyle("-fx-background-color: #73A86F");
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        borderPane.setLeft(middle);
        borderPane.setRight(tabla);
        Scene scene=new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
        
    }
  
}
