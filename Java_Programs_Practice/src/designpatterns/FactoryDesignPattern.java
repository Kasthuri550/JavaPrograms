package designpatterns;

interface Payment {
	void pay(int amount);
}

class CreditCardPayment implements Payment {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using Credit Card");
	}
}

class UPIPayment implements Payment {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using UPI");
	}
}

class PaymentFactory {
	public Payment getPayment(String type) {
		if (type.equalsIgnoreCase("CREDIT")) return new CreditCardPayment();
		if (type.equalsIgnoreCase("UPI")) return new UPIPayment();
		return null;
	}
}

public class FactoryDesignPattern {

	public static void main(String[] args) {

		PaymentFactory factory = new PaymentFactory();

		Payment p1 = factory.getPayment("CREDIT");
		p1.pay(1000);

		Payment p2 = factory.getPayment("UPI");
		p2.pay(300);
	}
}
