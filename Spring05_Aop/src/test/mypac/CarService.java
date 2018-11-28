package test.mypac;

public class CarService {
	
	public Car getMyCar() {
		Car c=new Car();
		return c;
	}
	
	public Car getYourCar() {
		Car c=new Car();
		c.name="소나타";
		return c;
	}
}
