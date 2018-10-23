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
public class ConfirmBox {
    public static boolean answer;
    public static boolean display(String title, String message){
        Stage window= new Stage();
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        
        Label label=new Label();
        label.setText(message);
        label.setStyle(Style.Montserrat_Light);
        
        Button yesButton=new Button("Confirmar");
        Button noButton=new Button("Cancelar");
        
        yesButton.setStyle(Style.Lion);
        noButton.setStyle(Style.Lion_Red);
        
        yesButton.setOnMouseEntered(e->yesButton.setStyle(Style.Lion_default));
        yesButton.setOnMouseExited(e->yesButton.setStyle(Style.Lion));
        
        noButton.setOnMouseEntered(e->noButton.setStyle(Style.Lion_default_Red));
        noButton.setOnMouseExited(e->noButton.setStyle(Style.Lion_Red));
        
        yesButton.setOnAction(e ->{
            answer=true;
            window.close();
        });
        noButton.setOnAction(e ->{
            answer=false;
            window.close();
        });
        VBox layout=new VBox(10);
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #73A86F");
        
        
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
        
    }
}
