/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 *
 * @author jjber
 */
public class FXMLDocumentController implements Initializable {
    
    boolean haPulsadoAdd;
    
    @FXML
    private void botonAdd(ActionEvent event) {
        FileChooser selector = new FileChooser();
        File archivo = selector.showOpenDialog(null);
        if(archivo != null){
            Reproductor.recientes.añadirMedio(archivo);
        }else{
            System.out.println("No ha proporcionado un archivo correcto");
        }
    }
    
    @FXML
    private void botonEliminar(ActionEvent event){
        System.out.println(Reproductor.recientes.toString());
        
    }
    
    @FXML
    private void botonListas(ActionEvent event){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
