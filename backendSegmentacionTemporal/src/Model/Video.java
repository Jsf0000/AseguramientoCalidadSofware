package backendSegmentacionTemporal;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

public class Video {
	private VideoCapture camera;
	private Vector<Frame> frames = new Vector<Frame>();
	
	
	public boolean setVideo(String dir){
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.loadLibrary("opencv_ffmpeg2412_64");
	        camera = new VideoCapture(dir);	
		
        return camera.isOpened();
	  }
	
	
	
	public void setFrames(){
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.loadLibrary("opencv_ffmpeg2412_64");
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
	
	public Vector<Frame> getListFrames()
	{
		return frames;
	}
	
	public int getSizeFrames(){
		return frames.size();
	}
	
	
	}


    



	
