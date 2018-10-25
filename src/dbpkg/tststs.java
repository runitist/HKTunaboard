package dbpkg;

public class tststs {
	//쿼리문을 시험해보기위한 클래스
	public static void main(String[] args) {
		System.out.println(MemberDAO.getMemberList().get(0).getJoindate());
	}

}
