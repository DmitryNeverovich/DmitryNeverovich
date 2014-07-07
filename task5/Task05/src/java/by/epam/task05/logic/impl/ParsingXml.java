/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.logic.impl;

import by.epam.task05.controller.JspPageName;
import by.epam.task05.controller.RequestParameterName;
import by.epam.task05.dao.XMLDAO;
import by.epam.task05.dao.XMLDAOException;
import by.epam.task05.dao.XMLDAOFactory;
import by.epam.task05.dao.XMLDAOFactory.DAOType;
import by.epam.task05.dao.entity.Flower;
import by.epam.task05.logic.CommandException;
import by.epam.task05.logic.ICommand;
import java.util.List;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dima
 */
public class ParsingXml implements ICommand{

    private final static Logger logger = Logger.getLogger(ParsingXml.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
       String page = null;
        try {
            DAOType typeParser = XMLDAOFactory.DAOType.valueOf(request.getParameter("parser").toUpperCase());
            XMLDAO dao = XMLDAOFactory.getInstance().getDAO(typeParser);       
            List<Flower> info = dao.parse(request.getParameter(RequestParameterName.FILE_NAME.getParameter()));
            request.setAttribute(RequestParameterName.FLOWERS_INFO.getParameter(), info);
            page = JspPageName.USER_PAGE.getPath();
        } catch (XMLDAOException e) {
            logger.warn("XMLDAOException");
            throw new CommandException("XMLDAOException",e);
        }
        return page;
    }
    
}
