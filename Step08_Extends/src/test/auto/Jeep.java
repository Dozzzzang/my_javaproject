package test.auto;

public class Jeep extends Car{

	public Jeep(Engine engine) {
		super(engine);		
	}
	public void liftup() {
		System.out.println("차체를 올려요");
	}
	@Override
	public void drive() {
		System.out.println("산길을 달려요");
	}
}
