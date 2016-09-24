
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.util.Vector;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.*;
import org.opencv.highgui.Highgui;        
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

        
public class VideoCap {
	
	// retorna una imagen  tipo Imagecon entrada un tipo Mat
	
	public static BufferedImage createAwtImage(Mat mat) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
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

	
    public static void main (String args[]){
    	//Configurar la ventana 
        JFrame jframe = new JFrame("Imagen");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel vidpanel = new JLabel();
        jframe.setContentPane(vidpanel);
        jframe.setVisible(true);
        jframe.setSize(640,360);
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	
    	// Matrices para el frame y el HSV 
        Mat frame      = new Mat();
        Mat frameHSV   = new Mat();
        Mat frameHNorm = new Mat();
        VideoCapture camera = new VideoCapture("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");

        
        /*
	        Mat hsv;
			vector<Mat> channels;
			split(hsv, channels);
	    */
        
        
        // Este while extrae el primer frame 
        int i =0;
        while (i<=100000) {
            if (camera.read(frame)) {
                //System.out.println(frame);
                Imgproc.cvtColor(frame, frameHSV, Imgproc.COLOR_RGB2HSV);
                
            	
                // para extraer la capa H en channels[0]
            	Vector <Mat> channels = new Vector<Mat>(3);
            	org.opencv.core.Core.split(frameHSV,channels);
            
               // normalizacion
                org.opencv.core.Core.normalize(channels.firstElement(),frameHNorm, 0.0, 255.0,Core.NORM_MINMAX);
                System.out.println("OpenCV Mat: " + frameHNorm.dump());
            	ImageIcon image = new ImageIcon(createAwtImage(frameHNorm));
                vidpanel.setIcon(image);
            }
            i++;
        }
        
    }
} 