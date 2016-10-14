package backendSegmentacionTemporal;

import java.util.Vector;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Cut {

	private Bhattacharyya bhatta = new Bhattacharyya();
    private Vector<Double> dissimilarity = new Vector<Double>();
    private Vector<Integer> cuts = new Vector<Integer>();

    	public Vector<Integer> getCuts()
    	{
    		return cuts;
    	}
    	
         public double getBhattacharyya(Mat hist1, Mat hist2)
         {
        	 double x = (Imgproc.compareHist(hist1, hist2, 3));
        	 return x;
         }
         
         public double getBhattacharyyaDistance(Mat hist1, Mat hist2){
        	 if (hist1 == null || hist2 == null){
        		 return 0;
        	 }
        	 double result = bhatta.bhattacharyyaDistance(hist1, hist2);
        	 return result;
         }
    
         
         
         public void setArrayDissimilarity( Vector<Frame> pframes){
        	 for(int i = 0; i+1 < pframes.size();i++){
        		 pframes.elementAt(i).setNormHist();
        		 pframes.elementAt(i+1).setNormHist();
        		 dissimilarity.addElement(getBhattacharyyaDistance(pframes.elementAt(i).hist.normHist(),pframes.elementAt(i+1).hist.normHist()));
        	 }
         }
         
         public Vector<Double> getArrayDissimilarity()
         {
        	 return dissimilarity;
         }
         
           
         public double mediaVec(){
        	 double suma = 0;
        	 int size = dissimilarity.size();
        	 for(int i=0;i < size;i++){
        		 suma += dissimilarity.get(i);
        	 }
        	 return suma/size;
         }
         
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
        	 
        	 new Makecsv(cuts);
       }
         
}
