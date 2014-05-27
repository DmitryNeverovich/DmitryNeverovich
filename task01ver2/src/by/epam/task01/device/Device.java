/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task01.device;

import java.util.Objects;

/**
 *
 * @author Dima
 */
public abstract class Device {
    private String name;
    private String manufacturer;
    private String originCountry;
    private int model;
    private int power;
    private int voltage;
    private int currentFrequency;
    private double noiseLevelDb;

    public void setNoiseLevelDb(int noiseLevelDb) {
        this.noiseLevelDb = noiseLevelDb;
    }

    public double getNoiseLevelDb() {
        return noiseLevelDb;
    }

    public void setNoiseLevelDb(double noiseLevelDb) {
        this.noiseLevelDb = noiseLevelDb;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public void setModel(int model) {
        this.model = model;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public void setCurrentFrequency(int currentFrequency) {
        this.currentFrequency = currentFrequency;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public int getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getVoltage() {
        return voltage;
    }

    public int getCurrentFrequency() {
        return currentFrequency;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Device other = (Device) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.manufacturer, other.manufacturer)) {
            return false;
        }
        if (!Objects.equals(this.originCountry, other.originCountry)) {
            return false;
        }
        if (this.model != other.model) {
            return false;
        }
        if (this.power != other.power) {
            return false;
        }
        if (this.voltage != other.voltage) {
            return false;
        }
        if (this.currentFrequency != other.currentFrequency) {
            return false;
        }
        if (Double.doubleToLongBits(this.noiseLevelDb) != Double.doubleToLongBits(other.noiseLevelDb)) {
            return false;
        }
        return true;
    }
       
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.manufacturer);
        hash = 83 * hash + Objects.hashCode(this.originCountry);
        hash = 83 * hash + this.model;
        hash = 83 * hash + this.power;
        hash = 83 * hash + this.voltage;
        hash = 83 * hash + this.currentFrequency;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.noiseLevelDb) ^ (Double.doubleToLongBits(this.noiseLevelDb) >>> 32));
        return hash;
    }
      
}
