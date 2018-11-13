/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Controlador_BorrarMateria {
    public static void btnDeletMateria_BM(ComboBox combo){
         Stage window=BorrarMateria.getWindow();
         ControladorBD_Materia.deletMateria((String) combo.getValue());
         window.close();
     }
}
