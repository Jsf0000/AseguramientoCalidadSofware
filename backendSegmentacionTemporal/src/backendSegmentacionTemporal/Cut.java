package backendSegmentacionTemporal;

import java.util.Vector;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Cut {
        private Vector<Double> dissimilarity = new Vector<Double>();
         
         public double getBhattacharyya(Mat hist1, Mat hist2){
        	 double x = Imgproc.compareHist(hist1, hist2, 3);
        	 return x;
         }
         
         public void setArrayDissimilarity( Vector<Frame> pFrames){
        	 for(int i = 0; i+1 < pFrames.size();i++){
        		 pFrames.elementAt(i).setNormHist();
        		 pFrames.elementAt(i+1).setNormHist();
        		 dissimilarity.addElement(getBhattacharyya(pFrames.elementAt(i).hist.normHist(),pFrames.elementAt(i+1).hist.normHist()));
        	 }
         }
         
         public Vector<Double> getArrayDissimilarity(){
        	 return dissimilarity;
         }
         
}
