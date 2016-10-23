/*
 * 
 */
package Model;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

// TODO: Auto-generated Javadoc
/**
 * The Class Frame.
 */
public class Frame {
    
    /** The frame. */
    private Mat frame      = new Mat();
    
    /** The frame hsv. */
    private Mat frameHsv   = new Mat();
    
    /** The frame H norm. */
    private Mat frameHNorm = new Mat();
    
    /** The channels. */
    private Vector <Mat> channels = new Vector<Mat>(3);
    
    /** The hist. */
    Histogram hist = new Histogram();
    
    /**
     * Instantiates a new frame.
     *
     * @param pframe the pframe
     */
    Frame(Mat pframe){
    	frame = pframe;
    }
    
    /**
     * Gets the framehsv.
     *
     * @return the framehsv
     */
    public Mat getFramehsv(){
    	return frameHsv;
    }
    
    /**
     * Gets the frame H norm.
     * obtiene la capa H normalizada
     * @return the frame H norm
     */
    public Mat getFrameHNorm(){
    	return frameHNorm;
    }
    
    /**
     * Convert hsv.
     * Conviete una imagen en HSV
     * @return the mat
     */
    public Mat convertHsv(){
    	Imgproc.cvtColor(frame, frameHsv, Imgproc.COLOR_RGB2HSV);
    	return frameHsv;
    }
    
    /**
     * Convert channels.
     * Divide una imagen HSV en el vector Channels.
     * @return the vector
     */
    public Vector<Mat> convertChannels(){
    	convertHsv();
    	org.opencv.core.Core.split(frameHsv,channels);
    	return channels;
    }
	
    /**
     * Normalize H.
     * Normaliza la capa H del HSV
     * @return the mat
     */
    public Mat normalizeH(){
    	convertChannels();
        org.opencv.core.Core.normalize(channels.elementAt(0),frameHNorm, 0.0, 255.0,Core.NORM_MINMAX);
        return frameHNorm;
    }
    
    /**
     * Gets the frame.
     *
     * @return the frame
     */
    public Mat getFrame(){
    	return frame;
    }
    
    /**
     * Sets the norm hist.
     */
    public void setNormHist(){
    	normalizeH();
    	hist.setFrameNorm(frameHsv);
    }
        
}
