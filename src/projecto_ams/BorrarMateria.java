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
public class BorrarMateria {
    private static Stage window;
    private static  Label labelBorrarMat;
    private static Button btnAceptar;
    private static HBox hboxMateria=new HBox(20);
    private static HBox hboxTema=new HBox();
    private static VBox vboxPantalla=new VBox(40);
    
     public static void display(ComboBox combo){
        window= new Stage();
        labelBorrarMat=new Label("Materia a Borrar:");
        btnAceptar=new Button("Borrar");
        hboxMateria=new HBox(20);
        hboxTema=new HBox();
        vboxPantalla=new VBox(40);
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Materia");
        window.setMinWidth(400);
        window.setMinHeight(200);
        
        labelBorrarMat.setTextFill(Color.web("#000000"));
        labelBorrarMat.setStyle(Style.Montserrat_Light);
        
        btnAceptar.setPrefSize(150, 30);
        btnAceptar.setStyle(Style.Lion);
        btnAceptar.setOnMouseEntered(e->btnAceptar.setStyle(Style.Lion_default));
        btnAceptar.setOnMouseExited(e->btnAceptar.setStyle(Style.Lion));
        
        
        
        hboxTema.setAlignment(Pos.BOTTOM_RIGHT);
        hboxMateria.setStyle("-fx-background-color: #73A86F");
        hboxTema.setStyle("-fx-background-color: #73A86F");
        hboxMateria.getChildren().addAll(labelBorrarMat,combo);
        hboxTema.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
        
        vboxPantalla.getChildren().addAll(r,hboxMateria,hboxTema);
        vboxPantalla.setStyle("-fx-background-color: #73A86F");
        Scene scene=new Scene(vboxPantalla);
        btnAceptar.setOnAction(e-> {
            ControladorBD.deletMateria((String) combo.getValue());
            window.close();
        });//cambiar cuando se implemente la base de datos
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }
}
