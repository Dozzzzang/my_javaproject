package test.mypac;

//추상메소드를 1개만 만들도록 강제하는 역할 (  ()->{} 형태로 사용한다)
@FunctionalInterface
public interface Joinner {
	public String join(String one, String two);
}
