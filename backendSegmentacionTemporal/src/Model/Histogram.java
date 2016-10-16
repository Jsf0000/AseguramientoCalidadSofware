package Model;

import java.util.ArrayList;
import java.util.LinkedList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Histogram {
    private Mat histH      = new Mat();
    private Mat histN      = new Mat();
    private Mat frameHNorm  = new Mat();
   
    private ArrayList <Mat> matList = new ArrayList <Mat>();
    //private MatOfFloat range =new MatOfFloat(0f,256f);
    //private MatOfInt histSize = new MatOfInt(255);
    MatOfFloat ranges =  new MatOfFloat(0f,256f );

    MatOfInt histSize = new MatOfInt(256);
  


    
    public Mat createHist(){
    	Imgproc.calcHist(matList,new MatOfInt(0), new Mat(), histH, histSize, ranges,false);
    	histN = histH.clone();
        return histH;
    }
    

       
    public Mat normHist(){
    	createHist();
    	double bin;
    	for(int i=0;i < 256;i++){
    		bin = histN.get(i,0)[0]/153600;
    		 histN.put(i,0, bin);
    	}
    	return histN;
    	
    }
    
    
    
    public double sumaHist(){
    	double suma =0;
    	for(int i=0;i< 256;i++){
    		suma += histN.get(i,0)[0];
    	}
    	return (suma);
    }
      
    
    public void setFrameNorm(Mat pframeHnorm){
    	matList.add(pframeHnorm);
    }
    
    
}
