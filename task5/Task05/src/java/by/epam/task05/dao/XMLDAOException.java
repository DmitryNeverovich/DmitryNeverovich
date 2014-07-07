/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao;

import by.epam.task05.exception.ProjectException;

/**
 *
 * @author Dima
 */
public class XMLDAOException extends ProjectException{
        private static final long serialVersionID = 1L;

    public XMLDAOException(String msg) {
        super(msg);
    }
    public XMLDAOException(String msg, Exception e) {
        super(msg,e);
    }
}
