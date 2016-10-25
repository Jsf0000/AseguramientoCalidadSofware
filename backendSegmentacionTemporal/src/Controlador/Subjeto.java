/*
 * 
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Subjeto.
 */
public class Subjeto {
	 
 	/** The observadores. */
 	ArrayList<Observador> observadores = new ArrayList<>();
	 
	  /** The dto. */
  	private Dto dto;
	    
	    /**
    	 * Gets the dto.
    	 *
    	 * @return the dto
    	 */
    	public Dto getDto(){
	        return dto;
	    }
	    
	    /**
    	 * Sets the dto.
    	 *
    	 * @param pdto the new dto
    	 * @throws FileNotFoundException the file not found exception
    	 * @throws IOException Signals that an I/O exception has occurred.
    	 */
    	public void setDto(Dto pdto) throws FileNotFoundException, IOException{
	        this.dto = pdto;
	       notificarTodosObser();
	    }
	 
	 /**
 	 * Agregar observador.
 	 *
 	 * @param pObservador the observador
 	 */
 	public void agregarObservador(Observador pObservador){
	        observadores.add(pObservador);
	 }
	 
	 /**
 	 * Notificar todos obser.
 	 * 
 	 * @throws FileNotFoundException the file not found exception
 	 * @throws IOException Signals that an I/O exception has occurred.
 	 */
 	public void notificarTodosObser() throws FileNotFoundException, IOException{
	        for(int i = 0;i< observadores.size();i++){
	            observadores.get(i).update();
	        }
	      }

	 
	 
	 
}


