package backendSegmentacionTemporal;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.opencv.core.Core;
import org.opencv.core.Mat;

public class Main {
	
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
    

	 /**
	 * @param args
	 */
	public static void main (String args[]){
		//variables
		 
		Video video = new Video();
    	//Configurar la ventana 
        JFrame jframe = new JFrame("Imagen");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel vidpanel = new JLabel();
        jframe.setContentPane(vidpanel);
        jframe.setVisible(true);
        jframe.setSize(640,360);
		 //obtener el video, algoritmo 1
		video.setVideo("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");
		// Poner frames en una lista, algoritmo 1
		video.setFrames();
		// normalizar H, algoritmo 1
		video.getListFrames().elementAt(1).normalizeH();
		//poner calcular el histograma para el frame
		video.getListFrames().elementAt(1).setNormHist();
		//obtener una imagen del histograma normalizado
		video.getListFrames().elementAt(1).hist.imageHist();
       ImageIcon image = new ImageIcon(createAwtImage(video.getListFrames().elementAt(1).hist.imageHist()));
       vidpanel.setIcon(image);
		
	 }
	
	
}
