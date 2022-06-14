package Funciones;

import java.io.File;
import javafx.scene.media.Media;
import javafx.util.Duration;

public class Funciones {

    private double obtenerDuracion(File archivo) {
        double duracion = -1;

        try {
            Media video = new Media(archivo.toURI().toURL().toString());
            Duration durObj = video.getDuration();
            duracion = durObj.toMinutes();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return duracion;
    }
}
