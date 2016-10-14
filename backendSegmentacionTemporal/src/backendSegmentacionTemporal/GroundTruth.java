package backendSegmentacionTemporal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class GroundTruth {
	
	

	
	private Vector<Integer> cuts = new Vector<Integer>();
	private static Vector<String> groudTruthList  = new Vector<String>();
	int falsosPositivos = 0;
	int falsosNegativos = 0;
	
	
	GroundTruth(Vector<Integer> pcuts,String parchivo) throws FileNotFoundException, IOException{
		cuts = pcuts;
		cargarContenido(parchivo);
		makeGroundTruth();
	}
	
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
    
    
    
    public void makeGroundTruth(){
    	for(int i=0;i<groudTruthList.size();i+=2){
    		
    	for(int y=0;y < cuts.size();y++ )
    		if ( Integer.parseInt(groudTruthList.get(i)) <= cuts.get(y) && cuts.get(y) <=  Integer.parseInt(groudTruthList.get(i+1))){
    			falsosPositivos++;
    		}
    	}
    	falsosNegativos = cuts.size()-falsosPositivos;
    	System.out.println("Falsos Negativos: "+falsosNegativos+","+" falsos Positivos:"+ falsosPositivos);
    }
	
	
	
	
	
	

}
