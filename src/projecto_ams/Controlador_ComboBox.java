/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author ivann
 */
public class Controlador_ComboBox {
    public static List<String> getMaterias(){
        return ControladorBD_Materia.leerMaterias();
        
    }
     public static void comboMateria_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
        List<String> op =new ArrayList<>();
            op=ControladorBD_Tema.leerTemas(comboMateria.getValue().toString());
            comboTema.getItems().clear();
            for(int i=0;i<op.size();i++){
                comboTema.getItems().add(op.get(i));
            }
            List<Pregunta> op2 =new ArrayList<>();
            op2=ControladorBD_Pregunta.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<op2.size();i++){
                if(op2.get(i).getMateria().equals(comboMateria.getValue().toString())){
                    tablaPreguntas.getItems().add(op2.get(i));
                }
            }
        PantallaPrincipal.setComboMateria(comboMateria);
        PantallaPrincipal.setComboTema(comboTema);
        PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

    }
    public static void comboTema_PP(){
         ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
        List<Pregunta> op =new ArrayList<>();
            op=ControladorBD_Pregunta.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<op.size();i++){
                if(op.get(i).getMateria().equals(comboMateria.getValue().toString()) && op.get(i).getTema().equals(comboTema.getValue().toString()) ){
                    tablaPreguntas.getItems().add(op.get(i));
                }
            }
        PantallaPrincipal.setComboMateria(comboMateria);
        PantallaPrincipal.setComboTema(comboTema);
        PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

    }
    public static void comboTipo_AP(Pregunta pregunta){
        ComboBox combo3=AgregarPregunta.getCombo3();
        VBox middle=AgregarPregunta.getMiddle();
        HBox secPregunta=AgregarPregunta.getSecPregunta();
        HBox masMenos=AgregarPregunta.getMasMenos();
        Inciso abierta=AgregarPregunta.getAbierta();
        Inciso verdad=AgregarPregunta.getVerdad();
        Inciso falso=AgregarPregunta.getFalso();
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
        AgregarPregunta.setMiddle(middle);
        
            }
        
        
        
    }

