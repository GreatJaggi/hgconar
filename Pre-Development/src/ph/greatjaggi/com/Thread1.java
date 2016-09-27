package ph.greatjaggi.com;

public class Thread1 extends Thread{
	
	private int count = 1;
	
	public Thread1()	{
	
	}//construct
	
	public void run()	{
		while(true)	{
			System.out.println("Frame " + count++);
		}
	}//run
}
