package java8;


public class MethodReferenceExample {

	public static void m1()
	{
		System.out.println("I am running");
	}
	public static void main(String[] args) {
		
		Runnable r=MethodReferenceExample::m1;
		Thread t=new Thread(r);
		t.start();
		

	}

}
