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
public class BorrarTema {
    private static Stage window;
    private static Label labelMateria;
    private static Label labelTema;
    private static Button btnAceptar;
    private static HBox hboxMateria;
    private static HBox hboxTema;
    private static HBox hboxButton;
    private static VBox vbox;
    
    
    public static void display(ComboBox combo,ComboBox combo2){
        window= new Stage();
        labelMateria=new Label("Materia:");
        labelTema=new Label("Tema:");
        btnAceptar=new Button("Borrar");
        hboxMateria=new HBox(20);
        hboxTema=new HBox(20);
        hboxButton=new HBox();
        vbox=new VBox(40);
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Borrar Tema");
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
        
        
        
       
        hboxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxMateria.setStyle("-fx-background-color: #FBF7E9");
        hboxTema.setStyle("-fx-background-color: #FBF7E9");
        hboxButton.setStyle("-fx-background-color: #FBF7E9");
        hboxMateria.getChildren().addAll(labelMateria,combo);
        hboxTema.getChildren().addAll(labelTema,combo2);
        hboxButton.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
        vbox.getChildren().addAll(r,hboxMateria,hboxTema,hboxButton);
        vbox.setStyle("-fx-background-color: #FBF7E9");
        btnAceptar.setOnAction(e->Controlador_BorrarTema.btnDeletTema_BT(combo, combo2));//cambiar cuando se implemente la base de datos
        Scene scene=new Scene(vbox);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }

    public static Stage getWindow() {
        return window;
    }
    
}
