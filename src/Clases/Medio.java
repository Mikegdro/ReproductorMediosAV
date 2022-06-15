
package Clases;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

/**
 * Clase abstracta que guardará la información de un Medio AudioVisual concreto
 * que más tarde se usará para su reproducción. De ella Heredan por ahora 
 * dos clases, Video y Cancion, estas extienden la clase Medio, implementando
 * métodos y funciones concretas para ese tipo de Medios AudioVisuales.
 */
public abstract class Medio implements Comparable {
    //Nombre del Archivo
    private String nombre;
    //String con la ruta ABSOLUTA del archivo
    private String ruta;
    //Double con la duración en MINUTOS
    private double duracion;
    //Fecha Modificacion
    private Calendar reciente;
    
    public Medio(String nombre, String ruta, double duracion){
        if(nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        if(ruta.isBlank()){
            throw new IllegalArgumentException("La ruta no puede estar vacía");
        }
        if(duracion <= 0){
            throw new IllegalArgumentException("La ruta no puede estar vacía");
        }
        
        this.nombre = nombre;
        this.ruta = ruta;
        this.duracion = duracion;
        reciente = new GregorianCalendar();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    public Calendar getReciente(){
        return reciente;
    }
    
    public void actualizarFecha(){
        this.reciente= new GregorianCalendar();
    }

    /**
     * CompareTo que usa los compareTo respectivos de la clase calendar, 
     * estableciendo así el orden de ordenación natural en la fecha de creación/
     * modificación.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Object o) {
        return this.reciente.compareTo(((Medio)o).getReciente());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.nombre);
        hash = 47 * hash + Objects.hashCode(this.ruta);
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.duracion) ^ (Double.doubleToLongBits(this.duracion) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Medio other = (Medio) obj;
        if (Double.doubleToLongBits(this.duracion) != Double.doubleToLongBits(other.duracion)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return Objects.equals(this.ruta, other.ruta);
    }
    
    
}


