package designpatterns;

interface PaymentStrategy {
	void pay(int amount);
}

class CreditCardPayments implements PaymentStrategy {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using Credit Card");
	}
}

class UPIPayments implements PaymentStrategy {
	public void pay(int amount) {
		System.out.println("Paid " + amount + " using UPI");
	}
}

class PaymentContext {
	private PaymentStrategy strategy;

	public void setPaymentStrategy(PaymentStrategy strategy) {
		this.strategy = strategy;
	}

	public void payAmount(int amount) {
		strategy.pay(amount);
	}
}

public class StrategyDesignPattern {

	public static void main(String[] args) {

		PaymentContext context = new PaymentContext();

		context.setPaymentStrategy(new CreditCardPayments());
		context.payAmount(1000);

		context.setPaymentStrategy(new UPIPayments());
		context.payAmount(500);
	}
}
