/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
        Inciso[] I;
        I = new Inciso[4];
        char c='a';
        for(int i=0;i<4;++i){
            I[i]=new Inciso(c);
            c++;
        }
        Stage window= new Stage();
        
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
        
        Button closeButton=new Button("Cerrar");
        closeButton.setOnAction(e -> {
            window.close();});
        closeButton.setPrefSize(100, 30);
        HBox top=new HBox(10);
        HBox bottom=new HBox(10);
        VBox middle=new VBox(10);
        HBox secPregunta=new HBox(10);
        secPregunta.getChildren().addAll(text4,preg);
        top.setStyle("-fx-background-color: #73A86F");
        top.getChildren().addAll(text1,comboBox,text2,comboBox2,text3,combo3);
        top.setAlignment(Pos.TOP_LEFT);
        top.setPrefSize(800, 100);
        bottom.setAlignment(Pos.TOP_LEFT);
        bottom.setPrefSize(800, 50);
        bottom.getChildren().addAll(closeButton);
        middle.getChildren().addAll(secPregunta);
        combo3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(combo3.getValue()=="Opcion Multiple"){
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta,I[0].display(),I[1].display(),I[2].display(),I[3].display());
                }
                else{
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta);
                }
            }
                    
                    });
                
        
        BorderPane borderPane=new BorderPane();
        borderPane.setStyle("-fx-background-color: #73A86F");
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        borderPane.setLeft(middle);
        Scene scene=new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
        
    }
  
}
