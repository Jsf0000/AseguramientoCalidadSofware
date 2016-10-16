package backendSegmentacionTemporal;

import org.opencv.core.Mat;

public class Bhattacharyya {
	
	 public double bhattacharyyaDistance(Mat hist1,Mat hist2)
	 {
    	 double result = Math.sqrt(1 - (getAlpha(hist1,hist2)*getBeta(hist1,hist2)));
		return result;
     }
         
     public double getAlpha(Mat hist1,Mat hist2) {
         double result = 1/(Math.sqrt(media(hist1)*media(hist2)*Math.pow(256, 2)));
         return result;
     }
         
        public double media(Mat hist1){
        	double suma =0;
        	for(int i=0;i< 256;i++){
        		suma += hist1.get(i,0)[0];
        	}
        	return (suma/256);
        }
        
        public double getBeta(Mat hist1,Mat hist2){
        	double suma=0;
            for(int i=0;i<256;i++){
            	suma += (Math.sqrt(hist1.get(i,0)[0])*Math.sqrt(hist2.get(i,0)[0]));
            }
            return suma;
        }
         

}
