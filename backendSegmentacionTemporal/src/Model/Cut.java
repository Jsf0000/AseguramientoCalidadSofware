/*
 * 
 */
package Model;

import java.util.Vector;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import Controlador.Makecsv;

// TODO: Auto-generated Javadoc
/**
 * The Class Cut.
 */
public class Cut {

	/** The bhatta. */
	private Bhattacharyya bhatta = new Bhattacharyya();
    
    /** The dissimilarity. */
    private Vector<Double> dissimilarity = new Vector<Double>();
    
    /** The cuts. */
    private Vector<Integer> cuts = new Vector<Integer>();

    	/**
	     * Gets the cuts.
	     *
	     * @return the cuts
	     */
	    public Vector<Integer> getCuts()
    	{
    		return cuts;
    	}
    	
         /**
          * Size dissimilarity.
          *
          * @return the int
          */
         public int Dissimilaritysize()
         {
        	 return dissimilarity.size();
         }
    	   	
         /**
          * Gets the bhattacharyya.
          * calcula la distancia de bhattacharyya utilizando el metodo de la libreria de opencv
          * @param phist1 the phist 1
          * @param phist2 the phist 2
          * @return the bhattacharyya
          */
         public double getBhattacharyya(Mat phist1, Mat phist2)
         {
        	 double x = (Imgproc.compareHist(phist1, phist2, 3));
        	 return x;
         }
         
         /**
          * Gets the bhattacharyya distance.
          * Calcula el metodo de bhattacharyya utilizadon la funcion programada manualmente
          * @param phist1 the phist 1
          * @param phist2 the phist 2
          * @return the bhattacharyya distance
          */
         public double getBhattacharyyaDistance(Mat phist1, Mat phist2){
        	 if (phist1 == null || phist2 == null){
        		 return 0;
        	 }
        	 double result = bhatta.bhattacharyyaDistance(phist1, phist2);
        	 return result;
         }
    
         
         
         /**
          * Sets the array dissimilarity.
          * Procedimiento citado en la especificacion del proyecto seccion 2.4
          * @param pframes the new array dissimilarity
          */
         public void setArrayDissimilarity( Vector<Frame> pframes){
        	 for(int i = 0; i+1 < pframes.size();i++){
        		 pframes.elementAt(i).setNormHist();
        		 pframes.elementAt(i+1).setNormHist();
        		 dissimilarity.addElement(getBhattacharyyaDistance(pframes.elementAt(i).hist.normHist(),pframes.elementAt(i+1).hist.normHist()));
        	 }
         }
         
         /**
          * Gets the array dissimilarity.
          *
          * @return the array dissimilarity
          */
         public Vector<Double> getArrayDissimilarity()
         {
        	 return dissimilarity;
         }
         
           
         /**
          * Media vec.
          * Calcula la media del arreglo de disimilitud
          * @return the double
          */
         public double mediaVec(){
        	 double suma = 0;
        	 int size = dissimilarity.size();
        	 for(int i=0;i < size;i++){
        		 suma += dissimilarity.get(i);
        	 }
        	 return suma/size;
         }
         
         /**
          * Dv standar.
          * calcula la desviacion estandar del arreglo de disimilitud
          * @return the double
          */
         public double dvStandar()
         {
        	 double suma = 0;
        	 int size = dissimilarity.size();
        	 double media = mediaVec();
        	 double result = 0; 
        	 for(int i=0;i < size;i++){
        		 suma += Math.pow((dissimilarity.get(i) - media),2);
        	 }
        	 result = suma/(size);
        	 result = Math.sqrt(result);
        	 return result;
         }
         
         /**
          * Cal cuts.
          * Procedimiento citado en la especificacion del proyecto seccion 2.5
          * calcula el numero de frames donde existen cortes y los guarda en el arreglo cuts
          */
         public void calCuts(){
        	double DevMedia = mediaVec()+ dvStandar();
        	 for (int i=0;i<dissimilarity.size();i++){
        		   if(dissimilarity.get(i) >= DevMedia){
        			   if (!cuts.contains(i))
        			   {
        				   cuts.addElement(i);
        			   }
        			   else if(!cuts.contains(i+1))
        			   {
        				   cuts.addElement(i+1);
        			   }
        		   }
        	 }
        	 //System.out.println(cuts.size());
        	 //System.out.println(cuts.toString());
        	 
       }
         
}
