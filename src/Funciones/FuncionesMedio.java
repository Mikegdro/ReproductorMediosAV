package Funciones;

import Clases.Formatos.FormatosCancion;
import Clases.Formatos.FormatosVideo;
import java.io.File;
import java.net.MalformedURLException;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.function.Function;
import javafx.scene.media.MediaPlayer.Status;
import static javafx.scene.media.MediaPlayer.Status.READY;

public class FuncionesMedio {

    /**
     * Determina si es un Video(1) o una Cancion(2) por medio de un map que
     * también contiene el Formato.
     *
     * @param archivo
     * @return
     */
    public static Map<Integer, String> tipoMedio(File archivo) {
        Map<Integer, String> aDevolver = new HashMap<>();

        FormatosVideo[] formsVid = FormatosVideo.values();
        FormatosCancion[] formsSong = FormatosCancion.values();

        String ruta = archivo.getAbsolutePath();
        String formatoArchivo = ruta.substring(ruta.indexOf(".") + 1);

        ArrayList<String> listaForms = new ArrayList<>();

        for (FormatosVideo c : formsVid) {
            listaForms.add(c.toString().toLowerCase());
        }

        if (!listaForms.contains(formatoArchivo)) {
            listaForms.clear();
            for (FormatosCancion c : formsSong) {
                listaForms.add(c.toString().toLowerCase());
            }

            if (listaForms.contains(formatoArchivo)) {
                aDevolver.put(2, formatoArchivo);
            }
        } else {
            aDevolver.put(1, formatoArchivo);
        }

        return aDevolver;
    }
}
