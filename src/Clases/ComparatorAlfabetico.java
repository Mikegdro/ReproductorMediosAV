package Clases;

import java.util.Comparator;

public class ComparatorAlfabetico implements Comparator<Medio> {

    @Override
    public int compare(Medio o1, Medio o2) {
        return o1.getNombre().compareTo(o2.getNombre());
    }

    @Override
    public Comparator<Medio> reversed() {
        return Comparator.super.reversed(); 
    }
    
}
