package by.epam.task02.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


/**
 *
 * @author Dima
 */
public class Text implements IComponent{
    private List <IComponent> partText;

    
    public Text() {
        partText = new ArrayList<IComponent>();
    }
    @Override
    public void add(IComponent component) {
        partText.add(component);
    }
    
    @Override
    public void addAll(Collection<IComponent> components) {
        partText.addAll(components);
    }

    @Override
    public void remove(int index) {
        partText.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.partText);
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
        final Text other = (Text) obj;
        if (!Objects.equals(this.partText, other.partText)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getClass()+"{" + "sentence=" + partText + '}';
    }

    @Override
    public String getContent() {
         StringBuilder str = new StringBuilder();
        for(IComponent component: partText){
            str.append(component.getContent());
        }
        return str.toString();
    }
    @Override
    public Iterator<IComponent> getIterator() {
        return partText.iterator(); 
    }
}
