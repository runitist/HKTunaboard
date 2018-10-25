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
		//회원정보 리스트를 가져오는 메서드
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

}
