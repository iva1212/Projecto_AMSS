/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Controlador_AgregarVariable {
    public static void btnAgrVariable_AV(String nomVar){
         Stage window=AgregarVariable.getWindow();
         TextArea areaRangoMin=AgregarVariable.getAreaRangoMin();
         TextArea areaRangoMax=AgregarVariable.getAreaRangoMax();
          Variable v=new Variable(nomVar,Integer.parseInt(areaRangoMin.getText()),Integer.parseInt(areaRangoMax.getText()));
          ControladorBD_Variable.agrVariable(v);
          window.close();
     }
}