package Multithreading;

public class Deadlock {
	
	private static Object resource1=new Object();
	private static Object resource2=new Object();

	public static void main(String[] args) {
	
		Thread thread1=new Thread(()->{
			
			synchronized (resource1) {
				
				System.out.println("Thread1: Holding resource1...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Thread1: Waiting for resource2...");
				synchronized (resource2) {
					
					System.out.println("Thread1: Holding resource2 and resource1...");
				}
			}
			
		});
		
		Thread thread2=new Thread(()->{
			
			synchronized (resource2) {
				
				System.out.println("Thread2: Holding resource2...");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread2: Waiting for resource1...");
				
				synchronized (resource1) {
					
					System.out.println("Thread2: Holding resource1 and resource2...");
					
				}
				
			}
		});
		
		thread1.start();
		thread2.start();
	
	}

}
