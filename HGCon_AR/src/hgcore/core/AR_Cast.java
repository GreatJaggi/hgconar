package hgcore.core;

import javax.swing.JFrame;

import org.opencv.core.Core;

public class AR_Cast extends JFrame{
	
	public AR_Cast()	{
		super("AR Casting");
	}//construct
	
	public static void main(String []args)	{
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		AR_Cast frame = new AR_Cast();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}//main
}//class
