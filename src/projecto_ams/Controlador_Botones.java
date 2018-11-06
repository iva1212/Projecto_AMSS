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
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Controlador_Botones {
    public static void btnAgrPregunta_PP(){
        Pregunta preg=new Pregunta();
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
            AgregarPregunta.display(comboMateria,comboTema,preg);
            PantallaPrincipal.refresh();
            //table.getItems().clear();
            List<Pregunta> pregu=ControladorBD.leerPreguntas();
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
    public static void btnAgrPregunta_AP(Pregunta pregunta,ComboBox comboBox2){
        Stage window=AgregarPregunta.getWindow();
        ComboBox combo3=AgregarPregunta.getCombo3();
        Inciso abierta=AgregarPregunta.getAbierta();
        Inciso verdad=AgregarPregunta.getVerdad();
        Inciso falso=AgregarPregunta.getFalso();
        TextArea preg=AgregarPregunta.getPreg();
        List<String> variables=AgregarPregunta.getVariables();
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
            AgregarPregunta.setVariables(variables);
            window.close();
        
    }
    public static void btnAgrMateria_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
        AgregarMateria.display();
        List<String> op =new ArrayList<>();
        op=ControladorBD.leerMaterias();
        comboMateria.getItems().clear();
        for(int i=0;i<op.size();i++){
            comboMateria.getItems().add(op.get(i));
            } 
       PantallaPrincipal.setComboMateria(comboMateria);
       PantallaPrincipal.setComboTema(comboTema);
       PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

    }
    public static void btnAgrMateria_AM(TextArea a){
        ControladorBD.agrMateria(a.getText());
        AgregarMateria.getWindow().close();
    }
     public static void btnAgrTema_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
         AgregarTema.display(comboMateria);
                List<String> op =new ArrayList<>();
                if(!comboMateria.getSelectionModel().isEmpty()){
                    op=ControladorBD.leerTemas(comboMateria.getValue().toString());
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
     public static void btnAgrTema_AT(ComboBox combo){
         Stage window=AgregarTema.getWindow();
         TextArea areaTema=AgregarTema.getAreaTema();
         System.out.println(combo.getValue());
            ControladorBD.agrTema(combo.getValue().toString(),areaTema.getText());
            window.close();
         
     }
     public static void btnAgrVariable_AV(String nomVar){
         Stage window=AgregarVariable.getWindow();
         TextArea areaRangoMin=AgregarVariable.getAreaRangoMin();
         TextArea areaRangoMax=AgregarVariable.getAreaRangoMax();
          Variable v=new Variable(nomVar,Integer.parseInt(areaRangoMin.getText()),Integer.parseInt(areaRangoMax.getText()));
          ControladorBD.agrVariable(v);
          window.close();
     }
     public static void btnDeletMateria_PP(){
         ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
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
            PantallaPrincipal.refresh();
            PantallaPrincipal.setComboMateria(comboMateria);
            PantallaPrincipal.setComboTema(comboTema);
            PantallaPrincipal.setTablaPreguntas(tablaPreguntas);

     }
     public static void btnDeletMateria_BM(ComboBox combo){
         Stage window=BorrarMateria.getWindow();
         ControladorBD.deletMateria((String) combo.getValue());
         window.close();
     }
     public static void btnDeletTema_PP(){
        ComboBox comboMateria=PantallaPrincipal.getComboMateria();
        ComboBox comboTema=PantallaPrincipal.getComboTema();
        TableView tablaPreguntas=PantallaPrincipal.getTablaPreguntas();
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
            PantallaPrincipal.refresh();
            PantallaPrincipal.setComboMateria(comboMateria);
            PantallaPrincipal.setComboTema(comboTema);
            PantallaPrincipal.setTablaPreguntas(tablaPreguntas);
     }
     public static void btnDeletTema(ComboBox combo,ComboBox combo2){
         Stage window=BorrarTema.getWindow();
          ControladorBD.deletTema(combo.getValue().toString(),combo2.getValue().toString());
            window.close();

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
     public static void btnMas_AP(Pregunta pregunta){
        VBox middle=AgregarPregunta.getMiddle();
        HBox secPregunta=AgregarPregunta.getSecPregunta();
        HBox masMenos=AgregarPregunta.getMasMenos();
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
            AgregarPregunta.setMiddle(middle);
     }
     public static void btnMenos_AP(Pregunta pregunta){
        VBox middle=AgregarPregunta.getMiddle();
        HBox secPregunta=AgregarPregunta.getSecPregunta();
        HBox masMenos=AgregarPregunta.getMasMenos();
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
            AgregarPregunta.setMiddle(middle);
     }
}
