/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.builder;

import by.epam.task01.device.Device;
import by.epam.task01.device.Fridge;
import by.epam.task01.device.Kettle;
import by.epam.task01.device.MicrowaveOven;
import by.epam.task01.electricNetwork.ElectricNetwork;

/**
 *
 * @author Dima
 */
public class Builder {
    private ElectricNetwork electricNetwork;

    public Builder() {
        electricNetwork  = new ElectricNetwork();
    }      
    
    public void addDevice(Device device){
        electricNetwork.connectElectricNetwork(device);
    }
    public void addFredge(String name,
            String manufacturer,
            String originCountry,
            int model,
            int power,
            int voltage,
            int currentFrequency,
            double noiseLevelDb,
            int freezerValue){
        
        Fridge fridge = new Fridge();
        fridge.setCurrentFrequency(currentFrequency);
        fridge.setManufacturer(manufacturer);
        fridge.setModel(model);
        fridge.setName(name);
        fridge.setNoiseLevelDb(noiseLevelDb);
        fridge.setOriginCountry(originCountry);
        fridge.setPower(power);
        fridge.setVoltage(voltage);
        fridge.setFreezerValue(freezerValue);
        electricNetwork.connectElectricNetwork(fridge);
    }
    
    public void addKettle(String name,
                    String manufacturer,
                    String originCountry,
                    int model,
                    int power,
                    int voltage,
                    int currentFrequency,
                    double noiseLevelDb,
                    String housingMaterial){
        
        Kettle kettle = new Kettle();
        kettle.setCurrentFrequency(currentFrequency);
        kettle.setManufacturer(manufacturer);
        kettle.setModel(model);
        kettle.setName(name);
        kettle.setNoiseLevelDb(noiseLevelDb);
        kettle.setOriginCountry(originCountry);
        kettle.setPower(power);
        kettle.setVoltage(voltage);
        kettle.setHousingMaterial(housingMaterial);
        electricNetwork.connectElectricNetwork(kettle);
    }
    
     public void addMicrowaveOven(String name,
                    String manufacturer,
                    String originCountry,
                    int model,
                    int power,
                    int voltage,
                    int currentFrequency,
                    double noiseLevelDb, 
                    boolean grill, 
                    int numberCookingProgram){
        
        MicrowaveOven microwaveOven = new MicrowaveOven();
        microwaveOven.setCurrentFrequency(currentFrequency);
        microwaveOven.setManufacturer(manufacturer);
        microwaveOven.setModel(model);
        microwaveOven.setName(name);
        microwaveOven.setNoiseLevelDb(noiseLevelDb);
        microwaveOven.setOriginCountry(originCountry);
        microwaveOven.setPower(power);
        microwaveOven.setVoltage(voltage);
        microwaveOven.setGrill(grill);
        microwaveOven.setVoltage(voltage);
        microwaveOven.setNumberCookingProgram(numberCookingProgram);
        electricNetwork.connectElectricNetwork(microwaveOven);
    }
            
    public ElectricNetwork createElectricNetwork (){
        return electricNetwork;
    }
}
