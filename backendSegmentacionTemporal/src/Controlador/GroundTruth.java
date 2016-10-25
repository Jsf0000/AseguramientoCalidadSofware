/*
 * 
 */
package Controlador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * The Class GroundTruth.
 */
public class GroundTruth extends Observador{
	
	

	
	/** The groud truth list. */
	private static Vector<String> groudTruthList  = new Vector<String>();
	
	/** The falsos positivos. */
	private int falsosPositivos = 0;
	
	/** The falsos negativos. */
	private int falsosNegativos = 0;

	
	
	/**
	 * Instantiates a new ground truth.
	 *
	 * @param pSubjeto the subjeto
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	GroundTruth(Subjeto pSubjeto) throws FileNotFoundException, IOException{
		this.subjeto = pSubjeto;
	    this.subjeto.agregarObservador((Observador)this);		

	}
	
    /**
     * Cargar contenido.
     * Carga los cortes de los frames sennalados manualmente
     * @param parchivo the parchivo, se espera una direccion de archivo validad
     * @throws FileNotFoundException the file not found exception
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void cargarContenido(String parchivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(parchivo);
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
        	groudTruthList.addElement(cadena);
        }
        b.close();
        groudTruthList.remove(0);
        groudTruthList.remove(0);
        groudTruthList.remove(0);
    }
    
    
    
    /**
     * Make ground truth.
     * Realiza el groundTruth calculando los falsos pasitivos y negativos.
     * @param pcuts the pcuts , espera los cortes realizados y un delta de 15 a 5 
     * @param pdelta the pdelta
     */
    public void makeGroundTruth(Vector<Integer> pcuts, int pdelta){
    	for(int i=0;i<groudTruthList.size();i+=2){
    		
    	for(int y=0; y < pcuts.size();y++ )
    		if ( Integer.parseInt(groudTruthList.get(i)) <= pcuts.get(y)+pdelta && pcuts.get(y) <=  Integer.parseInt(groudTruthList.get(i+1))){
    			falsosPositivos++;
    		}
    	}
    	falsosNegativos = pcuts.size()-falsosPositivos;
    	System.out.println("Cortes detectados: "+pcuts.size());
    	System.out.println("Falsos Negativos: "+falsosNegativos+","+" falsos Positivos:"+ falsosPositivos);
    }
	
	/**
	 * Gets the falso positivo.
	 *
	 * @return the falso positivo
	 */
	public int getFalsoPositivo()
	{
		return falsosPositivos;
	}
	
	/**
	 * Gets the falsos negativos.
	 *
	 * @return the falsos negativos
	 */
	public int getFalsosNegativos()
	{
		return falsosNegativos;
	}
	

	/* (non-Javadoc)
	 * @see Controlador.Observador#update()
	 * actualizacion para este observador
	 */
	@Override
	public void update() throws FileNotFoundException, IOException {
		Dto dto = this.subjeto.getDto();
		cargarContenido(dto.getDirGt());
		makeGroundTruth(dto.getCut().getCuts(),dto.getDelta());
	}
	
	
	
	

}
