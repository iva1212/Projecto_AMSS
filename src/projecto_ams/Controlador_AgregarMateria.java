/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.TextArea;

/**
 *
 * @author ivann
 */
public class Controlador_AgregarMateria {
    
    public static void btnAgrMateria_AM(TextArea a){
        ControladorBD_Materia.agrMateria(a.getText());
        AgregarMateria.getWindow().close();
    }
}
