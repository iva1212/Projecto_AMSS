/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
public class AgregarTema {
    private static Stage window;
    private static Label labelMateria;
    private static Label labelTema;
    private static Button btnAceptar;
    private static TextArea areaTema;
    private static HBox hbox;
    private static HBox middle;
    private static HBox bottom;
    private static VBox vboxPantalla;
    
    public static void display(ComboBox combo){
        window= new Stage();
        
        labelMateria=new Label("Materia:");
        labelTema=new Label("Tema:");
        
        btnAceptar=new Button("Agregar");
        
        areaTema=new TextArea();
        
        hbox=new HBox(20);
        middle=new HBox(20);
        bottom=new HBox();
        vboxPantalla=new VBox(40);
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Tema");
        window.setMinWidth(400);
        window.setMinHeight(200);
        
        
        labelMateria.setTextFill(Color.web("#000000"));
        labelMateria.setStyle(Style.Montserrat_Light);
        labelTema.setTextFill(Color.web("#000000"));
        labelTema.setStyle(Style.Montserrat_Light);
        
        btnAceptar.setPrefSize(150, 30);
        
        btnAceptar.setStyle(Style.Lion);
        btnAceptar.setOnMouseEntered(e->btnAceptar.setStyle(Style.Lion_default));
        btnAceptar.setOnMouseExited(e->btnAceptar.setStyle(Style.Lion));
        
        areaTema.setPrefSize(200, 20);
        
        
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        hbox.setStyle("-fx-background-color: #73A86F");
        middle.setStyle("-fx-background-color: #73A86F");
        bottom.setStyle("-fx-background-color: #73A86F");
        hbox.getChildren().addAll(labelMateria,combo);
        middle.getChildren().addAll(labelTema,areaTema);
        bottom.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
            
        vboxPantalla.getChildren().addAll(r,hbox,middle,bottom);
        vboxPantalla.setStyle("-fx-background-color: #73A86F");
        
        btnAceptar.setOnAction(e-> Controlador_AgregarTema.btnAgrTema_AT(combo));//cambiar cuando se implemente la base de datos
        Scene scene=new Scene(vboxPantalla);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }

    public static Stage getWindow() {
        return window;
    }

    public static TextArea getAreaTema() {
        return areaTema;
    }
    
    
}
