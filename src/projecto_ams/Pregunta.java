/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author ivann
 */
public class Pregunta {
    private String tipo;
    private String pregunta;
    private String materia;
    private String tema;
    private int numeroIncisos;
    private int preguntaID;
    private List<Inciso> I;
    private List<Variable> V;
    public Pregunta(){
        this.tipo="Opcion Multiple";
        this.pregunta="";
        this.materia="";
        this.tema="";
        this.preguntaID=-1;
        this.numeroIncisos=4;
        this.I=new ArrayList<>();
        this.V=new ArrayList<>();
        for(int i=0;i<this.numeroIncisos;++i){
            Inciso in=new Inciso((char) (I.size()+'a'));
            I.add(in);
        }
    }
    public Pregunta(String materia,String tema,String pregunta,String tipo){
        this.tipo=tipo;
        this.materia=materia;
        this.pregunta=pregunta;
        this.tema=tema;
        this.I=new ArrayList<>();
        this.V=new ArrayList<>();
    }
    public void randomizeIncisos(){
        Collections.shuffle(I);
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

    public int getNumeroIncisos() {
        return numeroIncisos;
    }

    public int getPreguntaID() {
        return preguntaID;
    }

    public List<Inciso> getI() {
        return I;
    }

    public void setI(List<Inciso> I) {
        this.I = I;
    }

    public void setNumeroIncisos(int numeroIncisos) {
        this.numeroIncisos = numeroIncisos;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setPreguntaID(int preguntaID) {
        this.preguntaID = preguntaID;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setV(List<Variable> V) {
        this.V = V;
    }

    public List<Variable> getV() {
        return V;
    }
    
    
}
