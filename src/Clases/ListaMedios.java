
package Clases;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * ListaMedios es una clase que implementará una serie de listas que guardarán
 * la clase Medio. Se usarán para mostrar todos los videos/canciones del
 * usuario, y se podrá guardar tanto en formato texto como en binario o incluso
 * por medio de Persistencia.
 * 
 */
public class ListaMedios implements Serializable {
    private Set<Medio> conjunto;
    
    public ListaMedios(){
        conjunto = new HashSet<>();
    }
    
    public boolean añadirMedio(Medio medio){
        return conjunto.add(medio);
    }
    
    public boolean eleminarMedio(Medio medio){
        return conjunto.remove(medio);
    }

    public void ordenarAlReves(){
        
    }
}
