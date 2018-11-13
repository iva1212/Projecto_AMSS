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
    private static Stage window;
    private static Label labelVariable;
    private static Label labelRangoMin;
    private static Label labelRangoMax;
    private static Label lableVar;
    private static Button btnAceptar;
    private static TextArea areaRangoMin;
    private static TextArea areaRangoMax;
    private static HBox hboxVariable;
    private static HBox hboxRangos;
    private static HBox hboxButton;
    private static VBox vboxPantalla;
    
    
     public static void display(Pregunta preg,String nomVar){
        window= new Stage();
        labelVariable=new Label("Variable:");
        labelRangoMin=new Label("Rango Min:");
        labelRangoMax=new Label("Rango Max:");
        lableVar=new Label();
        btnAceptar=new Button("Agregar");
        
        areaRangoMin=new TextArea();
        areaRangoMax=new TextArea();
        
        hboxVariable=new HBox(20);
        hboxRangos=new HBox(20);
        hboxButton=new HBox();
        
        vboxPantalla=new VBox(40);
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Variable");
        window.setMinWidth(400);
        window.setMinHeight(200);
        
        
        lableVar.setText(nomVar);
        labelVariable.setTextFill(Color.web("#000000"));
        labelVariable.setStyle(Style.Montserrat_Light);
        labelRangoMin.setTextFill(Color.web("#000000"));
        labelRangoMin.setStyle(Style.Montserrat_Light);
        labelRangoMax.setTextFill(Color.web("#000000"));
        labelRangoMax.setStyle(Style.Montserrat_Light);
        lableVar.setTextFill(Color.web("#000000"));
        lableVar.setStyle(Style.Montserrat_Light);
        
        
        btnAceptar.setPrefSize(150, 30);
        
        
        
        btnAceptar.setStyle(Style.Lion);
        btnAceptar.setOnMouseEntered(e->btnAceptar.setStyle(Style.Lion_default));
        btnAceptar.setOnMouseExited(e->btnAceptar.setStyle(Style.Lion));
        
        
        areaRangoMin.setPrefSize(70, 20);
        areaRangoMax.setPrefSize(70, 20);
        
        
        hboxButton.setAlignment(Pos.BOTTOM_RIGHT);
        hboxVariable.setStyle("-fx-background-color: #73A86F");
        hboxRangos.setStyle("-fx-background-color: #73A86F");
        hboxButton.setStyle("-fx-background-color: #73A86F");
        hboxVariable.getChildren().addAll(labelVariable,lableVar);
        hboxRangos.getChildren().addAll(labelRangoMin,areaRangoMin,labelRangoMax,areaRangoMax);
        
        hboxButton.getChildren().add(btnAceptar);
        
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        
       
        vboxPantalla.getChildren().addAll(r,hboxVariable,hboxRangos,hboxButton);
        vboxPantalla.setStyle("-fx-background-color: #73A86F");
        
        btnAceptar.setOnAction(e->Controlador_AgregarVariable.btnAgrVariable_AV(nomVar));//cambiar cuando se implemente la base de datos
        
       
        Scene scene=new Scene(vboxPantalla);
        window.setResizable(false);
        window.setScene(scene);
        window.showAndWait();
    }

    public static TextArea getAreaRangoMax() {
        return areaRangoMax;
    }

    public static TextArea getAreaRangoMin() {
        return areaRangoMin;
    }

    public static Stage getWindow() {
        return window;
    }
     
     
}
