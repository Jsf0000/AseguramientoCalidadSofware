/*
 * 
 */
package Model;



import org.junit.Assert; 
import org.junit.Test;
import org.opencv.core.Mat;

// TODO: Auto-generated Javadoc
/**
 * The Class VideoTest.
 */
@SuppressWarnings("deprecation")
public class VideoTest {

	/**
	 * Test array dissimilarity.
	 */
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
	
	
/*	public void bhattacharyya(){
		Video video = new Video();
    	Cut  cuts  =   new Cut();
    	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    	video.setFrames();
    	video.getListFrames().elementAt(0).setNormHist();
    	video.getListFrames().elementAt(1).setNormHist();
    	Mat hist1 = video.getListFrames().elementAt(0).hist.normHist();
    	Mat hist2 = video.getListFrames().elementAt(1).hist.normHist();
    	Assert.assertEquals(0,cuts.getBhattacharyyaDistance(null, hist2),0);
		
	}*/
	
	
	/*	public void bhattacharyya(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
	video.setFrames();
	Mat hist1 = video.getListFrames().elementAt(0).hist.normHist();
	Mat hist2 = video.getListFrames().elementAt(1).hist.normHist();
	Assert.assertEquals(0,cuts.getBhattacharyyaDistance(null, hist2),0);
	
}*/
	
	
	
	
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
/*public void arrayBhattacharyyaTest(){
	Video video = new Video();
	Cut  cuts  =   new Cut();
	video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
	video.setFrames();
	cuts.setArrayDissimilarity(video.getListFrames());
	System.out.println(cuts.getArrayDissimilarity().toString());
}*/
	
	public void testArrayDissimilarity()
	{
		Video video = new Video();
		Cut  cuts  =   new Cut();
		video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
		video.setFrames();
		cuts.setArrayDissimilarity(video.getListFrames());
		Assert.assertEquals("Error en dissimilitud",cuts.sizeDissimilarity(),3682);

	}
	
	
	

	

}
