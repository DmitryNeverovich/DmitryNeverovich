/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.controller;

import by.epam.task05.logic.CommandException;
import by.epam.task05.logic.CommandHelper;
import by.epam.task05.logic.ICommand;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 *
 * @author Dima
 */
public class Controller extends HttpServlet{
    
    private final static Logger logger = Logger.getLogger(Controller.class);
    private static final long serialVersionUID = 1;

    public Controller() {
        super();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String commandName = req.getParameter(RequestParameterName.COMMAND_NAME.getParameter());
        ICommand command = CommandHelper.getInstance().getCommand(commandName);
        String page = null;
        try {
            page = command.execute(req);
        } catch (CommandException e) {
            logger.warn(" CommandException");
            page = JspPageName.ERROR_PAGE.getPath();
        } catch (Exception e) {
            logger.warn("Exception");
            page = JspPageName.ERROR_PAGE.getPath();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(req, resp);
        } else {
            errorMessageDireclyFromResponce(resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
    private void errorMessageDireclyFromResponce(HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        response.getWriter().println("E R R O R");
    }
}
