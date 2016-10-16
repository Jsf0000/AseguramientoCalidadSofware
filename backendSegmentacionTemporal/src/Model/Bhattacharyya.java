/*
 * 
 */
package Model;

import org.opencv.core.Mat;

// TODO: Auto-generated Javadoc
/**
 * The Class Bhattacharyya.
 */
public class Bhattacharyya {
	
	 /**
 	 * Bhattacharyya distance.
 	 *
 	 * @param phist1 the phist 1
 	 * @param phist2 the phist 2
 	 * @return the double
 	 */
 	public double bhattacharyyaDistance(Mat phist1,Mat phist2)
	 {
    	 double result = Math.sqrt(1 - (getAlpha(phist1,phist2)*getBeta(phist1,phist2)));
		return result;
     }
         
     /**
      * Gets the alpha.
      * obtiene el alpha correspondiente a la funcion de bhattacharyya
      * @param phist1 the hist 1
      * @param phist2 the hist 2
      * @return the alpha
      */
     public double getAlpha(Mat phist1,Mat phist2) {
         double result = 1/(Math.sqrt(media(phist1)*media(phist2)*Math.pow(256, 2)));
         return result;
     }
         
        /**
         * Media.
         * calcula la media del diagrama de disimilitud
         * @param phist1 the phist 1
         * @return the double
         */
        public double media(Mat phist1){
        	double suma =0;
        	for(int i=0;i< 256;i++){
        		suma += phist1.get(i,0)[0];
        	}
        	return (suma/256);
        }
        
        /**
         * Gets the beta.
         * Calcula el beta corespondiente a la funcion de bhatacharyya
         * @param phist1 the phist 1
         * @param phist2 the phist 2
         * @return the beta
         */
        public double getBeta(Mat phist1,Mat phist2){
        	double suma=0;
            for(int i=0;i<256;i++){
            	suma += (Math.sqrt(phist1.get(i,0)[0])*Math.sqrt(phist2.get(i,0)[0]));
            }
            return suma;
        }
         

}
