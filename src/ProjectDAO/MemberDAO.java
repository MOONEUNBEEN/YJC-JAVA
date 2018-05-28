package ProjectDAO;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*	★★★★★★★★★ 데이터베이스와 테이블 생성 sql ★★★★★★★★★★
 * 
 * drop database memo;
 * 
 * create database memo;
 * 
 * use memo;
 * 
 * create table member (
 * 	id varchar(50),
 *  pw varchar(50),
 *  name varchar(50)
 * );
 * */

public class MemberDAO {
	Connection con = null;
	
	public void getConnection() throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		
		String url = "jdbc:mariadb://localhost:3306/memo";
		String name = "root";
		String pw = "0819";
		
		con = DriverManager.getConnection(url, name, pw);
	}
	
	// 회원 등록
	public void insertMember(Member m) {
		try {
			getConnection();
			
			String sql = "insert into member values (?, ?, ?)";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPw());
			pstmt.setString(3, m.getName());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ignore) {
				
			}
		}
	}
	
	// 로그인
	public boolean loginMember(String id, String pw) throws Exception {
		try {
			getConnection();
			
			String sql = "select * from member where id = '" + id + "' AND pw = '" + pw + "'";

			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			Member m = new Member();
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String upw = rs.getString(2);
				
				if (upw.equals(pw)) {
					return true;
				}
				else {
					return false;
				}
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch(Exception ignore) {
				
			}
		}
		return false;
	}

}
