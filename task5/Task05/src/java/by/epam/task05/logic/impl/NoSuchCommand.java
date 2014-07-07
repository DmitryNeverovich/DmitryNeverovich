/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.logic.impl;

import by.epam.task05.controller.JspPageName;
import by.epam.task05.logic.CommandException;
import by.epam.task05.logic.ICommand;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dima
 */
public class NoSuchCommand implements ICommand{

    @Override
    public String execute(HttpServletRequest request)throws CommandException{
        return JspPageName.ERROR_PAGE.getPath();
    }
    
}
