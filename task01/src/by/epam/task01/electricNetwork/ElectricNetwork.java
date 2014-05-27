/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.electricNetwork;

import by.epam.task01.device.Device;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dima
 */
public class ElectricNetwork {
    private List<Device> devices;

    public ElectricNetwork() {
        devices = new ArrayList<Device>();
    }
    
    public void connectElectricNetwork(Device device){
        devices.add(device);
    }
    public void unplugElectricNetwork(Device device){
        devices.remove(device);
    }

    public List<Device> getDevices() {
        return devices;
    }
    
    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public String toString() {
        return "ElectricNetwork{" + "devices=" + devices + '}';
    }
    
}
