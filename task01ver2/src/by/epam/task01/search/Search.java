/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.search;

import by.epam.task01.device.Device;
import by.epam.task01.electricNetwork.ElectricNetwork;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dima
 */
public class Search {
    public static List<Device> searchRange(ElectricNetwork electricNetwork, int powerStart, int powerEnd){
        List<Device> devices = new ArrayList<Device>();
        if(powerEnd - powerStart >= 0){
            
            for (Device device : electricNetwork.getDevices()) {
                if (device.getPower() >= powerStart && device.getPower() <= powerEnd) {
                    devices.add(device);
                }
            }   
        }
        return devices;
    }
}
