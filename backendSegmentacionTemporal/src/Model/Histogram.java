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

//TODO: Auto-generated Javadoc


/**
 * The Class Histogram.
 */
public class Histogram {
    
    /** The histograma normal. */
    private Mat histH      = new Mat();
    
    /** The histograma normalizado. */
    private Mat histN      = new Mat();
    
    /** The frame H norm. */
    private Mat frameHNorm  = new Mat();
   
    /** The mat list. */
    private ArrayList <Mat> matList = new ArrayList <Mat>();
    
    /** The ranges del los histogramas. */
    MatOfFloat ranges =  new MatOfFloat(0f,256f );

    /** The hist size. */
    MatOfInt histSize = new MatOfInt(256);
  


    
    /**
     * Creates the hist.
     * Procedimiento citado en la especificacion del proyecto seccion 2.2
     * @return the mat
     */
    public Mat createHist(){
    	Imgproc.calcHist(matList,new MatOfInt(0), new Mat(), histH, histSize, ranges,false);
    	histN = histH.clone();
        return histH;
    }
    

       
    /**
     * Norm hist.
     * Seccion especificada en el proyecto seccion 2.2
     * Normaliza un histograma
     * @return the mat
     */
    public Mat normHist(){
    	createHist();
    	double bin;
    	for(int i=0;i < 256;i++){
    		bin = histN.get(i,0)[0]/153600;
    		 histN.put(i,0, bin);
    	}
    	return histN;
    	
    }
    
    
    
    /**
     * Suma hist.
     * suma total del contenido de los histograma, para verificar si esta normalizado
     * @return the double
     */
    public double sumaHist(){
    	double suma =0;
    	for(int i=0;i< 256;i++){
    		suma += histN.get(i,0)[0];
    	}
    	return (suma);
    }
      
    
    /**
     * Sets the frame norm.
     *
     * @param pframeHnorm the new frame norm
     */
    public void setFrameNorm(Mat pframeHnorm){
    	matList.add(pframeHnorm);
    }
    
    
}
