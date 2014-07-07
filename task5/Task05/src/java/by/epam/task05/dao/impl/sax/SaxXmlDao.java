/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao.impl.sax;

import by.epam.task05.dao.XMLDAO;
import by.epam.task05.dao.XMLDAOException;
import by.epam.task05.dao.entity.Flower;
import by.epam.task05.logic.impl.ParsingXml;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Dima
 */
public class SaxXmlDao implements XMLDAO{
    
    private final static SaxXmlDao instance = new SaxXmlDao();
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ParsingXml.class);

    public static SaxXmlDao getInstance() {
        return instance;
    }
            
    @Override
    public List<Flower> parse(String resourceName) throws XMLDAOException {
                
        List<Flower> list;//!!!!!!!!!!!
        try {
            
            XMLReader reader = XMLReaderFactory.createXMLReader();
            SaxFlowerHandler flowerHandler = new SaxFlowerHandler();
            reader.setContentHandler(flowerHandler);
            reader.parse(resourceName);
            list = flowerHandler.getFlowers();
        } catch (FileNotFoundException ex) {
            logger.warn("FileNotFoundException");
            throw new XMLDAOException("file not found", ex);    
        } catch (IOException ex) {
            logger.warn("IOException");
            throw new XMLDAOException("IOException ", ex);
        } catch (SAXException ex) {
            logger.warn("sax parser error");
            throw new XMLDAOException("sax parser error", ex);
        }
        return list;
    }
    
}
