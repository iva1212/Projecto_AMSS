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
public class Controlador_BorrarTema {
    public static void btnDeletTema_BT(ComboBox combo,ComboBox combo2){
         Stage window=BorrarTema.getWindow();
          ControladorBD_Tema.deletTema(combo.getValue().toString(),combo2.getValue().toString());
            window.close();

     }
}
