package backendSegmentacionTemporal;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class Main {
	
	// retorna una imagen  tipo Imagecon entrada un tipo Mat

	public static BufferedImage createAwtImage(Mat mat) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.loadLibrary("opencv_ffmpeg2412_64");
	    int type = 0;
	    if (mat.channels() == 1) {
	        type = BufferedImage.TYPE_BYTE_GRAY;
	    } else if (mat.channels() == 3) {
	        type = BufferedImage.TYPE_3BYTE_BGR;
	    } else {
	        return null;
	    }

	    BufferedImage image = new BufferedImage(mat.width(), mat.height(), type);
	    WritableRaster raster = image.getRaster();
	    DataBufferByte dataBuffer = (DataBufferByte) raster.getDataBuffer();
	    byte[] data = dataBuffer.getData();
	    mat.get(0, 0, data);

	    return image;
	    
	    
	    
	    
	}
    

	 /**
	 * @param args
	 */
	public static void main (String args[]){
		//variables

		 
    	//Configurar la ventana 
		
        JFrame jframe = new JFrame("Imagen");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel vidpanel = new JLabel();
        jframe.setContentPane(vidpanel);
        jframe.setVisible(true);
        jframe.setSize(640,360);
        
        //----------Algoritmo-1--------------------
		
/*        Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
        ImageIcon image = new ImageIcon(createAwtImage(video.getListFrames().elementAt(0).normalizeH()));
        vidpanel.setIcon(image);*/
        
        //-----------Algoritmo-2--------------------
        
/*		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
		video.getListFrames().elementAt(0).setNormHist();
        ImageIcon image = new ImageIcon(createAwtImage(video.getListFrames().elementAt(0).hist.imageHist()));
        vidpanel.setIcon(image);*/
        
        
        //-----------Algoritmo-3---------------------
        
/*    	Video video = new Video();
    	Cut  cuts  =   new Cut();
    	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    	video.setFrames();
    	video.getListFrames().elementAt(0).setNormHist();
    	video.getListFrames().elementAt(1).setNormHist();
    	System.out.println(cuts.getBhattacharyya(video.getListFrames().elementAt(0).hist.normHist(), video.getListFrames().elementAt(1).hist.normHist()));
        */
                
        //-----------Algoritmo-4-------------------------
        
 /*   	Video video = new Video();
    	Cut  cuts  =   new Cut();
    	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    	video.setFrames();
    	cuts.setArrayDissimilarity(video.getListFrames());
    	System.out.println(cuts.getArrayDissimilarity().toString());
        
		*/
	 }
	
	
}
