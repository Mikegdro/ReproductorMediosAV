package Clases;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;
import javafx.concurrent.Task;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/**
 * Clase abstracta que guardará la información de un Medio AudioVisual concreto
 * que más tarde se usará para su reproducción. De ella Heredan por ahora dos
 * clases, Video y Cancion, estas extienden la clase Medio, implementando
 * métodos y funciones concretas para ese tipo de Medios AudioVisuales.
 */
public abstract class Medio implements Comparable {

    //Nombre del Archivo
    private File archivo;
    //Double con la duración en MINUTOS
    private double duracion;
    //Fecha Modificacion
    private Calendar reciente;

    public Medio(File archivo) {
        if (!archivo.exists()) {
            throw new IllegalArgumentException("El archivo proporcionado no existe");
        }

        this.archivo = archivo;
        reciente = new GregorianCalendar();
    }

    public String getNombre() {
        return archivo.getName();
    }

    public String getRuta() throws MalformedURLException {
        return archivo.toURI().toURL().toString();
    }

    public double getDuracion() {
        return duracion;
    }

    public void calcularDuracion() {
        try{
            Media media = new Media(getRuta());
            MediaPlayer player = new MediaPlayer(media);
            player.setOnReady(() -> {
                System.out.println("holi");
                setDuracion(player.getTotalDuration().toSeconds());
            });
            new Thread(new Runnable(){
                @Override
                public void run(){
                    while(player.getStatus() == Status.UNKNOWN){
                        System.out.println(player.getStatus());
                    }
                }
            }).start();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    
    public void setDuracion(double duracion){
        this.duracion = duracion;

    }

    public Calendar getReciente() {
        return reciente;
    }

    public void actualizarFecha() {
        this.reciente = new GregorianCalendar();
    }

    /**
     * CompareTo que usa los compareTo respectivos de la clase calendar,
     * estableciendo así el orden de ordenación natural en la fecha de creación/
     * modificación.
     *
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        return this.reciente.compareTo(((Medio) o).getReciente());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.archivo);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.duracion) ^ (Double.doubleToLongBits(this.duracion) >>> 32));
        hash = 89 * hash + Objects.hashCode(this.reciente);
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
        if (!Objects.equals(this.archivo, other.archivo)) {
            return false;
        }
        return Objects.equals(this.reciente, other.reciente);
    }

    @Override
    public String toString() {
        return "Medio{" + "archivo=" + archivo.getName() + ", duracion=" + duracion + ", reciente=" + reciente + '}';
    }
    
    
}
