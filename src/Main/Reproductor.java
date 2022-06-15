package Main;

import Clases.ListaMedios;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Reproductor extends Application{
    
    /*
    Objetos JavaFX necesarios para la reproducción del video
    */
    private Media aReproducir;
    private MediaPlayer reproductor;
    private MediaView vistaReproductor;
    
    /*
    Objeto ListaMedios que cargaremos con los archivos manipulados recientemente
    */
    private ListaMedios recientes;
    
    @Override
    public void start(Stage stage) throws Exception {
        
    }
    
    public static void main(String[]args){
        launch(args);
    }
}
