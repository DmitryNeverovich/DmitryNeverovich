/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.logic;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Dima
 */
public interface ICommand {
    public String execute(HttpServletRequest request)throws CommandException;
}
