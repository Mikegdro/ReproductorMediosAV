
package Main;

import Clases.ComparatorAlfabetico;
import Clases.Medio;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.converter.DoubleStringConverter;

public class MediosTableView extends AnchorPane {
    
    private TableView<Medio> tabla;
    private TableColumn<Medio, String> columnaNombre;
    private TableColumn<Medio, Double> columnaDuracion;
    private TableColumn<Medio, String> columnaRuta;
    
    public MediosTableView(){
        BuildUI();
    }
    
    private void BuildUI(){
        tabla = new TableView<>();
        
        tabla.setEditable(true);
        tabla.setId("tabla");
        
        columnaNombre = new TableColumn("Nombre");
        columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaNombre.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaNombre.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Medio, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Medio, String> event) {
                Medio medio = event.getRowValue();
                medio.setNombre(event.getNewValue());
            }
        });
        columnaNombre.setPrefWidth(150);
        

        columnaDuracion = new TableColumn("Duracion");
        columnaDuracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));
        columnaDuracion.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        columnaDuracion.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Medio, Double>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Medio, Double> event) {
                Medio medio = event.getRowValue();
                medio.setDuracion(event.getNewValue());
            }
        });
        columnaDuracion.setPrefWidth(150);

        columnaRuta = new TableColumn("Ruta");
        columnaRuta.setCellValueFactory(new PropertyValueFactory<>("ruta"));
        columnaRuta.setCellFactory(TextFieldTableCell.forTableColumn());
        columnaRuta.setEditable(false);
        columnaRuta.setPrefWidth(150);

        tabla.getColumns().add(columnaNombre);
        tabla.getColumns().add(columnaDuracion);
        tabla.getColumns().add(columnaRuta);
        
        tabla.setPrefHeight(360);
        tabla.setPrefWidth(467);
        
        getChildren().add(tabla);
    }
    
    public boolean add(Medio e){
        return tabla.getItems().add(e);
    }
    
    public int getSelection(){
        int seleccion = -1;
        
        if(tabla.getSelectionModel().getSelectedIndex() != -1){
            seleccion = tabla.getSelectionModel().getSelectedIndex();
        }
        
        return seleccion;
    }
    
    public boolean removeSelection(int indice){
        boolean isRemoved = false;
                
        if(indice != -1){
            tabla.getItems().remove(indice);
            isRemoved = true;
        }
        
        return isRemoved;
    }
}
