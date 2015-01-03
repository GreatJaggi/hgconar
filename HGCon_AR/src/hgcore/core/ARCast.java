package hgcore.core;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;

public class ARCast 	extends Thread{
	private static final long seralVersionUID = 1L;
	
	BufferedImage image;
	private double tresh = 50;
	
	public ARCast()	{
		
	}//Construct
	
	public void run()	{
		Mat webcam_image = new Mat();
		VideoCapture capture = new VideoCapture(0);
		Mat ground = new Mat();
		
		
		Mat model = new Mat();
		
		boolean sing = true;
		while(true)	{
			capture.read(webcam_image);
			System.out.println("Frame Captured: Width " + 
		    webcam_image.width() + " Height " + webcam_image.height());
			Core.flip(webcam_image, webcam_image, 1); // flip image
			
			//rgb to grayscale
			Mat nMz = webcam_image.clone();
		    Imgproc.cvtColor(webcam_image, nMz, Imgproc.COLOR_BGR2GRAY);
		     //rgb to grayscale
			//image = matToBufferedImage(nMz); // grayScale value
			
		    
		    Mat normal = webcam_image.clone();
		    
		    ground = webcam_image.clone();
		    //capturing a model image (one time only)
		    if(sing)	{
		    	capture.read(model);
		    	Core.flip(model, model, 1); // flip image
		    	sing = false;
		    }
			image = matToBufferedImage(ground); // normal BGR Output
		}//while=	
	}//thread
	
	public static BufferedImage matToBufferedImage(Mat m) { 
		int type = BufferedImage.TYPE_BYTE_GRAY;
        if ( m.channels() > 1 ) {
            type = BufferedImage.TYPE_3BYTE_BGR;
        }
        int bufferSize = m.channels()*m.cols()*m.rows();
        byte [] b = new byte[bufferSize];
        m.get(0,0,b); // get all the pixels
        BufferedImage image = new BufferedImage(m.cols(),m.rows(), type);
        final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        System.arraycopy(b, 0, targetPixels, 0, b.length);  
        return image;

	}//metToBufferedImage
	
	public BufferedImage getImage()	{
		return image;
	}//getImage()
	
//	public double getThresh()	{
//		return tresh;
//	}//get thresh
	
	public void setThresh(double value)	{
		tresh = value;
	}//setThresh
	
}//class
