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
"	FOREIGN KEY (materiaID) REFERENCES Materia(materiaID) ON DELETE CASCADE\n" +
");\n" +

"CREATE TABLE Pregunta(\n" +
"	preguntaID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	pregunta VARCHAR(200),\n" +
"	tipoPregunta VARCHAR(30),\n" +
"	temaID INT,\n" +
"	FOREIGN KEY (temaID) REFERENCES Tema(temaID) ON DELETE CASCADE\n" +
");\n" +

"CREATE TABLE Inciso(\n" +
"	incisoID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	letraInciso VARCHAR(10),\n" +
"	inciso VARCHAR(200),\n" +
"	esRespuesta BOOLEAN,\n" +
"	preguntaID INT,\n" +
"	FOREIGN KEY (preguntaID) REFERENCES Pregunta(preguntaID) ON DELETE CASCADE\n" +
");\n" +

"CREATE TABLE Variable(\n" +
"	variableID INTEGER PRIMARY KEY AUTO_INCREMENT,\n" +
"	variable VARCHAR(5),\n" +
"	rangoMin INT,\n" +
"	rangoMax INT,\n" +
"	preguntaID INT,\n" +
"	FOREIGN KEY (preguntaID) REFERENCES Pregunta(preguntaID) ON DELETE CASCADE\n" +
");";  
         stmt.executeUpdate(sql);
         System.out.println("Created table in given database..."); 
         
         // STEP 4: Clean-up environment 
         stmt.close(); 
         conn.close(); 
      } catch(SQLException se) { 
         //Handle errors for JDBC 
         se.getMessage();
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
    public static void agrPregunta(String tema,Pregunta preg){
      Connection conn = null; 
      Statement stmt = null; 
      int IDtem=-1;
      try { 
         // STEP 1: Register JDBC driver 
         Class.forName(JDBC_DRIVER); 
         
         //STEP 2: Open a connection 
         System.out.println("Connecting to database..."); 
         conn = DriverManager.getConnection(DB_URL,USER,PASS);  
         
         //STEP 3: Execute a query 
         System.out.println("Creating table in given database..."); 
         stmt = conn.createStatement(); 
          
         //Query para encontrar materiaID
         String sql="SELECT t.temaID\n" +
        "FROM Tema t\n" +
        "WHERE t.nombreTema='"+tema+"';";
         ResultSet rs = stmt.executeQuery(sql);
         while(rs.next()){
          IDtem=rs.getInt("temaID");
         }
         
         
         sql ="INSERT INTO Pregunta(pregunta,tipoPregunta,temaID) VALUES('"+preg.getPregunta()+"','"+preg.getTipo()+"',"+Integer.toString(IDtem)+");";
         stmt.executeUpdate(sql);
         System.out.println("Updated Preguntas"); 
         
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
    public static void agrInciso(List<Inciso> I){
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
         
         for(int i=0;i<I.size();i++){
            int res= I.get(i).isCorrect() ? 1:0;
            String sql ="INSERT INTO Inciso(letraInciso,inciso,esRespuesta,preguntaID) VALUES('"+I.get(i).getLetra()+"','"+I.get(i).getInciso()+"',"+res+","+pregID+");";
            stmt.executeUpdate(sql);
            System.out.println("Updated Inciso"); 
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
     public static void deletPregunta(Pregunta preg){
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
         if(preg.getPreguntaID() !=-1){
            String sql="DELETE FROM Pregunta WHERE preguntaID="+Integer.toString(preg.getPreguntaID())+";";
            stmt.executeUpdate(sql);
            System.out.println("Borrando Pregunta"); 
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
    public static List<Pregunta> leerPreguntas(){
      Connection conn = null; 
      Statement stmt = null; 
      List<Pregunta> preguntas = new ArrayList<>();
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
            "FROM Pregunta;";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println("Conseguido preguntas");
         while(rs.next()) { 
            // Retrieve by column name 
           Statement stmt2 = conn.createStatement(); 
           Pregunta preg=new Pregunta();
           int temaID=rs.getInt("temaID");
           preg.setPregunta(rs.getString("pregunta"));
           preg.setPreguntaID(rs.getInt("preguntaID"));
           preg.setTipo(rs.getString("tipoPregunta"));
           int materiaID;
           sql="SELECT nombreTema,materiaID\n" +
            "FROM Tema \n" +
            "WHERE temaID="+Integer.toString(temaID)+";";
           ResultSet rs2=stmt2.executeQuery(sql);
           System.out.println(rs2.toString());
           rs2.next();
           tema=rs2.getString("nombreTema");
           materiaID=rs2.getInt("materiaID");
           sql="SELECT m.nombreMateria\n" +
            "FROM Materia m\n" +
            "WHERE m.materiaID="+Integer.toString(materiaID)+";";
           rs2=stmt2.executeQuery(sql);
           rs2.next();
           materia=rs2.getString("nombreMateria");
           preg.setTema(tema);
           preg.setMateria(materia);
           preguntas.add(preg);
           rs2.close();
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
      return preguntas;
        
    }
    public static List<Inciso> leerIncisos(Pregunta preg){
       List<Inciso> incisos = new ArrayList<>();
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
        "FROM Inciso\n" +
        "WHERE Inciso.preguntaID="+Integer.toString(preg.getPreguntaID())+";";
         ResultSet rs = stmt.executeQuery(sql);
         System.out.println("Conseguido Incisos");
         System.out.println(rs.toString());
         while(rs.next()) { 
            System.out.println(rs.toString());
            Inciso in=new Inciso();
            in.setInciso(rs.getString("inciso"));
            in.setLetra(rs.getString("letraInciso"));
            boolean corr=(rs.getInt("esRespuesta")==1);
            System.out.println(rs.getInt("esRespuesta"));
            in.setCorrect(corr);
            incisos.add(in);
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
      return incisos;
        
    }
}

