/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

/**
 *
 * @author ivann
 */
public class Controlador_PantallaPrincipal {
    
    public static void btnAgrPregunta_PP(){
        Pregunta preg=new Pregunta();
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
            AgregarPregunta.display(comboMateria,comboTema,preg);
            PantallaPrincipal.refresh();
            //table.getItems().clear();
            List<Pregunta> pregu=ControladorBD_Pregunta.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
                if(pregu.get(i).getMateria().equals(comboMateria.getValue().toString()) && pregu.get(i).getTema().equals(comboTema.getValue().toString()) ){
                    tablaPreguntas.getItems().add(pregu.get(i));
                }
            }
        PantallaPrincipal.setComboMateria(comboMateria);
        PantallaPrincipal.setComboTema(comboTema);
        PantallaPrincipal.setTablaPreguntas(tablaPreguntas);
    }
    
    public static void btnAgrMateria_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
        AgregarMateria.display();
        List<String> op =new ArrayList<>();
        op=ControladorBD_Materia.leerMaterias();
        comboMateria.getItems().clear();
        for(int i=0;i<op.size();i++){
            comboMateria.getItems().add(op.get(i));
            } 
       PantallaPrincipal.setComboMateria(comboMateria);
       PantallaPrincipal.setComboTema(comboTema);
       PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

    }
    public static void btnAgrTema_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
         AgregarTema.display(comboMateria);
                List<String> op =new ArrayList<>();
                if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD_Tema.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
                
         PantallaPrincipal.refresh();
         PantallaPrincipal.setComboMateria(comboMateria);
         PantallaPrincipal.setComboTema(comboTema);
         PantallaPrincipal.setTablaPreguntas(tablaPreguntas);
     }
    public static void btnDeletMateria_PP(){
         ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
          BorrarMateria.display(comboMateria);
            List<String> op =new ArrayList<>();
                op=ControladorBD_Materia.leerMaterias();
                comboMateria.getItems().clear();
                for(int i=0;i<op.size();i++){
                    comboMateria.getItems().add(op.get(i));
                 } 
            if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD_Tema.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
            List<Pregunta> pregu=ControladorBD_Pregunta.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            tablaPreguntas.getItems().add(pregu.get(i));
            }
            PantallaPrincipal.refresh();
            PantallaPrincipal.setComboMateria(comboMateria);
            PantallaPrincipal.setComboTema(comboTema);
            PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

     }
    public static void btnDeletTema_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
         BorrarTema.display(comboMateria, comboTema);
            List<String> op =new ArrayList<>();
                if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD_Tema.leerTemas(comboMateria.getValue().toString());
                    comboTema.getItems().clear();
                    for(int i=0;i<op.size();i++){
                        comboTema.getItems().add(op.get(i));
                    }
                }
             List<Pregunta> pregu=ControladorBD_Pregunta.leerPreguntas();
            tablaPreguntas.getItems().clear();
            for(int i=0;i<pregu.size();i++){
            tablaPreguntas.getItems().add(pregu.get(i));
        }
            PantallaPrincipal.refresh();
            PantallaPrincipal.setComboMateria(comboMateria);
            PantallaPrincipal.setComboTema(comboTema);
            PantallaPrincipal.setTablaPreguntas(tablaPreguntas);
     }
    
    
    public static void btnCrearExamen_PP(){
         ComboBox comboMateria=PantallaPrincipal.getComboMateria();
         if(!comboMateria.getSelectionModel().isEmpty()){
                CrearExamen.display(comboMateria);
                PantallaPrincipal.refresh();
            }
            else{
                AlertBox.display("Error", "Selecione Materia Primero");
            }
         PantallaPrincipal.setComboMateria(comboMateria);
     }
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
    public static void modPregunta_PP(TableRow<Pregunta> rowPregunta){
         Pregunta preg=rowPregunta.getItem();
          ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
                System.out.println(preg.getPreguntaID());
                preg.setI(ControladorBD_Inciso.leerIncisos(preg));
                preg.setV(ControladorBD_Variable.leerVariables(preg));
                AgregarPregunta.display(comboMateria,comboTema,preg);
                PantallaPrincipal.refresh();
                List<Pregunta> pregu=ControladorBD_Pregunta.leerPreguntas();
                tablaPreguntas.getItems().clear();
                for(int i=0;i<pregu.size();i++){
                    tablaPreguntas.getItems().add(pregu.get(i));
                }
        PantallaPrincipal.setComboMateria(comboMateria);
        PantallaPrincipal.setComboTema(comboTema);
        PantallaPrincipal.setTablaPreguntas(tablaPreguntas);
    }
    public static List<Pregunta> getPreguntas(){
        return ControladorBD_Pregunta.leerPreguntas();
    }
}
