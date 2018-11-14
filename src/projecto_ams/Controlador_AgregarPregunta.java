/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Controlador_AgregarPregunta {
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
            ControladorBD_Pregunta.deletPregunta(pregunta);
            ControladorBD_Pregunta.agrPregunta(comboBox2.getValue().toString(), pregunta);
            ControladorBD_Inciso.agrInciso(pregunta.getI());
            
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
    public static void btnMas_AP(Pregunta pregunta){
        VBox middle=AgregarPregunta.getMiddle();
        VBox secPregunta=AgregarPregunta.getSecPregunta();
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
        VBox secPregunta=AgregarPregunta.getSecPregunta();
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
     public static void comboTipo_AP(Pregunta pregunta){
        ComboBox combo3=AgregarPregunta.getCombo3();
        VBox middle=AgregarPregunta.getMiddle();
        VBox secPregunta=AgregarPregunta.getSecPregunta();
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
