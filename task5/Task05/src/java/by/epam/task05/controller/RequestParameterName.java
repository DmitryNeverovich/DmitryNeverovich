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
public enum RequestParameterName {

    COMMAND_NAME("command"),
    FLOWERS_INFO("flowers"),
    FILE_NAME("filename");
    
    private String parameter;
    
    RequestParameterName(String parameter){
        this.parameter = parameter;
    }
    
    public String getParameter(){
        return parameter;
    }
}
