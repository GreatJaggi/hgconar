import javax.swing.JFrame;


public class NothingMain	extends JFrame {
	public NothingMain()	{
		super("Nothing");
	}//cons
	
	public static void main(String []args)	{
		NothingMain frame = new NothingMain();
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}//main
}//class
