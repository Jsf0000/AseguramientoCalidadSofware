package backendSegmentacionTemporal;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Frame {
    private Mat frame      = new Mat();
    private Mat frameHSV   = new Mat();
    private Mat frameHNorm = new Mat();
    private Vector <Mat> channels = new Vector<Mat>(3);
    Histogram hist = new Histogram();
    
    Frame(Mat pFrame){
    	frame = pFrame;
    }
    
    public Mat convertHSV(){
    	Imgproc.cvtColor(frame, frameHSV, Imgproc.COLOR_RGB2HSV);
    	return frameHSV;
    }
    
    public Vector<Mat> convertChannels(){
    	convertHSV();
    	org.opencv.core.Core.split(frameHSV,channels);
    	return channels;
    }
	
    public Mat normalizeH(){
    	convertChannels();
        org.opencv.core.Core.normalize(channels.firstElement(),frameHNorm, 0.0, 255.0,Core.NORM_MINMAX);
        return frameHNorm;
    }
    
    public Mat getFrame(){
    	return frame;
    }
    
    public void setNormHist(){
    	normalizeH();
    	hist.setFrameNorm(frameHNorm);
    }
        
}
