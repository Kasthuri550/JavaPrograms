package designpatterns;

class Singleton1 {

	// volatile ensures visibility across threads
	private static volatile Singleton1 instance;

	private Singleton1() {}

	public static Singleton1 getInstance() {
		if (instance == null) {               // 1st check
			synchronized (Singleton1.class) {  // lock
				if (instance == null) {       // 2nd check
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}

	void showMessage() {
		System.out.println("Double-checked Singleton works!");
	}
}

public class SingletonWithDoubleCheckedLocking {

	public static void main(String[] args) {

		Singleton1 singleton1=Singleton1.getInstance();
		Singleton1 singleton2=Singleton1.getInstance();

		singleton1.showMessage();
		System.out.println(singleton1==singleton2);
	}
}
