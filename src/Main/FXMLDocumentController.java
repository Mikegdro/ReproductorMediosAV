/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clases.ListaMedios;
import Funciones.Archivos;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    private MediosTableView tablaNueva;
    
    @FXML
    public ScrollPane SPEditable;
    public BorderPane bpTabla;
    public VBox root;
    public Stage stage;

    private ArrayList<ListaMedios> recientes;
    
    private ListaMedios listaActual;

    @FXML
    private void botonAdd(ActionEvent event) {
        FileChooser selector = new FileChooser();
        File archivo = selector.showOpenDialog(null);
        if (archivo != null) {
            listaActual.añadirMedio(archivo);
            tablaNueva.add(listaActual.getLast());
        } else {
            System.out.println("No ha proporcionado un archivo correcto");
        }
    }

    @FXML
    private void botonEliminar(ActionEvent event) {
        int seleccion = tablaNueva.getSelection();
        
        if(seleccion != -1){
            tablaNueva.removeSelection(seleccion);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recientes = cargarDatosRecientes();
        if(recientes == null){
            recientes = new ArrayList<>();
        }
        
        listaActual = new ListaMedios();
        
        tablaNueva = new MediosTableView();
        
        bpTabla = new BorderPane();
        bpTabla.setPrefWidth(450);
        bpTabla.setPrefHeight(350);
        
        bpTabla.setCenter(tablaNueva);
        
        SPEditable.setContent(bpTabla);
        
        
    }

    private ArrayList<ListaMedios> cargarDatosRecientes() {
        String archivo = "recientes.dat";
        return Archivos.leerObjetoBinario(archivo);
    }

    public void guardarDatosRecientes(){
        String archivo = "recientes.dat";
        Archivos.guardarObjectoBinario(recientes, archivo);
    }
}
