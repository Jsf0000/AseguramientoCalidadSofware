package backendSegmentacionTemporal;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class Video {
	VideoCapture camera;
	Vector<Frame> frames = new Vector<Frame>();
	
	
	public void setVideo(String dir){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        camera = new VideoCapture(dir);		
	  }
	
	public void setFrames(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat frame = new Mat();
        boolean open = true;
        while(open){
        	open = false;
        	if(camera.read(frame)){
        		open = true;
        		frames.add(new Frame(frame.clone()));
        	}
         }
	  }
	
	public Vector<Frame> getListFrames(){
		return frames;
	}
	
	}


    



	
