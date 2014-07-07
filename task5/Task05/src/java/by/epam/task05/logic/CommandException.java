/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.logic;

import by.epam.task05.exception.ProjectException;

/**
 *
 * @author Dima
 */
public class CommandException extends ProjectException{
    
    private static final long serialVersionUID = 1L;
    public CommandException(String msg) {
        super(msg);
    }
    public CommandException(String msg,Exception e){
        super(msg,e);
    }
    
}
