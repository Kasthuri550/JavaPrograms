package designpatterns;

class Car {
	private String model;
	private String color;

	private Car(CarBuilder builder) {
		this.model = builder.model;
		this.color = builder.color;
	}

	public void showCar() {
		System.out.println("Car: " + model + ", Color: " + color);
	}

	// Builder Class
	public static class CarBuilder {
		private String model;
		private String color;

		public CarBuilder setModel(String model) { this.model = model; return this; }
		public CarBuilder setColor(String color) { this.color = color; return this; }

		public Car build() { return new Car(this); }
	}
}

public class BuilderDesignPattern {

	public static void main(String[] args) {

		Car car = new Car.CarBuilder()
				.setModel("BMW")
				.setColor("Black")
				.build();

		car.showCar();
	}
}
