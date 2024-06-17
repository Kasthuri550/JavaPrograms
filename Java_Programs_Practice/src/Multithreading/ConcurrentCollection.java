package Multithreading;

import java.util.ArrayList;
import java.util.Iterator;

public class ConcurrentCollection extends Thread
{
	
	static ArrayList<String> al=new ArrayList<String>();
	
	@Override
	public void run() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Child Thread updating list");
		al.add("D");
	}

	public static void main(String[] args) {
		
		al.add("A");
		al.add("B");
		al.add("C");
		
		ConcurrentCollection cc=new ConcurrentCollection();
		cc.start();
		
		Iterator<String> iterator = al.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println("Main thread iterating list "+iterator.next());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
