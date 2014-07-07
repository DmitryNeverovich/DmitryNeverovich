/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task05.dao.impl.stax;

import by.epam.task05.dao.XMLDAO;
import by.epam.task05.dao.XMLDAOException;
import by.epam.task05.dao.entity.Flower;
import by.epam.task05.dao.impl2.FlowerEnum;
import by.epam.task05.dao.impl.sax.SaxXmlDao;
import by.epam.task05.logic.impl.ParsingXml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Dima
 */
public class StaXXmlDao implements XMLDAO {
    
    private final static SaxXmlDao instance = new SaxXmlDao();
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ParsingXml.class);
    
    public static SaxXmlDao getInstance() {
        return instance;
    }
    
    private List<Flower> flowers;

    @Override
    public List<Flower> parse(String resourceName) throws XMLDAOException {
        InputStream input;
        try {
            input = new FileInputStream(resourceName);
        } catch (FileNotFoundException ex) {
            logger.warn("FileNotFoundException");
            throw new XMLDAOException("File not found", ex);
        }
        parse(input);
        return flowers;
    }

    private void parse(InputStream input) throws XMLDAOException {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            process(reader);
        } catch (XMLStreamException e) {
            logger.warn("XMLStreamException");
            throw new XMLDAOException("XMLStreamException", e);
        }
    }

    private void process(XMLStreamReader reader) throws XMLStreamException {
        flowers = new ArrayList<Flower>();
        FlowerEnum currentEnum = null;
        Flower curr = null;

        while (reader.hasNext()) {
            int type = reader.next();
            String name;

            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("Flower")) {
                        curr = new Flower();
                        curr.setId(reader.getAttributeValue(null, FlowerEnum.ID.name().toLowerCase()));
                        curr.setFamily(reader.getAttributeValue(null, FlowerEnum.FAMILY.name().toLowerCase()));
                    }

                    if (!"Greenhouse".equals(name)
                            && !"Flower".equals(name)
                            && !"visualParameters".equals(name)
                            && !"growingtips".equals(name)
                            && !"VisualParameters".equals(name)) {
                        currentEnum = FlowerEnum.valueOf(name.toUpperCase());
                    }
                    break;

                case XMLStreamConstants.CHARACTERS:
                    switch (currentEnum) {
                        case NAME:
                            curr.setName(reader.getText());
                            break;
                        case HIGHT:
                            curr.setHight(reader.getText());
                            break;
                        case SOIL:
                            curr.setSoil(reader.getText());
                            break;
                        case ORIGIN:
                            curr.setOrigin(reader.getText());
                            break;
                        case MULTIPLYING:
                            curr.setMyltiplying(reader.getText());
                            break;
                        case COLORSTALK:
                            curr.setColorStalk(reader.getText());
                            break;
                        case COLORLIST:
                            curr.setColorList(reader.getText());
                            break;
                        case TEMPERATURE:
                            curr.setTemperature(Integer.valueOf(reader.getText()));
                            break;
                        case LIGHT:
                            curr.setLight(reader.getText());
                            break;
                        case WATER:
                            curr.setWater(Integer.valueOf(reader.getText()));
                            break;
                    }
                    break;

                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("Flower")) {
                        flowers.add(curr);
                    }
                    currentEnum = null;

                    break;
            }
        }
        currentEnum = null;
    }

}
