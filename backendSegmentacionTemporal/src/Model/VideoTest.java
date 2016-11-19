/*
 * 
 */
package Model;



import static org.junit.Assert.*;

import org.junit.Assert; 
import org.junit.Test;
import org.opencv.core.Mat;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoTest.
 */
public class VideoTest {


	
// prueba al cargar el video.
  @SuppressWarnings("deprecation")
  @Test
  public void setVideoTest() {
        Video video = new Video();
        video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    }
  
  
    /*Prueba hacer lista de frames*/
	@SuppressWarnings("deprecation")
    @Test
   
  public void setListFrames(){
		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
	}
  

  
  /* Obtener el tamano del array de frames*/
  @SuppressWarnings("deprecation")
  @Test
  public void getSizeArrayFrames(){
    Video video = new Video();
    video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    video.setFrames();
    video.getSizeFrames();
  }
  
	
	


	

}
