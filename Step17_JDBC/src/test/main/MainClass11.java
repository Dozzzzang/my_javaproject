package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass11 {
	public static void main(String[] args) {
		//삭제할 회원의 번호라고 하자
		int num=4;
		delete(num);
	}
	
	//인자로 전달한 번호에 해당하는 회원 한명의 정보를 삭제하는 메소드
	public static void delete(int num) {
		//delete 작업을 위해서 필요한 객체의 참조값을 담을 지역변수 미리 만들기
	    Connection conn=null;
	    PreparedStatement pstmt=null;	    
	    try {
	    	//Connection 객체의 참조값 얻어오기
	    	conn=new DBConnect().getConn();
	    	//실행할 sql 문
	    	String sql="DELETE FROM member"
	    			+ " WHERE num = ?";
	    	//PreparedStatement 객체의 참조값 얻어오기
	    	pstmt=conn.prepareStatement(sql);
	    	// ? 에 값을 바인딩해서 미완성의 sql 문을 완성 시킨다. set(?순서, 내용) 형식
	    	pstmt.setInt(1, num);
	    		    	
	    	//sql 문 실행하기
	    	pstmt.executeUpdate();
	    	System.out.println("회원 정보를 삭제했습니다.");
	    	
	    }catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();				
			}catch(Exception e) {}
		}
	}
}
