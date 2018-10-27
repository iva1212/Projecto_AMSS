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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.text.Font;
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
    private static Button btnAgregar;
    private static Button btnMas;
    private static Button btnMenos;
    private static HBox top;
    private static HBox bottom;
    private static VBox middle;
    private static HBox secPregunta;
    private static HBox masMenos;
    private static BorderPane borderPane;
    
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
        labelPregunta=new Label("Pregunta:");
        
        btnAgregar=new Button("Agregar");
        btnMas=new Button("+");
        btnMenos=new Button("-");
        
        top=new HBox(10);
        bottom=new HBox(10);
        middle=new VBox(10);
        secPregunta=new HBox(10);
        masMenos=new HBox(10);
        borderPane=new BorderPane();
        
        
        if(pregunta.getMateria()!=""){
            comboBox.setValue(pregunta.getMateria());
            comboBox2.setValue(pregunta.getTema()); 
        }
        Inciso abierta=new Inciso("Respuesta","",true); //cambiar si es posible
        Inciso verdad=new Inciso("a","Verdadero",false); //cambiar si es posible
        Inciso falso=new Inciso("b","Falso",false); //cambiar si es posible
        
        
        
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Agregar Pregunta");
        window.setMinWidth(550);
        window.setMinHeight(450);
        
     
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
        
        
        
        
        secPregunta.getChildren().addAll(labelPregunta,preg);
        top.setStyle("-fx-background-color: #73A86F");
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
        combo3.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(combo3.getValue()=="Opcion Multiple"){
                    middle.getChildren().clear();
                    middle.getChildren().add(secPregunta);
                    if(pregunta.getTipo().equals("Abierta")){
                        pregunta.getI().get(0).setLetra("a");
                    }
                    for(int i=0;i<pregunta.getI().size();i++){
                        middle.getChildren().add(pregunta.getI().get(i).display());
                    }
                    middle.getChildren().add(masMenos);
                }
                else if(combo3.getValue().equals("Abierta")){
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta,abierta.display());
                }
                else if(combo3.getValue().equals("V o F")){
                    middle.getChildren().clear();
                    middle.getChildren().addAll(secPregunta,verdad.display(),falso.display());
                }
            }
                    
         });
        btnAgregar.setOnAction(e -> {
            if(pregunta.getPreguntaID()==-1 || !combo3.getValue().equals(pregunta.getTipo())){
                if(combo3.getValue().equals("Abierta")){
                    pregunta.getI().clear();
                    pregunta.getI().add(abierta);
                }
                else if(combo3.getValue().equals("V o F")){
                    pregunta.getI().clear();
                    pregunta.getI().add(verdad);
                    pregunta.getI().add(falso);
                }
            }
            for(int i=0;i<pregunta.getI().size();i++){
                pregunta.getI().get(i).save();
            }
            pregunta.setPregunta(preg.getText());
            
            pregunta.setTipo(combo3.getValue().toString());
            ControladorBD.deletPregunta(pregunta);
            ControladorBD.agrPregunta(comboBox2.getValue().toString(), pregunta);
            ControladorBD.agrInciso(pregunta.getI());
            
            for(int i=0;i<preg.getText().length();i++){
                pregunta.getV().clear();
                char c=preg.getText().charAt(i);
                if(c=='#'){
                    String sub=preg.getText().substring(i, i+2);
                    variables.add(sub);
                    i++;
                }
            }
            while(!variables.isEmpty()){
                AgregarVariable.display(pregunta,variables.get(0));
                variables.remove(0);
            }
            window.close();
            });
        btnMas.setOnAction(e->{
            for(int i=0;i<pregunta.getI().size();i++){
                 pregunta.getI().get(i).save();
             }
             
            Inciso in=new Inciso((char) (pregunta.getI().size()+'a'));
            pregunta.getI().add(in);
 
            middle.getChildren().clear();
            middle.getChildren().add(secPregunta);
            for(int i=0;i<pregunta.getI().size();i++){
                middle.getChildren().add(pregunta.getI().get(i).display());
            }
            middle.getChildren().add(masMenos);
        });   
        btnMenos.setOnAction(e ->{
            for(int i=0;i<pregunta.getI().size();i++){
                 pregunta.getI().get(i).save();
             }
            pregunta.getI().remove(pregunta.getI().size()-1);
            
            middle.getChildren().clear();
            middle.getChildren().add(secPregunta);
            for(int i=0;i<pregunta.getI().size();i++){
                middle.getChildren().add(pregunta.getI().get(i).display());
            }
            middle.getChildren().add(masMenos);
        });
        
        
        borderPane.setStyle("-fx-background-color: #73A86F");
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
  
}
