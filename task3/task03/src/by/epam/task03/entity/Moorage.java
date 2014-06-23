/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

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
    
}
