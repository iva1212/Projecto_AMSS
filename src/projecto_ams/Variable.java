/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

/**
 *
 * @author ivann
 */
public class Variable {
    private String variable;
    private int min;
    private int max;
    
   public Variable(){
       this.variable="";
       this.min=0;
       this.max=0;
   }
   public Variable(String variable,int min,int max){
       this.variable=variable;
       this.min=min;
       this.max=max;
   }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getVariable() {
        return variable;
    }

    public int getMin() {
        return min;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public void setMin(int min) {
        this.min = min;
    }
   
}
