/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.controller;

/**
 *
 * @author Dima
 */
public enum JspPageName {

    
    USER_PAGE("jsp/userPage.jsp"),
    ERROR_PAGE("jsp/error.jsp");
    
    private String path;
    
    JspPageName(String path) {
        this.path = path;
    }
    public String getPath(){
        return path;
    }
}
