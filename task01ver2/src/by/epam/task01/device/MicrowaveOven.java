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
public class MicrowaveOven extends Device{
    private boolean grill;
    private int numberCookingProgram;

    public boolean isGrill() {
        return grill;
    }

    public int getNumberCookingProgram() {
        return numberCookingProgram;
    }

    public void setGrill(boolean grill) {
        this.grill = grill;
    }

    public void setNumberCookingProgram(int numberCookingProgram) {
        this.numberCookingProgram = numberCookingProgram;
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("\nMicrowaveOven{ " + "name = ").append(this.getName()).append(", manufacturer = ").append(this.getManufacturer()).append(", originCountry = ").append(this.getOriginCountry()).append(", model = ").append(this.getModel()).append(", power = ").append(this.getPower()).append(", voltage = ").append(this.getVoltage()).append(", currentFrequency = ").append(this.getCurrentFrequency()).append(", noiseLevelDb = ").append(this.getNoiseLevelDb()).append(", grill = ").append(this.grill).append(", numberCookingProgram = ").append(this.numberCookingProgram).append('}');
        return str.toString();        
    }
}
