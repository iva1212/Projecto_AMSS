/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

/**
 *
 * @author ivann
 */
public class Inciso {
    private  String letra;
    private  String inciso;
    private  boolean correct;
    public Inciso(){
        this.letra="";
        this.inciso="";
        this.correct=false;
    }
    public Inciso(char l){
        this.letra=Character.toString(l);
        this.inciso="";
        this.correct=false;
        
        
    }
    public Inciso(String l,String i,boolean c){
        this.letra=l;
        this.inciso=i;
        this.correct=c;
        
    }
    public  HBox display(){
        HBox inci=new HBox(20);
        
       
        Label text=new Label();
        text.setText(letra+')');
        text.setTextFill(Color.web("#000000"));
        text.setStyle(Style.Montserrat_Light);
        TextArea i=new TextArea();
        i.setText(inciso);
        i.setPrefSize(350, 30);
        CheckBox c=new CheckBox();
        c.setSelected(correct);
        inci.getChildren().addAll(text,i,c);
      
        return inci;  
    }

    public  String getInciso() {
        return inciso;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    
}
