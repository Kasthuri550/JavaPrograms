package designpatterns;

class Singleton {

	private static Singleton instance;

	private Singleton() {}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}

	void showMessage() {
		System.out.println("Singleton instance working!");
	}
}
public class SingletonDesignPattern {

	public static void main(String[] args) {

		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		s1.showMessage();

		System.out.println(s1 == s2);
	}
}
