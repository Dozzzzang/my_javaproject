package test.main;

import test.auto.Car;
import test.auto.Engine;

public class MainClass06 {
	public static void main(String[] args) {
		//Car 객체를 생성하기 위해서는 반드시 Engine 객체를 전달해줘야 한다.
		Car c1=new Car(new Engine()); 
		//c1.engine = 참조불가
		c1.drive();
	}
}
