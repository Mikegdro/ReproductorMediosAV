
package Clases;

import java.io.Serializable;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * ListaMedios es una clase que implementará una serie de listas que guardarán
 * la clase Medio. Se usarán para mostrar todos los videos/canciones del
 * usuario, y se podrá guardar tanto en formato texto como en binario o incluso
 * por medio de Persistencia.
 * 
 */
public class ListaMedios implements Serializable {
    private TreeSet<Medio> conjunto;
    
    public ListaMedios(){
        conjunto = new TreeSet<>();
    }
    
    public boolean añadirMedio(Medio medio){
        return conjunto.add(medio);
    }
    
    public boolean eliminarMedio(Medio medio){
        return conjunto.remove(medio);
    }

    public void ordenarAlReves(){
        NavigableSet nuevo = conjunto.descendingSet();
        conjunto = new TreeSet<>(nuevo);
    }
    
    public void ordenarDuracion(){
        TreeSet<Medio> copia = new TreeSet(new ComparatorDuracion());
        copia.addAll(conjunto);
        conjunto = new TreeSet<>(copia);
    }
    
    public void ordenarAlfabetico(){
        TreeSet<Medio> copia = new TreeSet(new ComparatorAlfabetico());
        copia.addAll(conjunto);
        conjunto = new TreeSet<>(copia);
    }
}
