/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.List;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;

/**
 *
 * @author ivann
 */
public class Controlador_Tablas {
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
