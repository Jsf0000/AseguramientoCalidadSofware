package backendSegmentacionTemporal;

import java.util.LinkedList;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

public class Histogram {
    private Mat histH      = new Mat();
    private java.util.List<Mat> matList = new LinkedList<Mat>();
    private MatOfFloat range =new MatOfFloat(0,256);
    private MatOfInt histSize = new MatOfInt(255);
    private Mat histImage = Mat.zeros( 100, (int)histSize.get(0, 0)[0], CvType.CV_8UC1);

    
    public Mat createHist(){
        Imgproc.calcHist(matList,new MatOfInt(0), new Mat(), histH, histSize, range);
        return histH;
    }
    
    public Mat normHist(){
    	createHist();
        Core.normalize(histH, histH, 1, histImage.rows() , Core.NORM_MINMAX, -1, new Mat() );   
        return histH;
    }
    
    public Mat imageHist(){
    	normHist();
    	for( int j = 0; j < (int)histSize.get(0, 0)[0]; j++ )
        {                   
                Core.line(
                        histImage,
                        new org.opencv.core.Point( j, histImage.rows() ),
                        new org.opencv.core.Point( j, histImage.rows()-Math.round( histH.get(j,0)[0] )),
                        new Scalar( 255, 255, 255),
                        1, 8, 0 );
        }
    	return histImage;
    }
    
    
    public void setFrameNorm(Mat pFrameHNorm){
    	matList.add(pFrameHNorm);
    }
    
    
}
