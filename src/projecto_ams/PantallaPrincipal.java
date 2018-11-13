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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 *
 * @author ivann
 */
public class PantallaPrincipal extends Application {
    
    private List<String> materias;
    private List<Pregunta> preguntas;
    private static ComboBox comboMateria;
    private static ComboBox comboTema;
    private static Button addMateria;
    private static Button addTema;
    private static Button deletMateria;
    private static Button deletTema;
    private static Button addPregunta;
    private static Button crearExamen;
    private static Label labelMateria;
    private static Label labelTema;
    private static TableView tablaPreguntas;
    private TableColumn MateriaCol;
    private TableColumn TemaCol;
    private TableColumn PreguntaCol;
    private TableColumn TipoCol;
    private TableColumn ElimCol;
    private static HBox root;
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
        preguntas=Controlador_PantallaPrincipal.getPreguntas();
        materias=Controlador_PantallaPrincipal.getMaterias();
        
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
        Font.loadFont(PantallaPrincipal.class.getResource("Montserrat-Light.ttf").toExternalForm(), 20);
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
        ElimCol.setCellFactory(tc -> new Controlador_BorrarPregunta<>());
        
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
                Controlador_PantallaPrincipal.modPregunta_PP(rowPregunta);
            } 
        }); return rowPregunta;
});

        
        //Action of comboBoxes
        comboMateria.setOnAction(e->{
            Controlador_PantallaPrincipal.comboMateria_PP();
        });
        comboTema.setOnAction(e->{
            Controlador_PantallaPrincipal.comboTema_PP();
        });
        //Actions of buttons
        addPregunta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Controlador_PantallaPrincipal.btnAgrPregunta_PP();
            }
        });
        addMateria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Controlador_PantallaPrincipal.btnAgrMateria_PP();
            }
        });
        addTema.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Controlador_PantallaPrincipal.btnAgrTema_PP();
            }
        });
        deletMateria.setOnAction(e ->{
            Controlador_PantallaPrincipal.btnDeletMateria_PP();
        });
        deletTema.setOnAction(e->{
            Controlador_PantallaPrincipal.btnDeletTema_PP();
        });
        crearExamen.setOnAction(e ->{
            Controlador_PantallaPrincipal.btnCrearExamen_PP();
        });
        
        //Adding the layout to the scene
        Scene scene = new Scene(borderPane,1150,614);
        //Displaying the window
        primaryStage.setTitle("Exam Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
      public static void refresh(){
        root.getChildren().clear();
        root.getChildren().addAll(labelMateria,comboMateria,labelTema,comboTema,addMateria,addTema,deletMateria,deletTema);
    }

    public static ComboBox getComboTema() {
        return comboTema;
    }

    public static ComboBox getComboMateria() {
        return comboMateria;
    }

    public static TableView getTablaPreguntas() {
        return tablaPreguntas;
    }

    public static void setComboMateria(ComboBox comboMateria) {
        PantallaPrincipal.comboMateria = comboMateria;
    }

    public static void setComboTema(ComboBox comboTema) {
        PantallaPrincipal.comboTema = comboTema;
    }

    public static void setTablaPreguntas(TableView tablaPreguntas) {
        PantallaPrincipal.tablaPreguntas = tablaPreguntas;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        launch(args);
    }
   
    
}
