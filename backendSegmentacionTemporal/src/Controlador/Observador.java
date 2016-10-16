/*
 * 
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class Observador.
 */
public abstract class Observador {
	
    /** The subjeto. */
    protected Subjeto subjeto;
    
    /**
     * Update.
     * actualiza todos los observadores
     * @throws FileNotFoundException the file not found exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public abstract void update() throws FileNotFoundException, IOException;

}
