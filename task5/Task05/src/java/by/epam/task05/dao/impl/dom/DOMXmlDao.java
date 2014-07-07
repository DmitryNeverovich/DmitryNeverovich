/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao.impl.dom;

import by.epam.task05.controller.Controller;
import by.epam.task05.dao.XMLDAO;
import by.epam.task05.dao.XMLDAOException;
import by.epam.task05.dao.entity.Flower;
import by.epam.task05.dao.impl.sax.SaxXmlDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Dima
 */
public class DOMXmlDao implements XMLDAO{
    
    private final static SaxXmlDao instance = new SaxXmlDao();
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(Controller.class);
    
    public static SaxXmlDao getInstance() {
        return instance;
    }
    
    @Override
    public List<Flower> parse(String resourceName) throws XMLDAOException {
        List<Flower> flowersResult = null;
        try {
            DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(resourceName);
            Element root = document.getDocumentElement();
            
            flowersResult = parserGreenhouse(root);
            
        } catch (ParserConfigurationException ex) {
            logger.warn("Error parser configuration");
            throw new XMLDAOException("Error parser configuration", ex);
        } catch (SAXException ex) {
            logger.warn("Error sax parser");
            throw new XMLDAOException("Error sax parser", ex);
        } catch (IOException ex) {
            logger.warn("Error ioexception");
            throw new XMLDAOException("Error ioexception", ex);
        }
        return flowersResult;
    }
    
    private List<Flower> parserGreenhouse(Element rootElement){
        List<Flower> flowers = new ArrayList<Flower>();
        Flower curr;
        NodeList flowersNodes = rootElement.getElementsByTagName("Flower");
        
        for (int i = 0; i < flowersNodes.getLength(); i++) {
            Element flowerElement = (Element) flowersNodes.item(i);
           
            curr = new Flower();
            curr.setId(flowerElement.getAttribute("id"));
            curr.setFamily(flowerElement.getAttribute("family"));
            curr.setName(getChildValue(flowerElement, "name"));
            curr.setHight(getChildValue(flowerElement, "hight"));
            curr.setSoil(getChildValue(flowerElement, "soil"));
            curr.setOrigin(getChildValue(flowerElement, "origin"));
            curr.setMyltiplying(getChildValue(flowerElement, "myltiplying"));
            
            Element visualParameterElement = getChild(flowerElement, "visualParameters");
            curr.setColorStalk(getChildValue(visualParameterElement, "colorStalk"));
            curr.setColorList(getChildValue(visualParameterElement, "colorList"));
            
            Element growingtipsElement = getChild(visualParameterElement, "growingtips");
            curr.setTemperature(Integer.valueOf(getChildValue(growingtipsElement, "temperature")));
            curr.setLight(getChildValue(growingtipsElement, "light"));
            curr.setWater(Integer.valueOf(getChildValue(growingtipsElement, "water")));
            
            flowers.add(curr);
        }
        return flowers;
    }
    
    protected String getChildValue(Element parent, String childName) {
        Element child = getChild(parent, childName);
        Node node = child.getFirstChild();
        String value = node.getNodeValue();

        return value;
    }

    protected Element getChild(Element parent, String childName) {
        NodeList nlist = parent.getElementsByTagName(childName);
        Element child = (Element) nlist.item(0);

        return child;
    }
    
}
