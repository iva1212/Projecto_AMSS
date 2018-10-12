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
    private TextArea i;
    private CheckBox c;
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
        text.setText(letra+':');
        text.setTextFill(Color.web("#000000"));
        text.setStyle(Style.Montserrat_Light);
        i=new TextArea();
        c=new CheckBox();
        i.setText(inciso);
        i.setPrefSize(350, 30);
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

    public boolean isCorrect() {
        return correct;
    }

    public void setInciso(String inciso) {
        this.inciso = inciso;
    }
    public void save(){
        setInciso(i.getText());
        setCorrect(c.isSelected());
    }

    public String getLetra() {
        return letra;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    
}
