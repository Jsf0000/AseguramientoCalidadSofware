package Controlador;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class MakecsvTest {

  @Test
   public void testWriteCsv(){
    Makecsv csv = new Makecsv();
    Vector<Integer> pcuts = new Vector<Integer>();
    pcuts.add(1);
    pcuts.add(2);
    pcuts.add(3);
    pcuts.add(6);
    pcuts.add(8);
    csv.writeCuts("src/Cortes.csv", pcuts);
  }

    
    
    
    
}
