/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class AgregarVariable {
     public static void display(){
        Stage window= new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Variable");
        window.setMinWidth(400);
        window.setMinHeight(200);
        
        Label text=new Label("Variable:");
        Label text2=new Label("Rango Min:");
        Label text3=new Label("Rango Max:");
        text.setTextFill(Color.web("#000000"));
        text.setStyle(Style.Montserrat_Light);
        text2.setTextFill(Color.web("#000000"));
        text2.setStyle(Style.Montserrat_Light);
        text3.setTextFill(Color.web("#000000"));
        text3.setStyle(Style.Montserrat_Light);
        
        Button btnAceptar=new Button("Agregar");
        btnAceptar.setPrefSize(150, 30);
        
        
        
        btnAceptar.setStyle(Style.Lion);
        btnAceptar.setOnMouseEntered(e->btnAceptar.setStyle(Style.Lion_default));
        btnAceptar.setOnMouseExited(e->btnAceptar.setStyle(Style.Lion));
        
        TextArea area=new TextArea();
        TextArea area2=new TextArea();
        TextArea area3=new TextArea();
        area.setPrefSize(200, 20);
        area2.setPrefSize(70, 20);
        area3.setPrefSize(70, 20);
        
        HBox hbox=new HBox(20);
        HBox hbox2=new HBox(20);
        HBox bottom=new HBox();
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setStyle("-fx-background-color: #73A86F");
        hbox2.setStyle("-fx-background-color: #73A86F");
        bottom.setStyle("-fx-background-color: #73A86F");
        hbox.getChildren().addAll(text,area);
        hbox2.getChildren().addAll(text2,area2,text3,area3);
        
        bottom.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
        VBox vbox=new VBox(40);
        vbox.getChildren().addAll(r,hbox,hbox2,bottom);
        vbox.setStyle("-fx-background-color: #73A86F");
        
        btnAceptar.setOnAction(e-> {
            ControladorBD.agrMateria(area.getText());
            window.close();
        });//cambiar cuando se implemente la base de datos
        
       
        Scene scene=new Scene(vbox);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }
}
