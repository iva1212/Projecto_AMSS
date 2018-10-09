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
import javafx.collections.ObservableList;

/**
 *
 * @author ivann
 */
public class ControladorBD {
     // JDBC driver name and database URL 
   static final String JDBC_DRIVER = "org.h2.Driver";   
   static final String DB_URL = "jdbc:h2:file:./data/Preguntas";  
   
   //  Database credentials 
   static final String USER = "sa"; 
   static final String PASS = ""; 
    public static void crearBase(){
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
         String sql =
"CREATE TABLE Materia(\n" +
"	materiaID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	nombreMateria CHAR(100) UNIQUE\n" +
");\n" +
"\n" +

"CREATE TABLE Tema(\n" +
"	temaID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	nombreTema VARCHAR(100),\n" +
"	materiaID INT,\n" +
"	FOREIGN KEY (materiaID) REFERENCES Materia(materiaID)\n" +
");\n" +

"CREATE TABLE Pregunta(\n" +
"	preguntaID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	pregunta VARCHAR(200),\n" +
"	tipoPregunta VARCHAR(30),\n" +
"	temaID INT,\n" +
"	FOREIGN KEY (temaID) REFERENCES Tema(materiaID)\n" +
");\n" +

"CREATE TABLE Inciso(\n" +
"	incisoID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	letraInciso VARCHAR(1),\n" +
"	inciso VARCHAR(200),\n" +
"	esRespuesta BOOLEAN,\n" +
"	preguntaID INT,\n" +
"	FOREIGN KEY (preguntaID) REFERENCES Pregunta(preguntaID)\n" +
");\n" +

"CREATE TABLE Variable(\n" +
"	variableID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	variable VARCHAR(5),\n" +
"	rangoMin INT,\n" +
"	rangoMax INT,\n" +
"	preguntaID INT,\n" +
"	FOREIGN KEY (preguntaID) REFERENCES Pregunta(preguntaID)\n" +
");";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
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
    public static void agrMateria(String str ){
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
         String sql ="INSERT INTO Materia(nombreMateria) VALUES('"+str+"');";
         stmt.executeUpdate(sql);
         System.out.println("Updated Materias"); 
         
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
    public static void deletMateria(String str ){
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
         String sql ="DELETE FROM Materia WHERE nombreMateria='"+str+"';";
         stmt.executeUpdate(sql);
         System.out.println("Borrado Materias"); 
         
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
    public static void agrTema(String materia,String str ){
      Connection conn = null; 
      Statement stmt = null; 
      int IDmat=-1;
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
         System.out.println(materia+" "+str+" q p2");
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
          
         //Query para encontrar materiaID
         String sql="SELECT m.materiaID\n" +
        "FROM Materia m\n" +
        "WHERE m.nombreMateria='"+materia+"';";
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
          IDmat=rs.getInt("materiaID");
         }
         
         
         sql ="INSERT INTO Tema(nombreTema,materiaID) VALUES('"+str+"',"+Integer.toString(IDmat)+");";
         stmt.executeUpdate(sql);
         System.out.println("Updated Temas"); 
         
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
    public static void deletTema(String materia,String tema){
      Connection conn = null; 
      Statement stmt = null; 
      int IDmat=-1;
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
             
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
         
         String sql="SELECT m.materiaID\n" +
        "FROM Materia m\n" +
        "WHERE m.nombreMateria='"+materia+"';";
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
          IDmat=rs.getInt("materiaID");
         }
         sql="DELETE FROM Tema WHERE nombreTema='"+tema+"' AND materiaID="+Integer.toString(IDmat)+";";
         stmt.executeUpdate(sql);
         System.out.println("Borrando Tema"); 
         
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
    public static List<String> leerMaterias(){
        List<String> lista= new ArrayList<>();
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
         String sql ="SELECT Materia.nombreMateria\n" +
        "FROM Materia;";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println("Conseguido Materias");
         while(rs.next()) { 
            // Retrieve by column name 
            String nombre=rs.getString("nombreMateria");
            System.out.println(nombre);
            lista.add(nombre);
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
      return lista;
    }
    public static List<String> leerTemas(String materia){
        List<String> lista= new ArrayList<>();
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
         String sql ="SELECT t.nombreTema\n" +
"FROM Tema t,Materia m\n" +
"WHERE t.materiaID=m.materiaID AND m.nombreMateria='"+materia+"';";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println("Conseguido Temas");
         while(rs.next()) { 
            // Retrieve by column name 
            String nombre=rs.getString("nombreTema");
            System.out.println(nombre);
            lista.add(nombre);
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
      return lista;
    }
}

