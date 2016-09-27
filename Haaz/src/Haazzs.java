import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Haazzs  extends JFrame{
	public Haazzs()	{
		super("Man");
	}//cons
	
	public static void main(String []args)	{
		Haazzs frame = new Haazzs();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000,600);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Hello!");
	}//main
}//class
