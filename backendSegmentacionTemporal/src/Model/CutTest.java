package Model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CutTest {

  @Test
  @SuppressWarnings("deprecation")
  /* tamanno del arreglo de disimilitud*/
  
  public void testArrayDissimilaritySize()
  {
      Video video = new Video();
      Cut  cuts  =   new Cut();
      video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
      video.setFrames();
      cuts.setArrayDissimilarity(video.getListFrames());
      System.out.println(cuts.Dissimilaritysize());
  }
  
  
  
  
 /* @Test
 //prueba del arreglo de bhattacharyya
 public void arrayDissimilarityTest(){
    Video video = new Video();
    Cut  cuts  =   new Cut();
    video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
    video.setFrames();
    cuts.setArrayDissimilarity(video.getListFrames());
    System.out.println(cuts.getArrayDissimilarity().toString());
 }
*/
}
