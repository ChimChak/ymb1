package test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import test.mypac.Car;
import test.mypac.CarService;

public class MainClass3 {
	public static void main(String[] args) {
		ApplicationContext context=
				new ClassPathXmlApplicationContext("test/main/init.xml");
		CarService cs=context.getBean(CarService.class);
		Car car1=cs.getMyCar();
		car1.drive();
		System.out.println("-------");
		Car car2=cs.getYourCar();
		car2.drive();
	}
}
















