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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
/**
 *
 * @author ivann
 */
public class AlertBox {
    private static  Stage window;
    private static  Label label;
    private static Button closeButton;
    private static VBox layout;
    
    public static void display(String title, String message){
        window= new Stage();
        label=new Label();
        closeButton=new Button();
        layout=new VBox(10);
        
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        
        
        label.setText(message);
        label.setStyle(Style.Montserrat_Light);
        closeButton.setText("Close");
        closeButton.setStyle(Style.Lion);
        
        closeButton.setOnMouseEntered(e -> closeButton.setStyle(Style.Lion_default));
        closeButton.setOnMouseExited(e -> closeButton.setStyle(Style.Lion));
        
        closeButton.setOnAction(e -> window.close());
        
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #dd6c66");
        
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
