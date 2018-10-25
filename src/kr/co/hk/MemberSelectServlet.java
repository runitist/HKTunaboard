package kr.co.hk;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbpkg.MemberDAO;
import dbpkg.MemberVO;

@WebServlet("/memberSelect")
public class MemberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSelectServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<MemberVO> lv = MemberDAO.getMemberList();
		request.setAttribute("lv", lv);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberSelect.jsp");
		rd.forward(request, response);
	}

}
