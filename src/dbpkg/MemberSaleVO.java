package dbpkg;

public class MemberSaleVO {
	private int custno;
	private String custname;
	private String grade;
	private int totalprice;

	public MemberSaleVO() {

	}

	public MemberSaleVO(int custno, String custname, String grade, int totalprice) {
		setCustno(custno);
		setCustname(custname);
		setGrade(grade);
		setTotalprice(totalprice);
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

}
