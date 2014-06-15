/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package task04.workxml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Dima
 */
public class WorkXML {
    public static boolean xml2html(String xslSource,String xmlSource,String xmlResult){
        boolean complete = false;
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            
            Transformer transformer = tf.newTransformer(new StreamSource(xslSource));
            transformer.transform(new StreamSource(xmlSource),new StreamResult(xmlResult) );
            
            complete= true;
            
        } catch (TransformerFactoryConfigurationError | TransformerException e) {
            e.printStackTrace();
        }
        return complete;        
    }
}
