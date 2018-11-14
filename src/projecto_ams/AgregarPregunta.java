 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class AgregarPregunta {
    private static Stage window;
    private static ObservableList<String> options;
    private static List<String> variables;
    private static ComboBox combo3;
    private static TextArea preg;
    private static  Label lableMateria;
    private static Label labelTema;
    private static Label labelTipo;
    private static Label labelPregunta;
    private static Label blank;
    private static Button btnAgregar;
    private static Button btnMas;
    private static Button btnMenos;
    private static HBox top;
    private static HBox bottom;
    private static HBox hboxAreapreg;
    private static VBox middle;
    private static VBox secPregunta;
    private static HBox masMenos;
    private static BorderPane borderPane;
    private static Inciso abierta;
    private static Inciso verdad;
    private static Inciso falso;
    
    public static void display(ComboBox comboBox,ComboBox comboBox2,Pregunta pregunta){
        window= new Stage();
        options = 
        FXCollections.observableArrayList(
            "Opcion Multiple",
            "Abierta",
            "V o F"
        );
        variables=new ArrayList<>();
        combo3=new ComboBox(options);
        
        preg=new TextArea();
        
        lableMateria=new Label("Materia:");
        labelTema=new Label("Tema:");
        labelTipo=new Label("Tipo:");
        labelPregunta=new Label("      Pregunta:");
        blank=new Label("       ");
        btnAgregar=new Button("Agregar");
        btnMas=new Button("+");
        btnMenos=new Button("-");
        
        top=new HBox(10);
        bottom=new HBox(10);
        middle=new VBox(10);
        secPregunta=new VBox(10);
        masMenos=new HBox(10);
        borderPane=new BorderPane();
        hboxAreapreg=new HBox(10);
        
        if(pregunta.getMateria()!=""){
            comboBox.setValue(pregunta.getMateria());
            comboBox2.setValue(pregunta.getTema()); 
        }
        abierta=new Inciso("Respuesta","",true); //cambiar si es posible
        verdad=new Inciso("a","Verdadero",false); //cambiar si es posible
        falso=new Inciso("b","Falso",false); //cambiar si es posible
        
        
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Pregunta");
        window.setMinWidth(550);
        window.setMinHeight(500);
        
     
        if(pregunta.getTipo()!=""){
            combo3.setValue(pregunta.getTipo());
        }
        combo3.setPrefSize(150, 30);
        
        
        preg.setPrefSize(350, 80);
        preg.setText(pregunta.getPregunta());
       
     
        //Styling the main title
        lableMateria.setTextFill(Color.web("#000000"));
        lableMateria.setStyle(Style.Montserrat_Light);
        labelTema.setTextFill(Color.web("#000000"));
        labelTema.setStyle(Style.Montserrat_Light);
        labelTipo.setStyle(Style.Montserrat_Light);
        labelTipo.setTextFill(Color.web("#000000"));
        labelPregunta.setStyle(Style.Montserrat_Light);
        labelPregunta.setTextFill(Color.web("#000000"));
        
        
        btnAgregar.setStyle(Style.Lion);
        btnMas.setStyle(Style.Lion);
        btnMenos.setStyle(Style.Lion);

        
        
        btnAgregar.setOnMouseEntered(e->btnAgregar.setStyle(Style.Lion_default));
        btnAgregar.setOnMouseExited(e->btnAgregar.setStyle(Style.Lion));
        btnMas.setOnMouseEntered(e->btnMas.setStyle(Style.Lion_default));
        btnMas.setOnMouseExited(e->btnMas.setStyle(Style.Lion));
        btnMenos.setOnMouseEntered(e->btnMenos.setStyle(Style.Lion_default));
        btnMenos.setOnMouseExited(e->btnMenos.setStyle(Style.Lion));
        
        
        btnAgregar.setPrefSize(150, 30);
        btnMas.setPrefSize(25, 25);
        btnMenos.setPrefSize(25, 25);
        
        
        
        hboxAreapreg.getChildren().addAll(blank,preg);
        secPregunta.getChildren().addAll(labelPregunta,hboxAreapreg);
        top.setStyle("-fx-background-color: #FBF7E9");
        top.getChildren().addAll(lableMateria,comboBox,labelTema,comboBox2,labelTipo,combo3);
        top.setAlignment(Pos.TOP_LEFT);
        top.setPrefSize(800, 100);
        bottom.setAlignment(Pos.TOP_RIGHT);
        bottom.setPrefSize(800, 50);
        bottom.getChildren().addAll(btnAgregar);
        middle.getChildren().addAll(secPregunta);
        masMenos.getChildren().addAll(btnMas,btnMenos);
        
        if(pregunta.getTipo()!=""){
            for(int i=0;i<pregunta.getI().size();i++){
                middle.getChildren().add(pregunta.getI().get(i).display());
            }
            if("Opcion Multiple".equals(pregunta.getTipo())){
                middle.getChildren().add(masMenos);
            }
        }
        combo3.setOnAction(e ->Controlador_AgregarPregunta.comboTipo_AP(pregunta));
        btnAgregar.setOnAction(e ->Controlador_AgregarPregunta.btnAgrPregunta_AP(pregunta, comboBox2));
        btnMas.setOnAction(e->Controlador_AgregarPregunta.btnMas_AP(pregunta));   
        btnMenos.setOnAction(e ->Controlador_AgregarPregunta.btnMenos_AP(pregunta));
        
        
        borderPane.setStyle("-fx-background-color: #FBF7E9");
        borderPane.setTop(top);
        borderPane.setBottom(bottom);
        borderPane.setLeft(middle);
        
        if(!pregunta.getV().isEmpty()){
            TableView table=new TableView();
            
            
            TableColumn VariableCol = new TableColumn("Variable");
            TableColumn MinCol = new TableColumn("Rango Min");
            TableColumn MaxCol = new TableColumn("Rango Max");
            
            VariableCol.setCellValueFactory(
               new PropertyValueFactory<Variable,String>("variable")
            );
            MinCol.setCellValueFactory(
                new PropertyValueFactory<Variable,Integer>("min")
            );
            MaxCol.setCellValueFactory(
                new PropertyValueFactory<Variable,Integer>("max")
            );
            
            
            
            VariableCol.setPrefWidth(75);
            MinCol.setPrefWidth(75);
            MaxCol.setPrefWidth(75);
            table.getColumns().addAll(VariableCol,MinCol,MaxCol);
            table.maxHeight(100);
            table.prefWidth(135);
            
            for(int i=0;i<pregunta.getV().size();i++){
                table.getItems().add(pregunta.getV().get(i));
                
            }
            
            VBox tabla=new VBox(10);
            tabla.setAlignment(Pos.CENTER_RIGHT);
            tabla.getChildren().add(table);
            
            borderPane.setRight(tabla);
         
        }
        Scene scene=new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
        
    }

    public static ComboBox getCombo3() {
        return combo3;
    }

    public static TextArea getPreg() {
        return preg;
    }

    public static VBox getMiddle() {
        return middle;
    }

    public static VBox getSecPregunta() {
        return secPregunta;
    }

    public static HBox getMasMenos() {
        return masMenos;
    }

    public static Inciso getAbierta() {
        return abierta;
    }

    public static void setPreg(TextArea preg) {
        AgregarPregunta.preg = preg;
    }

    public static void setMiddle(VBox middle) {
        AgregarPregunta.middle = middle;
    }

    public static void setMasMenos(HBox masMenos) {
        AgregarPregunta.masMenos = masMenos;
    }

    public static Inciso getFalso() {
        return falso;
    }

    public static Inciso getVerdad() {
        return verdad;
    }

    public static Stage getWindow() {
        return window;
    }

    public static List<String> getVariables() {
        return variables;
    }

    public static void setVariables(List<String> variables) {
        AgregarPregunta.variables = variables;
    }
    
}
