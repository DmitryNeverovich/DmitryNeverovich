/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.task03.entity;

import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *
 * @author Dima
 */
public class Port {
    
    private Storehouse storehouse;
    private CopyOnWriteArrayList<Moorage> moorages;

    public Port(int numberMoorage) {
        storehouse = new Storehouse();
        moorages = new CopyOnWriteArrayList<Moorage>();
        for (int i = 0; i < numberMoorage; i++) {
            moorages.add(new Moorage(i));
        }   
    }
    
    public CopyOnWriteArrayList<Moorage> getListMoorages(){
        return moorages;
    }
    
    public Moorage getMoorage(int number){
        return moorages.get(number);
    }
    
    public boolean loadStorehouse(int conatiners){
        return storehouse.addContainers(conatiners);
    }
    
    public boolean unloadStorehouse(int conatiners){
        return storehouse.removeContainers(conatiners);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()+"{" + "storehouse=" + storehouse + ", moorages=" + moorages + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.storehouse);
        hash = 43 * hash + Objects.hashCode(this.moorages);
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
        final Port other = (Port) obj;
        if (!Objects.equals(this.storehouse, other.storehouse)) {
            return false;
        }
        if (!Objects.equals(this.moorages, other.moorages)) {
            return false;
        }
        return true;
    }
 
    
}
