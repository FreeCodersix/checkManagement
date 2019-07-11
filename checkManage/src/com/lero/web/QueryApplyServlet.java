package com.lero.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lero.dao.BqpersonDao;
import com.lero.model.Bqperson;
import com.lero.util.DbUtil;

/**
 * Servlet implementation class QueryApplyServlet
 */
public class QueryApplyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	DbUtil dbUtil = new DbUtil();
	BqpersonDao bqpersonDao=new BqpersonDao();
	Connection con=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueryApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Bqperson> bqlist=null;
		try {
			con=dbUtil.getCon();
			bqlist=bqpersonDao.BqpersonList(con);
			for (Bqperson bqperson : bqlist) {
				System.out.println(bqperson.toString());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		request.setAttribute("bqlist", bqlist);
		request.setAttribute("mainPage", "absence/applyAdminPage.jsp");
		request.getRequestDispatcher("mainAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
