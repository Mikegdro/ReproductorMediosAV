package Clases;

import Funciones.FuncionesMedio;
import java.io.File;
import java.io.Serializable;
import java.util.Map;
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

    public ListaMedios() {
        conjunto = new TreeSet<>();
    }

    public boolean añadirMedio(File archivo) {
        Medio aAñadir;
        
        boolean añadido = false;

        Map<Integer, String> tipoMedio = FuncionesMedio.tipoMedio(archivo);

        if (tipoMedio.containsKey(1)) {
            aAñadir = new Video(archivo, tipoMedio.get(1));
            aAñadir.calcularDuracion();
            añadido = conjunto.add(aAñadir);
        } else if (tipoMedio.containsKey(2)) {
            aAñadir = new Video(archivo, tipoMedio.get(1));
            añadido = conjunto.add(aAñadir);
        }

        return añadido;
    }

    public boolean eliminarMedio(Medio medio) {
        return conjunto.remove(medio);
    }

    public void ordenarAlReves() {
        NavigableSet copiaInvertida = conjunto.descendingSet();
        conjunto = new TreeSet<>(copiaInvertida);
    }

    public void ordenarDuracion() {
        TreeSet<Medio> copia = new TreeSet(new ComparatorDuracion());
        copia.addAll(conjunto);
        conjunto = new TreeSet<>(copia);
    }

    public void ordenarAlfabetico() {
        TreeSet<Medio> copia = new TreeSet(new ComparatorAlfabetico());
        copia.addAll(conjunto);
        conjunto = new TreeSet<>(copia);
    }

    @Override
    public String toString() {
        return "ListaMedios{" + "conjunto=" + conjunto + '}';
    }
    
    
}
