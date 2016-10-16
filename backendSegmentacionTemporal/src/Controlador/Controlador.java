/*
 * 
 */
package Controlador;

import java.io.FileNotFoundException;
import java.io.IOException;

import Model.Cut;
import Model.Video;

// TODO: Auto-generated Javadoc
/**
 * The Class Controlador.
 */
public class Controlador {
	
	
	/** The dto. */
	Dto dto = new Dto();
	
	/**
	 * Show cuts.
	 * Funcion que contrala todas la funcinalidades de la aplicacion 
	 * @param pdirVideo the pdir video
	 * @throws FileNotFoundException the file not found exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void showCuts(String pdirVideo) throws FileNotFoundException, IOException
	{
		dto.setDireccionVideo(pdirVideo);
		dto.setDelta(5);
		dto.setDireccionC("src/Cortes.csv");
		dto.setDirGt("src/GroundTruth.txt");
		Video video = new Video();
    	Cut  cuts  =   new Cut();
    	video.setVideo(dto.getDireccion());
    	video.setFrames();
		cuts.setArrayDissimilarity(video.getListFrames());
		cuts.calCuts();
		dto.setCut(cuts);
		Subjeto s = new Subjeto();
		new Makecsv(s);
		new GroundTruth(s);
		s.setDto(dto);
	}
	

}
