package Controlador;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

import Model.Cut;
import Model.Video;

public class ControladorTest {


  
  @Test
  public void GroundTruthCuts() throws FileNotFoundException, IOException{
    Dto dto = new Dto();
    dto.setDireccionVideo("C:/Proyecto1Lenguajes/Video.mp4");
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
    new GroundTruth(s);
    s.setDto(dto);
  }

}
