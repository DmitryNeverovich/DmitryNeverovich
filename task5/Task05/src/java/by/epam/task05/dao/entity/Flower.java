/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task05.dao.entity;

import java.util.Objects;

/**
 *
 * @author Dima
 */
public class Flower {
    private String id;
    private String family;
    private String name;
    private String hight;
    private String soil;
    private String origin;
    private String myltiplying;
    private String colorStalk;
    private String colorList;
    private int temperature;
    private String light;
    private int water;

    public void setId(String id) {
        this.id = id;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHight(String hight) {
        this.hight = hight;
    }

    public void setSoil(String soil) {
        this.soil = soil;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setMyltiplying(String myltiplying) {
        this.myltiplying = myltiplying;
    }

    public void setColorStalk(String colorStalk) {
        this.colorStalk = colorStalk;
    }

    public void setColorList(String colorList) {
        this.colorList = colorList;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public void setWater(int water) {
        this.water = water;
    }
        
    public String getId() {
        return id;
    }

    public String getFamily() {
        return family;
    }

    public String getName() {
        return name;
    }

    public String getHight() {
        return hight;
    }

    public String getSoil() {
        return soil;
    }

    public String getOrigin() {
        return origin;
    }

    public String getMyltiplying() {
        return myltiplying;
    }

    public String getColorStalk() {
        return colorStalk;
    }

    public String getColorList() {
        return colorList;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getLight() {
        return light;
    }

    public int getWater() {
        return water;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "id=" + id + ", family=" + family + ", name=" + name + ", hight=" + hight + ", soil=" + soil + ", origin=" + origin + ", myltiplying=" + myltiplying + ", colorStalk=" + colorStalk + ", colorList=" + colorList + ", temperature=" + temperature + ", light=" + light + ", water=" + water + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.family);
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.hight);
        hash = 29 * hash + Objects.hashCode(this.soil);
        hash = 29 * hash + Objects.hashCode(this.origin);
        hash = 29 * hash + Objects.hashCode(this.myltiplying);
        hash = 29 * hash + Objects.hashCode(this.colorStalk);
        hash = 29 * hash + Objects.hashCode(this.colorList);
        hash = 29 * hash + this.temperature;
        hash = 29 * hash + Objects.hashCode(this.light);
        hash = 29 * hash + this.water;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Flower other = (Flower) obj;
       if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.family, other.family)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.hight, other.hight)) {
            return false;
        }
        if (!Objects.equals(this.soil, other.soil)) {
            return false;
        }
        if (!Objects.equals(this.origin, other.origin)) {
            return false;
        }
        if (!Objects.equals(this.myltiplying, other.myltiplying)) {
            return false;
        }
        if (!Objects.equals(this.colorStalk, other.colorStalk)) {
            return false;
        }
        if (!Objects.equals(this.colorList, other.colorList)) {
            return false;
        }
        if (this.temperature != other.temperature) {
            return false;
        }
        if (!Objects.equals(this.light, other.light)) {
            return false;
        }
        if (this.water != other.water) {
            return false;
        }
        return true;
    }
    
}
