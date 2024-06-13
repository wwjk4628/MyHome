package himedia.myhome.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import himedia.myhome.dao.GuestBookDao;
import himedia.myhome.vo.GuestBookVo;

public class GuestBookDaoImple implements GuestBookDao {

	private String dbuser;
	private String dbpass;

	// 생성자
	public GuestBookDaoImple(String dbuser, String dbpass) {
		this.dbuser = dbuser;
		this.dbpass = dbpass;
	}

	// 데이터베이스 접속 정보 -> 컨텍스트 파라미터로부터 받아옴
	// Connection 공통 메서드
	private Connection getConnection() throws SQLException {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String dburl = "jdbc:oracle:thin:@localhost:1521:xe";

			conn = DriverManager.getConnection(dburl, dbuser, dbpass);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			System.err.println("JDBC 드라이버를 로드1하지 못했습니다.");
		}

		return conn;
	}

	@Override
	public List<GuestBookVo> getList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		try {
			//	connection
			conn = getConnection();
			//	statment 생성
			stmt = conn.createStatement();
			//		쿼리 전송
			String sql = "SELECT * FROM guestbook"; 
				//	결과 셋
			rs = stmt.executeQuery(sql);
				//	결과 셋 -> 자바 객체로 전환
			while (rs.next()) {
				//	Java 객체로 전환
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String pass = rs.getString("password");
				String content = rs.getString("content");
				Date createdAt = rs.getDate("reg_date");
				
				GuestBookVo vo = new GuestBookVo(no, name, pass, content, createdAt);
				list.add(vo);
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (stmt != null)
						stmt.close();
					if (conn != null)
						conn.close();
					if (rs != null)
						rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		
		return list;
	}

	@Override
	public boolean insert(GuestBookVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int insertCount = 0;
		try {
			conn = getConnection();
			String sql = "INSERT INTO guestbook (name, password, content) VALUES (?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPass());
			pstmt.setString(3, vo.getContent());
			
			insertCount = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return insertCount == 1;
	}

	@Override
	public boolean delete(String pass, Long no) {
		 Connection conn = null;
		    PreparedStatement pstmt = null;
		    int deleteCount = 0;
		    
		    try {
		        conn = getConnection();
		        String sql = "DELETE FROM guestbook WHERE no = ?";
		        // PreparedStatment
		        pstmt = conn.prepareStatement(sql);
		        // 데이터 바인딩
		        pstmt.setLong(1, no); // Long 타입으로 설정
		        deleteCount = pstmt.executeUpdate();
		    } catch(SQLException e) {
		        e.printStackTrace();
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (pstmt != null)
		                pstmt.close();
		            if (conn != null)
		                conn.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		    return deleteCount == 1;
		}

	@Override
	public GuestBookVo get(Long id) {
		GuestBookVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String sql = """
					SELECT no, name, password, content, reg_date
					FROM guestbook
					WHERE no = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Long no = rs.getLong("no");
				String name = rs.getString("name");
				String password = rs.getString("password");
				String content = rs.getString("content");
				Date regDate = rs.getDate("reg_date");
				
				vo = new GuestBookVo(no, name, password, content, regDate);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	

}