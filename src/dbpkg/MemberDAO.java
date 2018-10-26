package dbpkg;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	// DB작업과 관련있는 클래스

	public static int getMaxCustNo() {
		// custno 맥스값을 갖고오는 메서드
		System.out.println("[getMaxCustNo 메서드 실행]");
		int custNo = 0;
		Connection conn = DBConn.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			String sql = "select nvl(max(custno), 100000) as maxno from member_tbl_02";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				custNo = rs.getInt("maxno");
			}
			System.out.println("custno 맥스값 갖고오기 성공 : " + custNo);
		} catch (Exception e) {
			System.out.println("custno 맥스값 갖고오기 실패");
			e.printStackTrace();
		} finally {
			DBConn.closeConn(rs, ps, conn);
		}
		System.out.println("[getMaxCustNo 메서드 종료]");
		return custNo;
	}

	public static List<MemberVO> getMemberList() {
		// 회원정보 리스트를 가져오는 메서드
		System.out.println("[getMemberList 메서드 실행]");
		List<MemberVO> lv = new ArrayList<MemberVO>();
		Connection conn = DBConn.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			String sql = "select custno, custname, phone, address, to_char(joindate, 'yyyy-mm-dd') as joindate, grade, city from member_tbl_02 order by custno";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				int custno = rs.getInt("custno");
				String custname = rs.getString("custname");
				String phone = rs.getString("phone");
				String address = rs.getString("address");
				String joindate = rs.getString("joindate");
				String grade = rs.getString("grade");
				String city = rs.getString("city");
				lv.add(new MemberVO(custno, custname, phone, address, joindate,
						grade, city));
			}
			System.out.println("멤버 리스트 갖고오기 성공");
		} catch (Exception e) {
			System.out.println("멤버 리스트 갖고오기 실패");
			e.printStackTrace();
		} finally {
			DBConn.closeConn(rs, ps, conn);
		}
		System.out.println("[getMemberList 메서드 종료]");
		return lv;
	}

	public static List<MemberSaleVO> getMemberSaleList() {
		System.out.println("[getMemberSaleList 메서드 실행]");
		List<MemberSaleVO> slv = new ArrayList<MemberSaleVO>();
		Connection conn = DBConn.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			String sql = "select mem.custno, mem.custname, mem.grade, SUM(mon.price) as totalprice from member_tbl_02 mem join money_tbl_02 mon on mem.custno=mon.custno group by mem.custno, mem.custname, mem.grade order by totalprice desc";

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int custno = rs.getInt(1);
				String custname = rs.getString(2);
				String grade = rs.getString(3);
				int totalprice = rs.getInt(4);
				slv.add(new MemberSaleVO(custno, custname, grade, totalprice));
			}
			System.out.println("멤버 세일 리스트 작성 성공");
		} catch (Exception e) {
			System.out.println("멤버 세일 리스트 작성 실패");
			e.printStackTrace();
		} finally {
			DBConn.closeConn(rs, ps, conn);
		}

		System.out.println("[getMemberSaleList 메서드 종료]");
		return slv;
	}

	public static void joinMember(int custno, String custname, String phone,
			String address, String joindate, String grade, String city) {
		System.out.println("[joinMember 메서드 실행]");
		Connection conn = DBConn.getConnection();
		PreparedStatement ps = null;
		
		try{
			String sql = "insert into member_tbl_02 values (?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, custno);
			ps.setString(2, custname);
			ps.setString(3, phone);
			ps.setString(4, address);
			ps.setString(5, joindate);
			ps.setString(6, grade);
			ps.setString(7, city);
			ps.execute();
			
		}catch(Exception e){
			System.out.println("멤버 가입 실패");
			e.printStackTrace();
		}finally{
			DBConn.closeConn(null, ps, conn);
		}

		System.out.println("[joinMember 메서드 종료]");
	}

}
