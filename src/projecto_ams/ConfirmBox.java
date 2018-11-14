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
public class ConfirmBox {
    private static boolean answer;
    private static Stage window;
    private static Label label;
    private static Button yesButton;
    private static Button noButton;
    private static VBox layout;
    
    public static boolean display(String title, String message){
        window= new Stage();
        label=new Label();
        
        yesButton=new Button("Confirmar");
        noButton=new Button("Cancelar");
        
        layout=new VBox(10);
        
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        
        label.setText(message);
        label.setStyle(Style.Montserrat_Light);
        
        
        
        yesButton.setStyle(Style.Lion);
        noButton.setStyle(Style.Lion);
        
        yesButton.setOnMouseEntered(e->yesButton.setStyle(Style.Lion_default));
        yesButton.setOnMouseExited(e->yesButton.setStyle(Style.Lion));
        
        noButton.setOnMouseEntered(e->noButton.setStyle(Style.Lion_default));
        noButton.setOnMouseExited(e->noButton.setStyle(Style.Lion));
        
        yesButton.setOnAction(e ->{
            answer=true;
            window.close();
        });
        noButton.setOnAction(e ->{
            answer=false;
            window.close();
        });
        
        
        layout.getChildren().addAll(label,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #FBF7E9");
        
        
        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
        
        return answer;
        
    }
}
