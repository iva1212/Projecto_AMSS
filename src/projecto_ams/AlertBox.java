/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
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
        closeButton.setText("Close");
        closeButton.setOnAction(e -> window.close());
        
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);
        
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}
