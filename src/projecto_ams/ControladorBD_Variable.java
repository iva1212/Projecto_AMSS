/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static projecto_ams.ControladorBD.JDBC_DRIVER;

/**
 *
 * @author ivann
 */
public class ControladorBD_Variable extends ControladorBD {
     public static void agrVariable(Variable v){
         Connection conn = null; 
      Statement stmt = null; 
      int pregID=-1;
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
         
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         
         String sql1="SELECT MAX(Pregunta.preguntaID) AS preguntaID\n" +
"FROM Pregunta;";
         ResultSet rs =stmt.executeQuery(sql1);
         while(rs.next()){
             pregID=rs.getInt("preguntaID");
             System.out.println(pregID);
         }
         
            String sql ="INSERT INTO Variable(variable,rangoMin,rangoMax,preguntaID) VALUES('"+v.getVariable()+"',"+v.getMin()+","+v.getMax()+","+pregID+");";
            stmt.executeUpdate(sql);
            System.out.println("Updated Variable"); 
         
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
        
    }
    
    
    public static void deletVariable(Pregunta preg,Variable v){
         Connection conn = null; 
      Statement stmt = null; 
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         if(preg.getPreguntaID() !=-1 && v.getVarID()!=-1){
            String sql="DELETE FROM Variable WHERE preguntaID="+Integer.toString(preg.getPreguntaID())+" AND variableID="+v.getVarID()+";";
            stmt.executeUpdate(sql);
            System.out.println("Borrando Variable"); 
         }
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
     }
    
    
    
    public static List<Variable> leerVariables(Pregunta preg){
       List<Variable> variables = new ArrayList<>();
       Connection conn = null; 
      Statement stmt = null; 
      String tema;
      String materia;
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         String sql ="SELECT *\n" +
        "FROM Variable\n" +
        "WHERE Variable.preguntaID="+Integer.toString(preg.getPreguntaID())+";";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println("Conseguido Incisos");
         System.out.println(rs.toString());
         while(rs.next()) { 
            System.out.println(rs.toString());
            Variable var=new Variable();
            var.setVarID(rs.getInt("variableID"));
            var.setVariable(rs.getString("variable"));
            var.setMin(rs.getInt("rangoMin"));
            var.setMax(rs.getInt("rangoMax"));
          
            variables.add(var);
         }
         // STEP 4: Clean-up environment 
         rs.close();
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.printStackTrace(); 
      } catch(Exception e) { 
         //Handle errors for Class.forName 
         e.printStackTrace(); 
      } finally { 
         //finally block used to close resources 
         try{ 
            if(stmt!=null) stmt.close(); 
         } catch(SQLException se2) { 
         } // nothing we can do 
         try { 
            if(conn!=null) conn.close(); 
         } catch(SQLException se){ 
            se.printStackTrace(); 
         } //end finally try 
      } //end try 
      System.out.println("Goodbye!");
      return variables;
        
    }
}