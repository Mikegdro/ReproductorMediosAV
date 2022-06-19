package Main;

import Clases.ListaMedios;
import Clases.Medio;
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
    private ListaMedios recientes;
    
    @Override
    public void start(Stage stage) throws Exception {
        recientes = new ListaMedios();
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[]args){
        launch(args);
    }
    
    public boolean addMedio(String ruta){
        boolean added = false;
        
        File archivo = new File(ruta);
        
        Map<Integer, String> tipoMedio = FuncionesMedio.tipoMedio(archivo);
        
        if(tipoMedio.containsKey(1)){
            
        }else if(tipoMedio.containsKey(2)){
            
        }
        
        return added;
    }
}
