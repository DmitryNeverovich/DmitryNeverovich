/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task02.text;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Dima
 */
public class PartSentence extends IComponent{
    private String partSentence;

    public PartSentence(String partSentence) {
        this.partSentence = partSentence;
    }
    
    public String getPartSentence() {
        return partSentence;
    }

    public void setPartSentence(String partSentence) {
        this.partSentence = partSentence;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.partSentence);
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
        final PartSentence other = (PartSentence) obj;
        if (!Objects.equals(this.partSentence, other.partSentence)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PartSentence{" + "partSentence =" + partSentence + '}';
    }

    @Override
    public String getContent() {
        return partSentence+" ";
    }
        
}
