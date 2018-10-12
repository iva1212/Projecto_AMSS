/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
        ControladorBD.crearBase();
        List<String> options =new ArrayList<>();
        List<Pregunta> preguntas=ControladorBD.leerPreguntas();
        options=ControladorBD.leerMaterias();
        
        ComboBox comboBox = new ComboBox();
        for(int i=0;i<options.size();i++){
            comboBox.getItems().add(options.get(i));
        }
        ComboBox comboBox2 = new ComboBox();
        
        comboBox.setPrefSize(150, 30);
        comboBox2.setPrefSize(150, 30);
        
        
        Button addMateria=new Button("Agregar Materia");
        Button addTema=new Button("Agregar Tema");
        Button deletMateria=new Button("Borrar Materia");
        Button deletTema=new Button("Borrar tema");
        Button addPregunta=new Button("Agregar Pregunta");
        Button crearExamen=new Button();
        crearExamen.setText("Crear Examen");
        addMateria.setStyle(Style.Lion);
        addTema.setStyle(Style.Lion);
        addPregunta.setStyle(Style.Lion);
        deletMateria.setStyle(Style.Lion);
        deletTema.setStyle(Style.Lion);
        crearExamen.setStyle(Style.Rich_Blue);
        
       
        
        addMateria.setOnMouseEntered(e->addMateria.setStyle(Style.Lion_default));
        addMateria.setOnMouseExited(e->addMateria.setStyle(Style.Lion));
        
        
        addTema.setOnMouseEntered(e->addTema.setStyle(Style.Lion_default));
        addTema.setOnMouseExited(e->addTema.setStyle(Style.Lion));
        
        addPregunta.setOnMouseEntered(e->addPregunta.setStyle(Style.Lion_default));
        addPregunta.setOnMouseExited(e->addPregunta.setStyle(Style.Lion));
        deletMateria.setOnMouseEntered(e->deletMateria.setStyle(Style.Lion_default));
        deletMateria.setOnMouseExited(e->deletMateria.setStyle(Style.Lion));
        deletTema.setOnMouseEntered(e->deletTema.setStyle(Style.Lion_default));
        deletTema.setOnMouseExited(e->deletTema.setStyle(Style.Lion));
        //Initilizing the title
        Label text1=new Label("Materia:");
        Label text2=new Label("Tema:");
        //Styling the main title
        Font.loadFont(Projecto_AMS.class.getResource("Montserrat-Light.ttf").toExternalForm(), 20);
        text1.setTextFill(Color.web("#000000"));
        text1.setStyle(Style.Montserrat_Light);
        text2.setTextFill(Color.web("#000000"));
        text2.setStyle(Style.Montserrat_Light);
        
        //Table inftomation
        TableView table=new TableView();
        
        TableColumn MateriaCol = new TableColumn("Materia");
        TableColumn TemaCol = new TableColumn("Tema");
        TableColumn PreguntaCol = new TableColumn("Pregunta");
        TableColumn TipoCol=new TableColumn("Tipo"); 
        TableColumn ModCol=new TableColumn("Modificar");
        
        MateriaCol.setCellValueFactory(
               new PropertyValueFactory<Pregunta,String>("materia")
        );
        TemaCol.setCellValueFactory(
                new PropertyValueFactory<Pregunta,String>("tema")
        );
        PreguntaCol.setCellValueFactory(
               new PropertyValueFactory<Pregunta,String>("pregunta")
        );
        TipoCol.setCellValueFactory(
                new PropertyValueFactory<Pregunta,String>("tipo")
        );
        
        MateriaCol.setPrefWidth(175);
        TemaCol.setPrefWidth(175);
        PreguntaCol.setPrefWidth(450);
        TipoCol.setPrefWidth(175);
        ModCol.setPrefWidth(175);
        table.getColumns().addAll(MateriaCol, TemaCol, PreguntaCol,TipoCol,ModCol);
        table.prefHeight(350);
        table.prefWidth(500);
        for(int i=0;i<preguntas.size();i++){
            table.getItems().add(preguntas.get(i));
        }
        //Setting the layout of the MAIN screen
        HBox root = new HBox();
        VBox bottom=new VBox();
        root.setPadding(new Insets(10));
        root.setSpacing(10);
        bottom.setPadding(new Insets(10));
        bottom.setSpacing(90);
        bottom.setAlignment(Pos.TOP_RIGHT);
        bottom.setPrefSize(1150,200);
        root.setStyle("-fx-background-color: #73A86F");
        bottom.setStyle("-fx-background-color: #73A86F");
        Region r = new Region();
        VBox.setVgrow(r, Priority.ALWAYS);
        VBox vbox=new VBox(20);
        vbox.getChildren().add(table);
        
        
        
        BorderPane borderPane=new BorderPane();
        
        borderPane.setTop(root);
        //borderPane.setLeft(vbox);
        borderPane.setCenter(vbox);
        borderPane.setBottom(bottom);
        borderPane.setStyle("-fx-background-color: #73A86F");
        //Adding the Title and the buttons to the layout
        root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
        bottom.getChildren().addAll(addPregunta,crearExamen);
        
        //actions of the table
        table.setRowFactory(event-> {TableRow<Pregunta> rowPregunta=new TableRow<>();
        rowPregunta.setOnMouseClicked(e-> {
            if (e.getClickCount() == 2 && (! rowPregunta.isEmpty()) ){
                Pregunta preg=rowPregunta.getItem();
                System.out.println(preg.getPreguntaID());
                preg.setI(ControladorBD.leerIncisos(preg));
                AgregarPregunta.display(comboBox,comboBox2,preg);
                root.getChildren().clear();
                root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
                List<Pregunta> pregu=ControladorBD.leerPreguntas();
                table.getItems().clear();
                for(int i=0;i<pregu.size();i++){
                    table.getItems().add(pregu.get(i));
                }
            } 
        }); return rowPregunta;
});
        
        
        
        //Action of comboBoxes
        comboBox.setOnAction(e->{
            List<String> op =new ArrayList<>();
            op=ControladorBD.leerTemas(comboBox.getValue().toString());
            comboBox2.getItems().clear();
            for(int i=0;i<op.size();i++){
                comboBox2.getItems().add(op.get(i));
            }
            List<Pregunta> op2 =new ArrayList<>();
            op2=ControladorBD.leerPreguntas();
            table.getItems().clear();
            for(int i=0;i<op2.size();i++){
                if(op2.get(i).getMateria().equals(comboBox.getValue().toString())){
                    table.getItems().add(op2.get(i));
                }
            }
            
        });
        comboBox2.setOnAction(e->{
            List<Pregunta> op =new ArrayList<>();
            op=ControladorBD.leerPreguntas();
            table.getItems().clear();
            for(int i=0;i<op.size();i++){
                if(op.get(i).getMateria().equals(comboBox.getValue().toString()) && op.get(i).getTema().equals(comboBox2.getValue().toString()) ){
                    table.getItems().add(op.get(i));
                }
            }
        
        });
        //Actions of buttons
        addPregunta.setOnAction(e -> {
            Pregunta preg=new Pregunta();
            AgregarPregunta.display(comboBox,comboBox2,preg);
            root.getChildren().clear();
            root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
            //table.getItems().clear();
            List<Pregunta> pregu=ControladorBD.leerPreguntas();
            table.getItems().clear();
            for(int i=0;i<pregu.size();i++){
                table.getItems().add(pregu.get(i));
            }
        });
        addMateria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AgregarMateria.display();
                List<String> op =new ArrayList<>();
                op=ControladorBD.leerMaterias();
                comboBox.getItems().clear();
                for(int i=0;i<op.size();i++){
                    comboBox.getItems().add(op.get(i));
                 } 
            }
        });
        addTema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Si entro aqui");
                AgregarTema.display(comboBox);
                List<String> op =new ArrayList<>();
                if(!comboBox.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboBox.getValue().toString());
                    comboBox2.getItems().clear();

                    for(int i=0;i<op.size();i++){
                        comboBox2.getItems().add(op.get(i));
                    }
                }
                root.getChildren().clear();
                root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
            }
        });
        deletMateria.setOnAction(e ->{
            BorrarMateria.display(comboBox);
            List<String> op =new ArrayList<>();
                op=ControladorBD.leerMaterias();
                comboBox.getItems().clear();
                for(int i=0;i<op.size();i++){
                    comboBox.getItems().add(op.get(i));
                 } 
            if(!comboBox.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboBox.getValue().toString());
                    comboBox2.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboBox2.getItems().add(op.get(i));
                    }
                }
            List<Pregunta> pregu=ControladorBD.leerPreguntas();
            table.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            table.getItems().add(pregu.get(i));
            }
            root.getChildren().clear();
            root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
        });
        deletTema.setOnAction(e->{
            BorrarTema.display(comboBox, comboBox2);
            List<String> op =new ArrayList<>();
                if(!comboBox.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboBox.getValue().toString());
                    comboBox2.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboBox2.getItems().add(op.get(i));
                    }
                }
             List<Pregunta> pregu=ControladorBD.leerPreguntas();
            table.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            table.getItems().add(pregu.get(i));
        }
            root.getChildren().clear();
            root.getChildren().addAll(text1,comboBox,text2,comboBox2,addMateria,addTema,deletMateria,deletTema);
        });
        //Adding the layout to the scene
        Scene scene = new Scene(borderPane,1150,614);
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
