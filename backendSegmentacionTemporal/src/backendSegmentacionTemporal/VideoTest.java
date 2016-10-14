package backendSegmentacionTemporal;



import org.junit.Assert; 
import org.junit.Test;
import org.opencv.core.Mat;

@SuppressWarnings("deprecation")
public class VideoTest {

	@SuppressWarnings("deprecation")
	@Test
	//prueba al cargar el video.
/*	public void setVideoTest() {
		Video video = new Video();
		assertEquals("Erro ingresar video",true,video.setVideo("C:/Proyecto1Lenguajes/Video.mp4"));
		assertEquals("Error ingresar video",false,video.setVideo("C:/Proyecto1Lenguajes/Video.mp"));
	}*/
	
	/*
	public void setListFrames(){
		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
		assertEquals("Error en frames",3683,video.getSizeFrames());
	}*/
	
	
	public void bhattacharyya(){
		Video video = new Video();
    	Cut  cuts  =   new Cut();
    	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    	video.setFrames();
    	video.getListFrames().elementAt(0).setNormHist();
    	video.getListFrames().elementAt(1).setNormHist();
    	Mat hist1 = video.getListFrames().elementAt(0).hist.normHist();
    	Mat hist2 = video.getListFrames().elementAt(1).hist.normHist();
    	Assert.assertEquals(0.038132049890462594,cuts.getBhattacharyyaDistance(hist1, hist2),0.038132049890462594);
		
	}
	
	
	
	
// prueba de los histogramas
/*public void  histFrameTest(){
		Video video = new Video();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
		video.getListFrames().elementAt(0).setNormHist();
		video.getListFrames().elementAt(0).hist.normHist();
	}*/
// prueba de la funcion bhattacharyya
/*public void BhattacharyyaTest(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
	video.setFrames();
	video.getListFrames().elementAt(0).setNormHist();
	video.getListFrames().elementAt(1).setNormHist();
	System.out.println(cuts.getBhattacharyya(video.getListFrames().elementAt(0).hist.normHist(), video.getListFrames().elementAt(1).hist.normHist()));
}*/

//prueba del arreglo de bhattacharyya
public void arrayBhattacharyyaTest(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
	video.setFrames();
	cuts.setArrayDissimilarity(video.getListFrames());
	System.out.println(cuts.getArrayDissimilarity().toString());
}
	
	
	

	

}
