package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbpkg.DBConn;
import dbpkg.MemberDAO;
import dbpkg.MemberVO;

@WebServlet("/memberMod")
public class MemberModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public MemberModifyServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> lv = MemberDAO.getMemberList();
		int index = Integer.parseInt(request.getParameter("index"));
		MemberVO vo = lv.get(index);
		request.setAttribute("vo", vo);
		RequestDispatcher rd = request.getRequestDispatcher("memberMod.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int custno = Integer.parseInt(request.getParameter("custno"));
		String custname = request.getParameter("custname");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String joindate = request.getParameter("joindate");
		String grade = request.getParameter("grade");
		String city = request.getParameter("city");
		
		MemberDAO.updateMember(custno, custname, phone, address, joindate, grade, city);
		response.sendRedirect("memberSelect");
	}

}
