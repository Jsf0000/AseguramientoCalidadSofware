package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class HistogramaTest {

  @Test
 //crea y normaliza un histograma del frame 0
 public void  histFrameTest(){
  Video video = new Video();
  video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
  video.setFrames();
  video.getListFrames().elementAt(0).setNormHist();
  video.getListFrames().elementAt(0).hist.normHist();
   }

}
