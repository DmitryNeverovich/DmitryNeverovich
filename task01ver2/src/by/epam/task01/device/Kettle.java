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
public class Kettle extends Device{
    private String housingMaterial;

    public String getHousingMaterial() {
        return housingMaterial;
    }

    public void setHousingMaterial(String housingMaterial) {
        this.housingMaterial = housingMaterial;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nKettle{ " + "name = ").append(this.getName()).append(", manufacturer = ").append(this.getManufacturer()).append(", originCountry = ").append(this.getOriginCountry()).append(", model = ").append(this.getModel()).append(", power = ").append(this.getPower()).append(", voltage = ").append(this.getVoltage()).append(", currentFrequency = ").append(this.getCurrentFrequency()).append(", noiseLevelDb = ").append(this.getNoiseLevelDb()).append(", housingMaterial = ").append(this.housingMaterial).append('}');
        return str.toString();        
    }
    
}
