package com.lero.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lero.dao.BqpersonDao;
import com.lero.dao.RecordDao;
import com.lero.model.Bqperson;
import com.lero.model.Student;
import com.lero.util.DbUtil;

/**
 * Servlet implementation class ResultServlet
 */
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DbUtil dbUtil = new DbUtil();
	RecordDao recordDao = new RecordDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Bqperson bqperson=null;
		HttpSession session=request.getSession();
		Student student=(Student) session.getAttribute("currentUser");
		List<Bqperson> bqpersonlist=null;
		System.out.println(student);
		try {
			Connection con=dbUtil.getCon();
			BqpersonDao  bqpersonDao=new BqpersonDao();
			bqpersonlist=bqpersonDao.BqpersonOne(con, student.getStuNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("bqpersonlist", bqpersonlist);
		request.setAttribute("mainPage", "absence/applyResult.jsp");
		request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
