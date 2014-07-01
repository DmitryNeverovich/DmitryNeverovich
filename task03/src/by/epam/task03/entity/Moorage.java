/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import java.util.Objects;

/**
 *
 * @author Dima
 */
public class Moorage {
     
    private Ship moorShip;
    private int numberMoorage;

    public Moorage(int numberMoorage) {
        this.numberMoorage = numberMoorage;
    }
    
    public boolean isEmpty(){
        boolean moorageEmpty = false;
        if (moorShip == null) {
            moorageEmpty = true;
        }
        return moorageEmpty;
    }
    
    public boolean moorShip(Ship ship){
        boolean complete = false;
        if(this.moorShip == null){
            this.moorShip = ship;
            complete = true;
        }
        return complete;
    }
    
    public boolean unmoorShip(){
        
        boolean complete = false;
        if(this.moorShip != null){
            this.moorShip = null;
            complete = true;
        }
        return complete;
    }

    public Ship getMoorShip() {
        return moorShip;
    }

    public int getNumberMoorage() {
        return numberMoorage;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "moorShip=" + moorShip + ", numberMoorage=" + numberMoorage + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.moorShip);
        hash = 67 * hash + this.numberMoorage;
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
        final Moorage other = (Moorage) obj;
        if (!Objects.equals(this.moorShip, other.moorShip)) {
            return false;
        }
        if (this.numberMoorage != other.numberMoorage) {
            return false;
        }
        return true;
    }
    
    
}
