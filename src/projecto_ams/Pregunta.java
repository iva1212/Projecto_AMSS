/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.layout.HBox;

/**
 *
 * @author ivann
 */
public class Pregunta {
    private String tipo;
    private String pregunta;
    private String materia;
    private String tema;
    private int preguntaID;
    public Pregunta(){
        this.tipo="";
        this.pregunta="";
        this.materia="";
        this.tema="";
    }
    public Pregunta(String materia,String tema,String pregunta,String tipo){
        this.tipo=tipo;
        this.materia=materia;
        this.pregunta=pregunta;
        this.tema=tema;
    }

    public String getMateria() {
        return materia;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getTema() {
        return tema;
    }

    public String getTipo() {
        return tipo;
    }
    
}
