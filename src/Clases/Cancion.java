
package Clases;

import Clases.Formatos.FormatosCancion;

/**
 * Sub-clase de Medio, llama a super() creando un objeto medio, y comprueba
 * el formato pasado por parámetro, en caso de ser soportado por el programa,
 * se creara el objeto, en caso contrario lanzará un IllegalArgumentException.
 * <p>
 *   <h3> Formatos permitidos a dia 14/06/2022 </h3>
 *   <ul>
 *       <li>MP3</li>
 *       <li>AIFF</li>
 *       <li>WAV</li>
 *   </ul>
 * </p>
 */

public class Cancion extends Medio {
    
    private String formato;
    
    public Cancion(String nombre, String ruta, double duracion, String formato){
        super(nombre, ruta, duracion);
        FormatosCancion [] formatos = FormatosCancion.values();
        
        boolean permitido = false;
        
        for(FormatosCancion c: formatos){
            if(c.toString().equals(formato)){
               permitido = true; 
            }
        }
        
        if(!permitido){
            throw new IllegalArgumentException("El formato introducido no es válido");
        }
        
        this.formato = formato;
    }
    
}
