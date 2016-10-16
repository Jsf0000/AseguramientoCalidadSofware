package backendSegmentacionTemporal;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Frame {
    private Mat frame      = new Mat();
    private Mat frameHsv   = new Mat();
    private Mat frameHNorm = new Mat();
    private Vector <Mat> channels = new Vector<Mat>(3);
    Histogram hist = new Histogram();
    
    Frame(Mat pframe){
    	frame = pframe;
    }
    
    public Mat getFramehsv(){
    	return frameHsv;
    }
    
    public Mat getFrameHNorm(){
    	return frameHNorm;
    }
    
    public Mat convertHsv(){
    	Imgproc.cvtColor(frame, frameHsv, Imgproc.COLOR_RGB2HSV);
    	return frameHsv;
    }
    
    public Vector<Mat> convertChannels(){
    	convertHsv();
    	org.opencv.core.Core.split(frameHsv,channels);
    	return channels;
    }
	
    public Mat normalizeH(){
    	convertChannels();
        org.opencv.core.Core.normalize(channels.elementAt(0),frameHNorm, 0.0, 255.0,Core.NORM_MINMAX);
        return frameHNorm;
    }
    
    public Mat getFrame(){
    	return frame;
    }
    
    public void setNormHist(){
    	normalizeH();
    	hist.setFrameNorm(frameHsv);
    }
        
}
