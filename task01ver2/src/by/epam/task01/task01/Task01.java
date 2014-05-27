/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.task01;

import by.epam.task01.builder.Builder;
import by.epam.task01.device.Device;
import by.epam.task01.electricNetwork.ElectricNetwork;
import by.epam.task01.search.Search;
import java.util.Collections;
import by.epam.task01.sort.SortMaxToMin;
import java.util.List;


/**
 *
 * @author Dima
 */
public class Task01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Builder builder = new Builder();
        
        builder.addFredge("XM", "LG", "Malaysia", 310, 3000, 220, 50, 12, 300);
        builder.addKettle("RX", "Maxwell", "China", 300, 900, 220, 50, 15, "Plastic");
        builder.addMicrowaveOven("RX", "Maxwell", "China", 3600, 2000, 220, 50, 10, true, 12);
        
        ElectricNetwork electricNetwork = builder.createElectricNetwork();
        
        System.out.println(electricNetwork);
        
//        Collections.sort(electricNetwork.getDevices(),new SortMinToMax());
        Collections.sort(electricNetwork.getDevices(),new SortMaxToMin());
        System.out.println("-------------------------");
        System.out.println(electricNetwork);
        System.out.println("-------------------------");
        List<Device> devices = Search.searchRange(electricNetwork, 200, 900);
        
         System.out.println(devices);
    }
    
}
