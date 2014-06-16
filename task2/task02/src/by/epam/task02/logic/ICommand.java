/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.logic;

import by.epam.task02.entity.IComponent;

/**
 *
 * @author Dima
 */
public interface ICommand {
    IComponent execute(IComponent componentText);
}
