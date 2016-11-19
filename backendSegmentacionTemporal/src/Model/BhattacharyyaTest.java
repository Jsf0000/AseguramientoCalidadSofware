package Model;

import static org.junit.Assert.*;

import org.junit.Test;
import org.opencv.core.Mat;

import junit.framework.Assert;

public class BhattacharyyaTest {

  @Test
  
  
  public void bhattacharyyaTest(){
  Video video = new Video();
  Cut  cuts  =   new Cut();
  video.setVideo("C:/Proyecto1Lenguajes/Video.mp4");
  video.setFrames();
  video.getListFrames().elementAt(0).setNormHist();
  video.getListFrames().elementAt(1).setNormHist();
  Mat hist1 = video.getListFrames().elementAt(0).hist.normHist();
  Mat hist2 = video.getListFrames().elementAt(1).hist.normHist();
  System.out.println(cuts.getBhattacharyyaDistance(hist1, hist2));
   
   }
}
