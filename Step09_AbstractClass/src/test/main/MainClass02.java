package test.main;

import test.mypac.Gun;
import test.mypac.Weapon;
import test.mypac.Wp;

public class MainClass02 {
	//run 했을때 실행의 흐름이 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		//동일 클래스 안에 있는 static 메소드 호출가능
		test("안녕!!");
		//직접 클래스를 만들고 객체 생성을 해서 아래의 useWeapon() 메소드를 호출해보세요.
		Weapon w1=new Wp();
		useWeapon(w1);
		Weapon w2=new Gun();
		useWeapon(w2);
	}
	
	public static void test(String msg) {
		System.out.println(msg);
	}
	//Weapon type 을 인자로 전달받아서 사용하는 static 메소드
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
