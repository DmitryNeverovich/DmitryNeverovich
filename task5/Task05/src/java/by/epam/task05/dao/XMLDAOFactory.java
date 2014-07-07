/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task05.dao;

import by.epam.task05.dao.impl.dom.DOMXmlDao;
import by.epam.task05.dao.impl.sax.SaxXmlDao;
import by.epam.task05.dao.impl.stax.StaXXmlDao;

/**
 *
 * @author Dima
 */
public class XMLDAOFactory {

    private final static XMLDAOFactory instance = new XMLDAOFactory();

    public static XMLDAOFactory getInstance() {
        return instance;
    }

    public XMLDAO getDAO(DAOType type) throws XMLDAOException {
        switch (type) {
            case SAX:
                return SaxXmlDao.getInstance();

            case STAX:
                return StaXXmlDao.getInstance();

            case DOM:
                return DOMXmlDao.getInstance();

            default:
                throw new XMLDAOException("No such DAO");
        }
    }

    public enum DAOType {

        SAX, STAX, DOM;
    }

}
