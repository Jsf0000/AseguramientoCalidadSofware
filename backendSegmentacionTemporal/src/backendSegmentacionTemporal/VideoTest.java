package backendSegmentacionTemporal;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runners.JUnit4;

public class VideoTest {

	@Test
	//prueba al cargar el video y dividirlo en frames algoritmo 1
/*	public void setVideoTest() {
		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");
		video.setFrames();
		video.getListFrames().elementAt(0).normalizeH();

	}*/
// prueba de los histogramas
/*public void  histFrameTest(){
		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");
		video.setFrames();
		video.getListFrames().elementAt(0).setNormHist();
		video.getListFrames().elementAt(0).hist.normHist();
	}*/
// prueba de la funcion bhattacharyya
/*public void BhattacharyyaTest(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");
	video.setFrames();
	video.getListFrames().elementAt(0).setNormHist();
	video.getListFrames().elementAt(1).setNormHist();
	System.out.println(cuts.getBhattacharyya(video.getListFrames().elementAt(0).hist.normHist(), video.getListFrames().elementAt(1).hist.normHist()));
}*/

//prueba del arreglo de bhattacharyya
public void arrayBhattacharyyaTest(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/cut1_360_processed_LAB_2iter.avi");
	video.setFrames();
	cuts.setArrayDissimilarity(video.getListFrames());
	System.out.println(cuts.getArrayDissimilarity().toString());
}
	
	
	

	

}
