package Clases;

import java.util.Comparator;

public class ComparatorDuracion implements Comparator<Medio> {

    @Override
    public int compare(Medio o1, Medio o2) {
        return (int)(o1.getDuracion() - o2.getDuracion());
    }

    @Override
    public Comparator<Medio> reversed() {
        return Comparator.super.reversed();
    }
    
}
