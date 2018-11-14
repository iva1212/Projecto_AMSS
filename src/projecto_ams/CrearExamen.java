/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class CrearExamen {
    private static Stage window;
    private static List<String> temas;
    private static List<Integer> numTemas;
    private static List<HBox> hboxTemas;
    private static Button btnCrear;
    private static TextArea areaTitulo;
    private static TextArea areaSubtitulo;
    private static TextArea areaNumeroExamenes;
    private static TextArea areaInstruciones;
    private static Label labelMateria;
    private static Label labelTemas;
    private static Label labelTitulo;
    private static Label labelSubtitulo;
    private static Label labelNumero;
    private static Label labelInstruciones;
    private static ComboBox comboMateria;
    private static BorderPane borderPane;
    private static VBox vboxMatTemas;
    private static HBox hboxTitulo;
    private static HBox hboxSubtitulo;
    private static HBox hboxTituloSub;
    private static HBox hboxMateria;
    private static HBox hboxInstruciones;
    private static HBox hboxBtnCrear;
   
    
    public static void display(ComboBox comboBox){
        window= new Stage();
        comboMateria=new ComboBox();
        comboMateria.setPrefSize(150, 30);
        for(int i=0;i<comboBox.getItems().size();i++){
            comboMateria.getItems().add(comboBox.getItems().get(i));
        }
        temas=new ArrayList<>();
        numTemas=new ArrayList<>();
        hboxTemas=new ArrayList<>();
        temas=ControladorBD_Tema.leerTemas(comboBox.getValue().toString());
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Crear Examen");
        window.setMinWidth(650);
        window.setMinHeight(600);
        
        labelMateria=new Label("Materia:");
        labelTemas=new Label("Temas:");
        labelTitulo=new Label("Titulo:");
        labelSubtitulo=new Label("Subtitulo:");
        labelNumero=new Label("Num.Examenes:");
        labelInstruciones=new Label ("Instruciones:");
        
        labelMateria.setStyle(Style.Montserrat_Light);
        labelTemas.setStyle(Style.Montserrat_Light);
        labelTitulo.setStyle(Style.Montserrat_Light);
        labelSubtitulo.setStyle(Style.Montserrat_Light);
        labelNumero.setStyle(Style.Montserrat_Light);
        labelInstruciones.setStyle(Style.Montserrat_Light);
        
        btnCrear=new Button("Crear Examen");
        
        areaTitulo=new TextArea();
        areaSubtitulo=new TextArea();
        areaNumeroExamenes=new TextArea();
        areaInstruciones=new TextArea();
        
        areaTitulo.setPrefSize(200, 20);
        areaSubtitulo.setPrefSize(200, 20);
        areaNumeroExamenes.setPrefSize(50,20);
        areaInstruciones.setPrefSize(450, 80);
        
        btnCrear.setStyle(Style.Rich_Blue);
        btnCrear.setOnMouseEntered(e->btnCrear.setStyle(Style.Rich_Blue_Default));
        btnCrear.setOnMouseExited(e->btnCrear.setStyle(Style.Rich_Blue));
        
        vboxMatTemas=new VBox(10);
        hboxMateria=new HBox(10);
        hboxBtnCrear=new HBox(10);
        hboxTitulo=new HBox(10);
        hboxSubtitulo=new HBox(10);
        hboxTituloSub=new HBox(10);
        hboxInstruciones=new HBox(10);
        
        hboxMateria.getChildren().addAll(labelMateria,comboMateria,labelNumero,areaNumeroExamenes);
        hboxBtnCrear.getChildren().add(btnCrear);
        
        hboxInstruciones.getChildren().addAll(labelInstruciones,areaInstruciones);
        
        hboxTitulo.getChildren().addAll(labelTitulo,areaTitulo);
        hboxSubtitulo.getChildren().addAll(labelSubtitulo,areaSubtitulo);
        
        hboxTituloSub.getChildren().addAll(hboxTitulo,hboxSubtitulo);
        
        vboxMatTemas.getChildren().addAll(hboxTituloSub,hboxMateria,hboxInstruciones,labelTemas);
        hboxBtnCrear.setAlignment(Pos.TOP_RIGHT);
        
        
        
        resetTemas();
        for(int i=0;i<hboxTemas.size();i++){
            vboxMatTemas.getChildren().add(hboxTemas.get(i));
        }
        
        
        
        borderPane=new BorderPane();
        
        
        borderPane.setTop(vboxMatTemas);
        borderPane.setBottom(hboxBtnCrear);
        borderPane.setStyle("-fx-background-color: #73A86F");
        
        
        
        
        
        
        
        comboMateria.setValue(comboBox.getValue());
        comboMateria.setOnAction(new EventHandler() {
            @Override
            public void handle(Event e) {
                if(comboMateria.getValue()!=null){
                    temas=ControladorBD_Tema.leerTemas(comboMateria.getValue().toString());
                    hboxTemas.clear();
                    resetTemas();
                    vboxMatTemas.getChildren().clear();
                    vboxMatTemas.getChildren().addAll(hboxTituloSub,hboxMateria,hboxInstruciones,labelTemas);
                    for(int i=0;i<hboxTemas.size();i++){
                        vboxMatTemas.getChildren().add(hboxTemas.get(i));
                    }
                }
            }
        });
        btnCrear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                try{
                Controlador_CrearExamen crear=new Controlador_CrearExamen();
                int numeroExamenes=Integer.parseInt(areaNumeroExamenes.getText());
                numTemas.clear();
                for(int i=0;i<hboxTemas.size();i++){
                    HBox op=hboxTemas.get(i);
                    Label num=(Label) op.getChildren().get(2);
                    numTemas.add(Integer.parseInt(num.getText().toString()));
                }
                crear.CrearExamen(areaTitulo.getText().toString(),areaSubtitulo.getText().toString(),areaInstruciones.getText().toString(),comboMateria.getValue().toString(),temas,numTemas,numeroExamenes);
                AlertBox.display("Crear Examen", "Examen Creado!");
                window.close();
                }
                catch (IndexOutOfBoundsException error){
                    AlertBox.display("Error","Se produjo un error,intente denuevo");
                    e.consume();
                }
                catch(NumberFormatException error){
                    AlertBox.display("Error","Se produjo un error,intente denuevo");
                    e.consume();
                }
            }
        });
        
        
        Scene scene=new Scene(borderPane);
        window.setScene(scene);
        window.showAndWait();
    
    }
    private static void resetTemas(){
        for(int i=0;i<temas.size();i++){
            HBox op=new HBox(20);
            Button btnMas=new Button("+");
            Button btnMenos=new Button("-");
            btnMas.setStyle(Style.Lion);
            btnMenos.setStyle(Style.Lion);
            btnMas.setOnMouseEntered(e->btnMas.setStyle(Style.Lion_default));
            btnMas.setOnMouseExited(e->btnMas.setStyle(Style.Lion));
            btnMenos.setOnMouseEntered(e->btnMenos.setStyle(Style.Lion_default));
            btnMenos.setOnMouseExited(e->btnMenos.setStyle(Style.Lion));
            Label tema=new Label(temas.get(i));
            Label num=new Label("0");
            tema.setStyle(Style.Montserrat_Light);
            
            btnMas.setOnAction(e ->{
                int n=Integer.parseInt(num.getText().toString());
                n++;
                num.setText(Integer.toString(n));
            });
            btnMenos.setOnAction(e ->{
                int n=Integer.parseInt(num.getText().toString());
                if(n-1>=0){
                    n--;
                }
                num.setText(Integer.toString(n));
            });
            op.getChildren().addAll(tema,btnMenos,num,btnMas);
            hboxTemas.add(op);
            
        }
        
        
    }
}
