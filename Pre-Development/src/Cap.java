

import java.awt.Color;
import java.awt.Graphics;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.VideoCapture;
import org.opencv.imgproc.Imgproc;
import org.opencv.video.BackgroundSubtractorMOG;

public class Cap extends JFrame {

	public static void main(String []args)	{
	
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	 JFrame frame = new JFrame("A R P T");
	 Mat webcam_image = new Mat();
	 VideoCapture capture = new VideoCapture(0);
	 BufferedImage image; 
	 
	 
	 JLabel con  = new JLabel("");
	 JLabel con1 = new JLabel("");
	 JLabel con2 = new JLabel("");
	 JLabel con3 = new JLabel("");
	 
	 frame.setSize(640,520);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.add(con); con.setBounds(0, 0, 320, 240);
		frame.add(con1); con1.setBounds(0,241, 320, 240);
		frame.add(con2); con2.setBounds(321,0, 320, 240);
		frame.add(con3); con3.setBounds(321,241, 320, 240);
		
		
		
		
		
		while(true)	{
			capture.read(webcam_image);
			System.out.println("Frame Obtained");
			 System.out.println("Captured Frame Width " + 
		     webcam_image.width() + " Height " + webcam_image.height());
			 Core.flip(webcam_image, webcam_image, 1); // flip image
			 image = matToBufferedImage(webcam_image);
			 
			 
			 
			 //rgb to hsv
			 Mat nMs = webcam_image.clone();
		     Imgproc.cvtColor(webcam_image, nMs, Imgproc.COLOR_BGR2HSV_FULL);
			 //Imgproc.cvtColor(webcam_image, nMs, Imgproc.COLOR_BGR2HSV);
			 
		     BufferedImage image1 = matToBufferedImage(nMs);
			 //rgb to hsv
		     
			 //rgb to grayscale
			 Mat nMz = webcam_image.clone();
		     Imgproc.cvtColor(webcam_image, nMz, Imgproc.COLOR_BGR2GRAY);
		     BufferedImage image2 = matToBufferedImage(nMz);
			 //rgb to grayscale
			
		     //rgb to ycrcb 
		      Mat nM = webcam_image.clone();
		      Imgproc.cvtColor(webcam_image, nM, Imgproc.COLOR_BGR2YCrCb);
		      BufferedImage image3 = matToBufferedImage(nM);
		      
		      //Imgproc.GaussianBlur(nM, nM, new org.opencv.core.Size (5,5), 2.2, 2);
		//      Mat mRgba = webcam_image;
		  //     Mat mFGMask = new Mat();
		    //   BackgroundSubtractorMOG mBGSub =  new BackgroundSubtractorMOG(3,4,0.8);
		       
		       
		      // mBGSub.apply(mRgba, mFGMask);
		       //image3 = matToBufferedImage(mFGMask);
		    //rgb to ycrcb
		      
		     
		      
		      //image1 = hsv
		      //image2 = grayscal
		      //image3 = ycrcb
		      //image = orig
		      
			 ImageIcon ii = new ImageIcon(image1);
			 ImageIcon ii1 = new ImageIcon(image2);
			 ImageIcon ii2 = new ImageIcon(image);
			 ImageIcon ii3 = new ImageIcon(image3);
			 
			 con.setIcon(ii);
			 con1.setIcon(ii1);
			 con2.setIcon(ii2);
			 con3.setIcon(ii3);
		}//while
		
		
	}//main
	
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
	
	
}//class