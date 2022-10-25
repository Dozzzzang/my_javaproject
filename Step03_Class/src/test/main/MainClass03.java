package test.main;

import test.mypac.Member;

/*
 * 1. 한명의 회원 정보를 담을수 있는 객체를 생성할 Member 클래스를 test.mypac 패키지에 만들어 보세요.
 * 
 * 회원 한명의 정보는 번호, 이름, 주소로 이루어져 있다. 
 * 따라서 3개의 필드를 적당한 데이터 type 을 선언해서 만들어야 한다.
 */

public class MainClass03 {
	public static void main(String[] args) {
		//2. Member 클래스로 객체를 생성해서(new Member()) 참조값을 m1 이라는 지역 변수에 담아보세요.
		Member m1 = new Member();		
		//3. m1 에 담긴 참조값을 이용해서 1, 김구라, 노량진 이라는 정보를 객체에 저장해 보세요.
		m1.num = 1;
		m1.name = "김구라";
		m1.addr = "노량진";		
		System.out.println("번호:"+m1.num+", 이름:"+m1.name+", 주소:"+m1.addr);
	}

}
