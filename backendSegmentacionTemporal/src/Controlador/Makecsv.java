/*
 * 
 */
package Controlador;

import java.io.FileWriter;
import java.util.Vector;

    // TODO: Auto-generated Javadoc
/**
     * The Class Makecsv.
     * Realiza para guardar los cortes en Csv
     */
    public class Makecsv extends Observador{



	
    
    
    /**
     * Instantiates a new makecsv.
     * 
     * @param psubjeto the psubjeto
     */
    public Makecsv(Subjeto psubjeto){
    	 this.subjeto = psubjeto;
    	 this.subjeto.agregarObservador((Observador)this);
		 //cutsFrames = pcutsFrames;
		// writeCuts();
	 }
	 
	 
	 /**
 	 * Write cuts.
 	 * Escribe los cortes en un CSV
 	 * @param pdireccionC the pdireccion C
 	 * @param pcuts the pcuts
 	 * 
 	 */
 	public void writeCuts(String pdireccionC,Vector<Integer> pcuts)
	 {
		   try{
		       FileWriter fileWriter = new FileWriter(pdireccionC,true);       
		       //Se agregan datos
		       fileWriter.append("Cortes;");
		       for(int i =0;i< pcuts.size();i++){
		    	   fileWriter.append(pcuts.get(i)+";"+"\n");
		       }
		       
		       // cierre del archivo
		       fileWriter.flush();
		       fileWriter.close();
		       
			      }catch (Exception e){
			          System.out.println("Error en CSV");
			      }
		                       
		      }


	/* (non-Javadoc)
	 * @see Controlador.Observador#update()
	 * Actualiza los observadores
	 */
	@Override
	public void update() {
		Dto dto = this.subjeto.getDto();
		writeCuts(dto.getDireccionC(),dto.getCut().getCuts());
	} 
   
    
	 
}
