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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Projecto_AMS extends Application {
    
    @Override
    public void start(Stage primaryStage){
        //Initializing the buttons
        Button btn1 = new Button();
        Button btn2=new Button();
        Button btn3=new Button();
        //Initilizing the title
        Label text=new Label("Examen Generator");
        //Styling the main title
        text.setTextFill(Color.web("#FFFFFF"));
        text.setFont(new Font("Arial", 35));
        //Setting the buttons sizes
        btn1.setMinSize(50, 50);
        btn2.setMinSize(50, 50);
        btn3.setMinSize(50, 50);
        //Setting the text inside the buttons
        btn1.setText("Administrar Peguntas");
        btn2.setText("Crear Examen");
        btn3.setText("Consultar Examenes Pasados");
        //Setting the syle in the buttons
        btn1.setStyle(Style.Windows7);
        btn2.setStyle(Style.Windows7);
        btn3.setStyle(Style.Windows7);
        //Setting actions when the button is clicked
        btn1.setOnAction( e-> AlertBox.display("En construcion","Upps... esto todavia no esta acabado :(")); //Cambiar cuando nueva ventana este terminada
        btn2.setOnAction( e-> AlertBox.display("En construcion","Upps... esto todavia no esta acabado :(")); //Cambiar cuando nueva ventana este terminada
        btn3.setOnAction( e-> AlertBox.display("En construcion","Upps... esto todavia no esta acabado :(")); //Cambiar cuando nueva ventana este terminada
        //Setting the change of the button when the mouse is hovered over them
        btn1.setOnMouseEntered(e->btn1.setStyle(Style.Windows7_default));
        btn1.setOnMouseExited(e -> btn1.setStyle(Style.Windows7));
        btn2.setOnMouseEntered(e->btn2.setStyle(Style.Windows7_default));
        btn2.setOnMouseExited(e -> btn2.setStyle(Style.Windows7));
        btn3.setOnMouseEntered(e->btn3.setStyle(Style.Windows7_default));
        btn3.setOnMouseExited(e -> btn3.setStyle(Style.Windows7));
        //Setting the layout of the MAIN screen
        VBox root = new VBox(20);
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #73A86F");
        //Adding the Title and the buttons to the layout
        root.getChildren().addAll(text,btn1,btn2,btn3);
        //Adding the layout to the scene
        Scene scene = new Scene(root,400, 300);
        //Displaying the window
        primaryStage.setTitle("Exam Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
