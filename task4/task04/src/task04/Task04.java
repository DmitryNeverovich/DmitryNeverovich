/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package task04;

import com.example.greenhouse.Greenhouse;
import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import task04.workxml.WorkXML;

/**
 *
 * @author Dima
 */
public class Task04 {

    public static void main(String[] args) throws JAXBException {
        
        //JAXB
        
        File xmlFile = new File("xml-source//Greenhouse.xml");
        JAXBContext jc = JAXBContext.newInstance(Greenhouse.class);
        Unmarshaller u = jc.createUnmarshaller();
        Greenhouse greenhouse = (Greenhouse)u.unmarshal(xmlFile);
        
        List<com.example.greenhouse.Flower> flowers = greenhouse.getFlower();
        
        System.out.println(flowers);
        
        //XSLT
        
        boolean compete = WorkXML.xml2html("xml-source//Greenhouse.xsl","xml-source//Greenhouse.xml","html-result//Greenhouse.html");
        
        if (compete) {
            System.out.println("Transform complete.");
        } else {
            System.out.println("Transform error.");
        }
    }
    
}
