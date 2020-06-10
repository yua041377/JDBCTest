package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * db.properties 파일의 내용으로 DB정보를 설정하는 방법
 * 방법2) ResourceBundle 객체 이용하기
 * @author PC-15
 *
 */
public class DBUtil3 {
	static ResourceBundle bundle; //ResourceBundle 객체 변수 선언
	
	static {
		
		bundle = ResourceBundle.getBundle("db"); //객체 생성
		
		try {
			
			Class.forName(bundle.getString("driver"));
			
		}catch(ClassNotFoundException e) {
			
			System.out.println("드라이버 로딩 실패 !!!");
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
	try {	
		return DriverManager.getConnection(bundle.getString("url"),
										   bundle.getString("user"),
										   bundle.getString("pass"));
	}catch(SQLException e) {
		
		System.out.println("DB연결 실패 !!!!");
		e.printStackTrace();
		return null;
	}
}
