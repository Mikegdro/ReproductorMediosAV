package Main;

import Clases.ListaMedios;
import Clases.Medio;
import Clases.Video;
import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import Funciones.FuncionesMedio;
import java.util.Map;

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
    static ListaMedios recientes;
    
    @Override
    public void start(Stage stage) throws Exception {
        recientes = new ListaMedios();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
    public static void main(String[]args){
        launch(args);
    }
}
