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
import dbpkg.MemberSaleVO;

@WebServlet("/memberSales")
public class MemberSalesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberSalesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberSaleVO> slv = MemberDAO.getMemberSaleList();
		
		request.setAttribute("slv", slv);
		
		RequestDispatcher rd = request.getRequestDispatcher("memberSales.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
