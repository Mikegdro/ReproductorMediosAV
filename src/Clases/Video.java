package Clases;

import Clases.Formatos.FormatosVideo;

/**
 * Sub-clase de Medio, llama a super() creando un objeto medio, y comprueba
 * el formato pasado por parámetro, en caso de ser soportado por el programa,
 * se creara el objeto, en caso contrario lanzará un IllegalArgumentException.
 * <p>
 *   <h3> Formatos permitidos a dia 14/06/2022 </h3>
 *   <ul>
 *       <li>MP4</li>
 *       <li>FLV</li>
 *   </ul>
 * </p>
 */
public class Video extends Medio {

    private String formato;

    public Video(String nombre, String ruta, double duracion, String formato) {
        super(nombre, ruta, duracion);
        FormatosVideo [] formatos = FormatosVideo.values();
        
        boolean permitido = false;
        
        for(FormatosVideo c: formatos){
            if(c.toString().equals(formato)){
               permitido = true; 
            }
        }
        
        if(!permitido){
            throw new IllegalArgumentException("El formato introducido no es válido");
        }
        
        this.formato = formato;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

}
