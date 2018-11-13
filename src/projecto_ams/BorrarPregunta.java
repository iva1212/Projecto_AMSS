/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;

/**
 *
 * @author ivann
 * @param <T>
 */
public class BorrarPregunta<T> extends TableCell<T, Void>  {
    private final Hyperlink link;
    private final ConfirmBox confirm;
    public BorrarPregunta() {
        link = new Hyperlink("Borrar");
        confirm= new ConfirmBox();
        link.setOnAction(evt -> {
            // remove row item from tableview
            if(confirm.display("Borrar Pregunta","Seguro que quiere borrar esta pregunta?")){
                ControladorBD_Pregunta.deletPregunta((Pregunta) getTableRow().getItem());
                getTableView().getItems().remove(getTableRow().getIndex());
                
            }
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        setGraphic(empty ? null : link);
    }
    
}
