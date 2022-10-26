package test.main;

import test.mypac.Bike;

public class MainClass08 {
	public static void main(String[] args) {
		String[] names= {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		//확장 for문 엄청 자주쓰임
		//확장 for문 예제
		for(String tmp:names) {
			System.out.println(tmp);
		}
		
		//확장 for문 예제2
		Bike[] bikes = new Bike[3];
		
		bikes[0] = new Bike();
		bikes[1] = new Bike();
		bikes[2] = new Bike();
		
		for(Bike bk:bikes) {
			bk.ride();
		}
	}

}
