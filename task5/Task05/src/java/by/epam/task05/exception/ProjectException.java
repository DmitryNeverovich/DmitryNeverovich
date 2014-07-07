/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.exception;

/**
 *
 * @author Dima
 */
public class ProjectException extends Exception{
    private static final long serialVersonUID = 1L;
    private Exception hiddenException;

    public ProjectException(String msg) {
        super(msg);
    }
    
    public ProjectException(String msg, Exception e) {
        super(msg);
        hiddenException = e;
    }

    public Exception getHiddenException() {
        return hiddenException;
    }
    
}
