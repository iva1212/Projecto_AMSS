/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto_ams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;



import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author ivann
 */
public class CreaciondeExamen {
    private  String xmlURL;
    public CreaciondeExamen(){
       this.xmlURL="";
    }
     public void CrearExamen(String titulo,String subtitulo,String instruciones,String materia,List<String> temas,List <Integer> nums,int numeroExamenes){
         List<Pregunta> preguntas=ControladorBD.leerPreguntas();
         for(int i=0;i<preguntas.size();i++){
             preguntas.get(i).setI(ControladorBD.leerIncisos(preguntas.get(i)));
             preguntas.get(i).setV(ControladorBD.leerVariables(preguntas.get(i)));
         }
         
         Collections.shuffle(preguntas);
         List<Pregunta> preg=new ArrayList<>();
         System.out.println(materia);
        for(int i=0;i<temas.size();i++){
            for(int j=0;j<preguntas.size();j++){
                System.out.println(preguntas.get(j).getTema());
                if(preguntas.get(j).getMateria().equals(materia) && preguntas.get(j).getTema().equals(temas.get(i).toString()) && nums.get(i)>0 ){
                    if(!preguntas.get(j).getV().isEmpty()){
                        System.out.println(preguntas.get(j).getV().get(0).getVariable());
                    }
                    preg.add(preguntas.get(j));
                    nums.set(i, nums.get(i)-1);
                }
            }
        }
        System.out.println(preg.get(0).getI().get(0).getInciso());
        
        for(int i=0;i<preg.size();i++){
            preg.get(i).randomizeIncisos();
        }
        crearXML(titulo,subtitulo,instruciones,preg,numeroExamenes);
        try {
            crearPDF(titulo,subtitulo,false);
            crearPDF(titulo,subtitulo,true);
        } catch (FOPException ex) {
            Logger.getLogger(CreaciondeExamen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(CreaciondeExamen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CreaciondeExamen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        System.out.println("Se creo examen");
     }
     private void crearXML(String titulo,String subtitulo,String instruciones,List<Pregunta>preg,int numExamenes){
        String newTitulo= titulo.replace(" ","_");
        String newSubtitulo=subtitulo.replace(" ","_");
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
         Date date = new Date();  
         int contPreguntas=0;
         xmlURL="templates\\examen_"+newTitulo+"_"+newSubtitulo+".xml";
         try {
             DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
             Document document = documentBuilder.newDocument();
             Element root = document.createElement("crearExamen");
             document.appendChild(root);
             for(int z=0;z<numExamenes;z++){
                Element examen = document.createElement("examen");
                root.appendChild(examen);

                Element ti=document.createElement("titulo");
                ti.appendChild(document.createTextNode(titulo));
                examen.appendChild(ti);

                Element sub=document.createElement("subtitulo");
                sub.appendChild(document.createTextNode(subtitulo));
                examen.appendChild(sub);
                
                Element nombre=document.createElement("nombre");
                nombre.appendChild(document.createTextNode("Nombre:_________________"));
                examen.appendChild(nombre);
                
                Element fecha=document.createElement("fecha");
                fecha.appendChild(document.createTextNode("Fecha:_________________"));
                examen.appendChild(fecha);
                
                Element instructor=document.createElement("instructor");
                instructor.appendChild(document.createTextNode("Profesor:_________________"));
                examen.appendChild(instructor);
                
                Element matricula=document.createElement("matricula");
                matricula.appendChild(document.createTextNode("Matricula:_________________"));
                examen.appendChild(matricula);
                
                Element instrucionesE=document.createElement("instruciones");
                instrucionesE.appendChild(document.createTextNode(instruciones));
                examen.appendChild(instrucionesE);

                for(int t=0;t<preg.size();t++){
                    
                    Pregunta p=new Pregunta();
                    p.equals(preg.get(t));
                    p=cambiarVariables(p);
                    
                    Element pregunta = document.createElement("pregunta");
                    examen.appendChild(pregunta);

                    Element numpregunta = document.createElement("numpregunta");
                    numpregunta.appendChild(document.createTextNode(Integer.toString(t+1)));
                    pregunta.appendChild(numpregunta);

                    Element textoPregunta = document.createElement("textoPregunta");
                    textoPregunta.appendChild(document.createTextNode(p.getPregunta()));
                    pregunta.appendChild(textoPregunta);
                    
                    Element tipo = document.createElement("tipo");
                    tipo.appendChild(document.createTextNode(p.getTipo()));
                    pregunta.appendChild(tipo);
                    

                    for(int i=0;i<p.getI().size();i++){
                        Element inciso=document.createElement("inciso");
                        pregunta.appendChild(inciso);
                        
                        Element letra=document.createElement("letra");
                        letra.appendChild(document.createTextNode(""+((char)('a'+i))));
                        inciso.appendChild(letra);
                        Element textoInciso = document.createElement("textoInciso");
                        System.out.println(p.getI().get(i).getInciso());
                        
                        textoInciso.appendChild(document.createTextNode(p.getI().get(i).getInciso()));
                        inciso.appendChild(textoInciso);

                        Element respuesta =document.createElement("respuesta");
                        if(p.getI().get(i).isCorrect()){
                           respuesta.appendChild(document.createTextNode("si"));
                        }
                        else{
                            respuesta.appendChild(document.createTextNode("no"));
                        }
                        inciso.appendChild(respuesta);
                    }
                    
                }
                Collections.shuffle(preg);
                for(int i=0;i<preg.size();i++){
                    preg.get(i).randomizeIncisos();
                }
             }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            File xmlFile=new File(xmlURL);
            
            StreamResult streamResult = new StreamResult(xmlFile);
            
            transformer.transform(domSource, streamResult);
            System.out.println("Se creo el archivo XML");

             
         
         } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        }catch (TransformerException tfe) {
            tfe.printStackTrace();
        } 
     }
     private void crearPDF(String titulo,String subtitulo,boolean isRespuesta) throws FileNotFoundException, TransformerConfigurationException, FOPException, TransformerException, IOException{
        String newTitulo= titulo.replace(" ","_");
        String newSubtitulo=subtitulo.replace(" ","_");
         // the XSL FO file
         SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
         Date date = new Date(); 
         File xsltFile;
         if(isRespuesta){
            xsltFile = new File("templates\\template_R.xsl");
         }
         else{
            xsltFile = new File("templates\\template_E.xsl");
         }
        // the XML file which provides the input
        StreamSource xmlSource = new StreamSource(new File(xmlURL));
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
       if(isRespuesta){
            out = new java.io.FileOutputStream("Examenes\\Respuestas_"+newTitulo+"_"+newSubtitulo+"_"+formatter.format(date)+".pdf");
       }
       else{
           out = new java.io.FileOutputStream("Examenes\\Examenes_"+newTitulo+"_"+newSubtitulo+"_"+formatter.format(date)+".pdf");
       }
    
        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
         
         
         
         
     }
     private Pregunta cambiarVariables(Pregunta pregunta){
         Pregunta preg=pregunta;
         String test=preg.getPregunta();
         Random rand = new Random(); 
         for(int i=0;i<preg.getV().size();i++){
             String var=preg.getV().get(i).getVariable();
             int min=preg.getV().get(i).getMin();
             int max=preg.getV().get(i).getMax();
             int randomNum=rand.nextInt((max - min) + 1) + min;
             
             System.out.println(randomNum);
             test = test.replace(var,Integer.toString(randomNum));
             System.out.println(test);
             for(int j=0;j<preg.getI().size();j++){
                 String inci=preg.getI().get(j).getInciso();
                 inci=inci.replace(var,Integer.toString(randomNum));
                 preg.getI().get(j).setInciso(inci);
             }
         }
         preg.setPregunta(test);
         
         System.out.println(preg.getPregunta());
         
         List <String> formulas=new ArrayList<>();
         formulas=hacerFormulas(preg.getPregunta());
         preg.setPregunta(remplazarFormulas(formulas,preg.getPregunta()));
         for(int i=0;i<preg.getI().size();i++){
             formulas=hacerFormulas(preg.getI().get(i).getInciso());
             preg.getI().get(i).setInciso(remplazarFormulas(formulas,preg.getI().get(i).getInciso()));
             
         }
         
         
         return preg;
         
     }
     private List<String> hacerFormulas(String s){
         boolean formula=false;
         List <String> formulas=new ArrayList<>();
         int numFor=0;
         String placeholder="";
         for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c=='['){
                   formula=true;
                }
                else if(c==']'){
                    formula=false;
                    formulas.add(placeholder);
                    numFor++;
                    placeholder="";
                }
                else if(formula){
                    placeholder+=c;
                }
            }
         
         return formulas;
         
     }
     private String remplazarFormulas(List<String> formulas,String texto){
         ScriptEngineManager mgr = new ScriptEngineManager();
         ScriptEngine engine = mgr.getEngineByName("JavaScript");
         String text=texto;
         for(int i=0;i<formulas.size();i++){
             try {
                 Object result=engine.eval(formulas.get(i));
                 System.out.println(result.toString());
                 text=text.replace("["+formulas.get(i)+"]",result.toString());
                 
             } catch (ScriptException ex) {
                 Logger.getLogger(CreaciondeExamen.class.getName()).log(Level.SEVERE, null, ex);
             }
             
         }
         return text;
     }
}

