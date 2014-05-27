/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.sort;

import by.epam.task01.device.Device;
import java.util.Comparator;

/**
 *
 * @author Dima
 */
public class SortMaxToMin implements Comparator<Device>{

    @Override
    public int compare(Device t, Device t1) {
        if (t.getPower() < t1.getPower()) {
            return  1;
        }
        else if(t.getPower() == t1.getPower()){
            return 0;
        }else{
            return -1;
        }
    }
    
}
