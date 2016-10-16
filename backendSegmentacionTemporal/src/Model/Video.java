/*
 * 
 */
package Model;

import java.util.Vector;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;

// TODO: Auto-generated Javadoc
/**
 * The Class Video.
 */
public class Video {
	
	/** The camera. */
	private VideoCapture camera;
	
	/** The frames. */
	private Vector<Frame> frames = new Vector<Frame>();
	
	
	/**
	 * Sets the video.
	 * 
	 * @param pdir the pdir
	 * @return true, if successful
	 */
	public boolean setVideo(String pdir){
			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			System.loadLibrary("opencv_ffmpeg2412_64");
	        camera = new VideoCapture(pdir);	
		
        return camera.isOpened();
	  }
	
	
	
	/**
	 * Sets the frames.
	 */
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
	
	/**
	 * Gets the list frames.
	 *
	 * @return the list frames
	 */
	public Vector<Frame> getListFrames()
	{
		return frames;
	}
	
	/**
	 * Gets the size frames.
	 *
	 * @return the size frames
	 */
	public int getSizeFrames(){
		return frames.size();
	}
	
	
	}


    



	
