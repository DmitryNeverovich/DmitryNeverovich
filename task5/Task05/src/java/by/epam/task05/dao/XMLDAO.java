/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao;

import by.epam.task05.dao.entity.Flower;
import java.util.List;

/**
 *
 * @author Dima
 */
public interface XMLDAO {
    List<Flower> parse(String resourceName)throws XMLDAOException;
}

