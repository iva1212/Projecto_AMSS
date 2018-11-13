/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 *
 * @author ivann
 */
public class Controlador_AgregarTema {
    public static void btnAgrTema_AT(ComboBox combo){
         Stage window=AgregarTema.getWindow();
         TextArea areaTema=AgregarTema.getAreaTema();
         System.out.println(combo.getValue());
            ControladorBD_Tema.agrTema(combo.getValue().toString(),areaTema.getText());
            window.close();
         
     }
}
