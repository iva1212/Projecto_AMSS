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
public class AgregarMateria {
    private static Stage window;
    private static Label text;
    private static Button btnAceptar;
    private static TextArea area;
    private static HBox middle;
    private static HBox bottom;
    private static VBox vbox;
    
    public static void display(){
        window= new Stage();
        text=new Label("Materia:");
        btnAceptar=new Button("Agregar");
        area=new TextArea();
        middle=new HBox(20);
        bottom=new HBox();
        vbox=new VBox(40);
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Materia");
        window.setMinWidth(400);
        window.setMinHeight(200);
        
        text.setTextFill(Color.web("#000000"));
        text.setStyle(Style.Montserrat_Light);
        
        btnAceptar.setPrefSize(150, 30);
        
        
        
        btnAceptar.setStyle(Style.Lion);
        btnAceptar.setOnMouseEntered(e->btnAceptar.setStyle(Style.Lion_default));
        btnAceptar.setOnMouseExited(e->btnAceptar.setStyle(Style.Lion));
        
        area.setPrefSize(200, 20);
        
        
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        middle.setStyle("-fx-background-color: #73A86F");
        bottom.setStyle("-fx-background-color: #73A86F");
        middle.getChildren().addAll(text,area);
        bottom.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
        vbox.getChildren().addAll(r,middle,bottom);
        vbox.setStyle("-fx-background-color: #73A86F");
        
        btnAceptar.setOnAction(e-> {
            Controlador_Botones.btnAgrMateria_AM(area);
        });//cambiar cuando se implemente la base de datos
        
       
        Scene scene=new Scene(vbox);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }

    public static Stage getWindow() {
        return window;
    }
    
}
