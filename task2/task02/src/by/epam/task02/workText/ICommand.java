/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.workText;

import by.epam.task02.text.IComponent;

/**
 *
 * @author Dima
 */
public interface ICommand {
    IComponent execute(IComponent componentText);
}
