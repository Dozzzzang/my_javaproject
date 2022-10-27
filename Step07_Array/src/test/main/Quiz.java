package test.main;

import java.util.Random;

public class Quiz {
	public static void main(String[] args) {
		/*
		 * 1.run 했을때
		 *   cherry,apple,banana,melon,7
		 *   5개의 문자열 중에서 1개가 랜덤하게 출력되게 해보세요.
		 *   
		 * - hint
		 * 
		 * String[] items={"cherry", "apple", "banana", "melon", "7"};
		 * Random ran=new Random();
		 * int ranNum=ran.nextInt(5);
		 */
		String[] items={"cherry", "apple", "banana", "melon", "7"};
		// 랜덤한 숫자를 얻어내기 위한 객체
		Random ran=new Random();
		// 0~4 사이의 랜덤한 숫자를 하나 얻어내기
		int ranNum=ran.nextInt(5);
		// 배열의 이덱스로 활용해서 문자열 출력하기
		System.out.println(items[ranNum]);
		
		/*
		 * 2.run 했을때
		 * 5개의 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해보세요.
		 * 예) cherry | apple | cherry
		 *    7 | apple | melon
		 */
		int rn1=ran.nextInt(5);
		int rn2=ran.nextInt(5);
		int rn3=ran.nextInt(5);
		System.out.println(items[rn1]+" | "+items[rn2]+" | "+items[rn3]);
		
		boolean result = rn1==rn2 && rn1==rn3;
		String result2 = result ? "잭팟입니다" : "꽝입니다";
		System.out.println(result2);
		
	}
}
