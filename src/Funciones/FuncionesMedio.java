package Funciones;

import Clases.Formatos.FormatosCancion;
import Clases.Formatos.FormatosVideo;
import java.io.File;
import javafx.scene.media.Media;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FuncionesMedio {

    public static double obtenerDuracion(File archivo) {
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
    /**
     * Determina si es un Video(1) o una Cancion(2) por medio de un map que
     * también contiene el Formato.
     * @param archivo
     * @return 
     */
    public static Map<Integer, String> tipoMedio(File archivo){
        Map<Integer, String> aDevolver = new HashMap<>();

        FormatosVideo[] formsVid = FormatosVideo.values();
        FormatosCancion[] formsSong = FormatosCancion.values();
        
        String ruta = archivo.getAbsolutePath();
        String formatoArchivo = ruta.substring(ruta.indexOf("."));
            
        ArrayList<String> listaForms = new ArrayList<>();
        
        for(FormatosVideo c: formsVid){
            listaForms.add(c.toString());
        }
        
        if(!listaForms.contains(formatoArchivo)){
            listaForms.clear();
            for(FormatosCancion c: formsSong){
                listaForms.add(c.toString());
            }
            
            if(listaForms.contains(formatoArchivo)){
                aDevolver.put(2, formatoArchivo);
            }
        }else{
            aDevolver.put(1, formatoArchivo);
        }
        
        
        return aDevolver;
    }
}
