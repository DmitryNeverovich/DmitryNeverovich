/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao.impl.sax;

import by.epam.task05.dao.entity.Flower;
import by.epam.task05.dao.impl2.FlowerEnum;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 *
 * @author Dima
 */
public class SaxFlowerHandler implements ContentHandler{

    private List<Flower> list = new ArrayList<Flower>();
    private Flower curr = null;
    private FlowerEnum currentEnum = null;

    public List<Flower> getFlowers() {
        return list;
    }
        
    @Override
    public void setDocumentLocator(Locator locator) {
        
    }

    @Override
    public void startDocument() throws SAXException {
        
        list = new ArrayList<>();
    }

    @Override
    public void endDocument() throws SAXException {
        
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
        
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (localName.equals("flower")) {
            curr = new Flower();
            curr.setId(atts.getValue(0));
            curr.setFamily(atts.getValue(1));
        } 
        if (!"flower".equals(localName) &&
            !"visualParameters".equals(localName) &&
            !"greenhouse".equals(localName) &&    
            !"growingtips".equals(localName)) {
            
            currentEnum = FlowerEnum.valueOf(qName.toUpperCase());
        }        
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("flower")) {
            list.add(curr);
        }
        currentEnum = null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String tagValue = new String(ch,start,length).trim();
        if (currentEnum == null) {
            return;
        }
        switch(currentEnum){
            case NAME:
                curr.setName(tagValue);
                break;
            case HIGHT:
                curr.setHight(tagValue);
                break;
            case SOIL:
                curr.setSoil(tagValue);
                break;
            case ORIGIN:
                curr.setOrigin(tagValue);
                break;
            case MULTIPLYING:
                curr.setMyltiplying(tagValue);
                break;
            case COLORSTALK:
                curr.setColorStalk(tagValue);
                break;
            case COLORLIST:
                curr.setColorList(tagValue);
                break;
            case TEMPERATURE:
                curr.setTemperature(Integer.valueOf(tagValue));
                break;
            case LIGHT:
                curr.setLight(tagValue);
                break; 
            case WATER:
                curr.setWater(Integer.valueOf(tagValue));
                break;     
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
        
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
        
    }
    
}
