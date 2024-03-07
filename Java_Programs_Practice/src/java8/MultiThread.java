package java8;

class MyRunnable implements Runnable
{

	@Override
	public void run() {
		
		for(int i=0;i<5;i++)
		{
			System.out.println("Child thread");
		}
		
	}
}

public class MultiThread {

	public static void main(String[] args) {
		
		Runnable runnable=()->{
			
			for(int i=0;i<5;i++)
			{
				System.out.println("Child thread");
			}
		};
		Thread t=new Thread(runnable);
		t.start();
		for(int i=0;i<5;i++)
		{
			System.out.println("Main thread");
		}
	}
}
