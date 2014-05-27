/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task01.device;

/**
 *
 * @author Dima
 */
public class Fridge extends Device {
    private int freezerValue;

    public int getFreezerValue() {
        return freezerValue;
    }

    public void setFreezerValue(int freezerValue) {
        this.freezerValue = freezerValue;
    }  

@Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nFridge{ " + "name = ").append(this.getName()).append(", manufacturer = ").append(this.getManufacturer()).append(", originCountry = ").append(this.getOriginCountry()).append(", model = ").append(this.getModel()).append(", power = ").append(this.getPower()).append(", voltage = ").append(this.getVoltage()).append(", currentFrequency = ").append(this.getCurrentFrequency()).append(", noiseLevelDb = ").append(this.getNoiseLevelDb()).append(", freezerValue = ").append(this.freezerValue).append('}');
        return str.toString();
    }
    
}
