/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
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
    
    private List<String> materias;
    private List<Pregunta> preguntas;
    private ComboBox comboMateria;
    private ComboBox comboTema;
    private Button addMateria;
    private Button addTema;
    private Button deletMateria;
    private Button deletTema;
    private Button addPregunta;
    private Button crearExamen;
    private  Label labelMateria;
    private  Label labelTema;
    private TableView tablaPreguntas;
    private TableColumn MateriaCol;
    private TableColumn TemaCol;
    private TableColumn PreguntaCol;
    private TableColumn TipoCol;
    private TableColumn ElimCol;
    private HBox root;
    private VBox bottom;
    private VBox tabla;
    private BorderPane borderPane;
    
    @Override
    public void start(Stage primaryStage){
        
        ControladorBD.crearBase(); //cambiar para cambiar
        //Inicializacionde variables
        materias =new ArrayList<>();
        comboMateria = new ComboBox();
        comboTema = new ComboBox();
        addMateria=new Button("Agregar Materia");
        addTema=new Button("Agregar Tema");
        deletMateria=new Button("Borrar Materia");
        deletTema=new Button("Borrar tema");
        addPregunta=new Button("Agregar Pregunta");
        crearExamen=new Button("Crear Examen");
        labelMateria=new Label("Materia:");
        labelTema=new Label("Tema:");
        tablaPreguntas=new TableView();
        MateriaCol = new TableColumn("Materia");
        TemaCol = new TableColumn("Tema");
        PreguntaCol = new TableColumn("Pregunta");
        TipoCol=new TableColumn("Tipo"); 
        ElimCol=new TableColumn("Eliminar");
        root = new HBox();
        bottom=new VBox();
        tabla=new VBox(20);
        borderPane=new BorderPane();
        //consiguiendo informacion de la base de datos
        preguntas=ControladorBD.leerPreguntas();
        materias=ControladorBD.leerMaterias();
        
        //Agregando informacion al ComboBox de Materia
        for(int i=0;i<materias.size();i++){
            comboMateria.getItems().add(materias.get(i));
        }
        
        //
        //comboMateria.getSelectionModel().selectFirst();
        
        //Estableciendo las dimenciones de los COmboBoxes
        comboMateria.setPrefSize(150, 30);
        comboTema.setPrefSize(150, 30);
        
        
       
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
        
        //Styling the main title
        Font.loadFont(Projecto_AMS.class.getResource("Montserrat-Light.ttf").toExternalForm(), 20);
        labelMateria.setTextFill(Color.web("#000000"));
        labelMateria.setStyle(Style.Montserrat_Light);
        labelTema.setTextFill(Color.web("#000000"));
        labelTema.setStyle(Style.Montserrat_Light);
        
        //Table inftomation
        
        
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
        ElimCol.setCellFactory(tc -> new BorrarPregunta<>());
        
        MateriaCol.setPrefWidth(175);
        TemaCol.setPrefWidth(175);
        PreguntaCol.setPrefWidth(450);
        TipoCol.setPrefWidth(175);
        ElimCol.setPrefWidth(175);
        tablaPreguntas.getColumns().addAll(MateriaCol, TemaCol, PreguntaCol,TipoCol,ElimCol);
        tablaPreguntas.prefHeight(350);
        tablaPreguntas.prefWidth(500);
        for(int i=0;i<preguntas.size();i++){
            tablaPreguntas.getItems().add(preguntas.get(i));
        }
        //Setting the layout of the MAIN screen
       
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
        tabla.getChildren().add(tablaPreguntas);
        
       
        
        borderPane.setTop(root);
        //borderPane.setLeft(tabla);
        borderPane.setCenter(tabla);
        borderPane.setBottom(bottom);
        borderPane.setStyle("-fx-background-color: #73A86F");
        //Adding the Title and the buttons to the layout
        root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
        bottom.getChildren().addAll(addPregunta,crearExamen);
        
        //actions of the tablaPreguntas
        tablaPreguntas.setRowFactory(event-> {TableRow<Pregunta> rowPregunta=new TableRow<>();
        rowPregunta.setOnMouseClicked(e-> {
            if (e.getClickCount() == 2 && (! rowPregunta.isEmpty()) ){
                Pregunta preg=rowPregunta.getItem();
                System.out.println(preg.getPreguntaID());
                preg.setI(ControladorBD.leerIncisos(preg));
                preg.setV(ControladorBD.leerVariables(preg));
                AgregarPregunta.display(comboMateria,comboTema,preg);
                root.getChildren().clear();
                root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
                List<Pregunta> pregu=ControladorBD.leerPreguntas();
                tablaPreguntas.getItems().clear();
                for(int i=0;i<pregu.size();i++){
                    tablaPreguntas.getItems().add(pregu.get(i));
                }
            } 
        }); return rowPregunta;
});
        
        
        
        //Action of comboBoxes
        comboMateria.setOnAction(e->{
            List<String> op =new ArrayList<>();
            op=ControladorBD.leerTemas(comboMateria.getValue().toString());
            comboTema.getItems().clear();
            for(int i=0;i<op.size();i++){
                comboTema.getItems().add(op.get(i));
            }
            List<Pregunta> op2 =new ArrayList<>();
            op2=ControladorBD.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<op2.size();i++){
                if(op2.get(i).getMateria().equals(comboMateria.getValue().toString())){
                    tablaPreguntas.getItems().add(op2.get(i));
                }
            }
            
        });
        comboTema.setOnAction(e->{
            List<Pregunta> op =new ArrayList<>();
            op=ControladorBD.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<op.size();i++){
                if(op.get(i).getMateria().equals(comboMateria.getValue().toString()) && op.get(i).getTema().equals(comboTema.getValue().toString()) ){
                    tablaPreguntas.getItems().add(op.get(i));
                }
            }
        
        });
        //Actions of buttons
        addPregunta.setOnAction(e -> {
            Pregunta preg=new Pregunta();
            AgregarPregunta.display(comboMateria,comboTema,preg);
            root.getChildren().clear();
            root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
            //table.getItems().clear();
            List<Pregunta> pregu=ControladorBD.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
                if(pregu.get(i).getMateria().equals(comboMateria.getValue().toString()) && pregu.get(i).getTema().equals(comboTema.getValue().toString()) ){
                    tablaPreguntas.getItems().add(pregu.get(i));
                }
            }
        });
        addMateria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                AgregarMateria.display();
                List<String> op =new ArrayList<>();
                op=ControladorBD.leerMaterias();
                comboMateria.getItems().clear();
                for(int i=0;i<op.size();i++){
                    comboMateria.getItems().add(op.get(i));
                 } 
            }
        });
        addTema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("Si entro aqui");
                AgregarTema.display(comboMateria);
                List<String> op =new ArrayList<>();
                if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();

                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
                root.getChildren().clear();
                root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
            }
        });
        deletMateria.setOnAction(e ->{
            BorrarMateria.display(comboMateria);
            List<String> op =new ArrayList<>();
                op=ControladorBD.leerMaterias();
                comboMateria.getItems().clear();
                for(int i=0;i<op.size();i++){
                    comboMateria.getItems().add(op.get(i));
                 } 
            if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
            List<Pregunta> pregu=ControladorBD.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            tablaPreguntas.getItems().add(pregu.get(i));
            }
            root.getChildren().clear();
            root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
        });
        deletTema.setOnAction(e->{
            BorrarTema.display(comboMateria, comboTema);
            List<String> op =new ArrayList<>();
                if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
             List<Pregunta> pregu=ControladorBD.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            tablaPreguntas.getItems().add(pregu.get(i));
        }
            root.getChildren().clear();
            root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
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
