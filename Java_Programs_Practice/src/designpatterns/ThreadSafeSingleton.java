package designpatterns;

class Singletons {

	private static Singletons instance;

	private Singletons() {}

	public static synchronized Singletons getInstance() {
		if (instance == null) {
			instance = new Singletons();
		}
		return instance;
	}

	void showMessage() {
		System.out.println("Thread-safe Singleton works!");
	}
}

public class ThreadSafeSingleton {

	public static void main(String[] args) {

		Singletons singletons1=Singletons.getInstance();
		Singletons singletons2=Singletons.getInstance();

		singletons1.showMessage();
		System.out.println(singletons1==singletons2);
	}
}
