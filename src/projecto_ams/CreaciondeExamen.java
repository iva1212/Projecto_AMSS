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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;



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
    private static String xmlURL;
     public static void CrearExamen(String titulo,String subtitulo,String materia,List<String> temas,List <Integer> nums,int numeroExamenes){
         List<Pregunta> preguntas=ControladorBD.leerPreguntas();
         for(int i=0;i<preguntas.size();i++){
             preguntas.get(i).setI(ControladorBD.leerIncisos(preguntas.get(i)));
         }
         
         Collections.shuffle(preguntas);
         List<Pregunta> preg=new ArrayList<>();
         System.out.println(materia);
        for(int i=0;i<temas.size();i++){
            for(int j=0;j<preguntas.size();j++){
                System.out.println(preguntas.get(j).getTema());
                if(preguntas.get(j).getMateria().equals(materia) && preguntas.get(j).getTema().equals(temas.get(i).toString()) && nums.get(i)>0 ){
                    preg.add(preguntas.get(j));
                    nums.set(i, nums.get(i)-1);
                }
            }
        }
        System.out.println(preg.get(0).getI().get(0).getInciso());
        for(int i=0;i<preg.size();i++){
            preg.get(i).randomizeIncisos();
        }
        crearXML(titulo,subtitulo,preg,numeroExamenes);
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
     private static void crearXML(String titulo,String subtitulo,List<Pregunta>preg,int numExamenes){
         SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
         Date date = new Date();  
         int contPreguntas=0;
         xmlURL="C:\\Temp\\examen_"+titulo+"_"+subtitulo+".xml";
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

                Element fecha=document.createElement("fecha");
                fecha.appendChild(document.createTextNode(formatter.format(date)));
                examen.appendChild(fecha);

                Element nombre=document.createElement("nombre");
                nombre.appendChild(document.createTextNode("Nombre:_____________"));
                examen.appendChild(nombre);

                for(int t=0;t<preg.size();t++){
                    Element pregunta = document.createElement("pregunta");
                    examen.appendChild(pregunta);

                    Element numpregunta = document.createElement("numpregunta");
                    numpregunta.appendChild(document.createTextNode(Integer.toString(t+1)));
                    pregunta.appendChild(numpregunta);

                    Element textoPregunta = document.createElement("textoPregunta");
                    textoPregunta.appendChild(document.createTextNode(preg.get(t).getPregunta()));
                    pregunta.appendChild(textoPregunta);

                    System.out.println("El numero de preguntas es:"+preg.size());
                    System.out.println("El numero de incisos"+preg.get(t).getI().size());

                    for(int i=0;i<preg.get(t).getI().size();i++){
                        Element inciso=document.createElement("inciso");
                        pregunta.appendChild(inciso);
                        Element letra=document.createElement("letra");
                        letra.appendChild(document.createTextNode(""+((char)('a'+i))));
                        inciso.appendChild(letra);

                        Element textoInciso = document.createElement("textoInciso");
                        System.out.println(preg.get(t).getI().get(i).getInciso());
                        textoInciso.appendChild(document.createTextNode(preg.get(t).getI().get(i).getInciso()));
                        inciso.appendChild(textoInciso);

                        Element respuesta =document.createElement("respuesta");
                        if(preg.get(t).getI().get(i).isCorrect()){
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
     private static void crearPDF(String titulo,String subtitulo,boolean isRespuesta) throws FileNotFoundException, TransformerConfigurationException, FOPException, TransformerException, IOException{
         // the XSL FO file
         SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");  
         Date date = new Date(); 
         File xsltFile;
         if(isRespuesta){
            xsltFile = new File("templates\\template_R.xsl");
         }
         else{
            xsltFile = new File("templates\\template _E.xsl");
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
            out = new java.io.FileOutputStream("Examenes\\Respuestas_"+titulo+"_"+subtitulo+"_"+formatter.format(date)+".pdf");
       }
       else{
           out = new java.io.FileOutputStream("Examenes\\Examenes_"+titulo+"_"+subtitulo+"_"+formatter.format(date)+".pdf");
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
}

