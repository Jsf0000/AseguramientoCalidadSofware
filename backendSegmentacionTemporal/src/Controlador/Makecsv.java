package backendSegmentacionTemporal;

import java.io.FileWriter;
import java.util.Vector;

    public class Makecsv {


    private Vector<Integer> cutsFrames = new Vector<Integer>();
	 
    Makecsv(Vector<Integer> pcutsFrames){
		 cutsFrames = pcutsFrames;
		 writeCuts();
	 }
	 
	 
	 public void writeCuts()
	 {
		   try{
		       FileWriter fileWriter = new FileWriter("src/Cortes.csv",true);       
		       //Se agregan datos
		       fileWriter.append("Cortes;");
		       for(int i =0;i< cutsFrames.size();i++){
		    	   fileWriter.append(cutsFrames.get(i)+";"+"\n");
		       }
		       
		       // cierre del archivo
		       fileWriter.flush();
		       fileWriter.close();
		       
			      }catch (Exception e){
			          System.out.println("Error en CSV");
			      }
		                       
		      } 
   
    
	 
}
