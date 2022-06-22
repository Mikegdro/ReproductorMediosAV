package Main;

import Main.FXMLDocumentController;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Reproductor extends Application {

    /*
    Objetos JavaFX necesarios para la reproducción del video
     */
    private Media aReproducir;
    private MediaPlayer reproductor;
    private MediaView vistaReproductor;
    private MediosTableView table;
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();

        this.stage = stage;

        stage.setOnCloseRequest(event -> {
            handler(event);
        });

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    private void handler(WindowEvent event) {
        System.out.println("Se ha cerrado la ventana");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Cerrar Aplicación");
        alert.getButtonTypes().add(ButtonType.CANCEL);
        alert.setContentText(String.format("¿Cerrar sin Guardar?"));
        alert.initOwner(stage.getOwner());
        Optional<ButtonType> res = alert.showAndWait();

        if (res.isPresent()) {
            if (res.get().equals(ButtonType.CANCEL)) {
                event.consume();
            }
        }

    }

}
