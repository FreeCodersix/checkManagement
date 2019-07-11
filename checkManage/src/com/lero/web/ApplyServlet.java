package com.lero.web;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lero.dao.RecordDao;
import com.lero.model.Record;
import com.lero.util.DbUtil;

/**
 * Servlet implementation class ApplyServlet
 */
public class ApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	Connection con = null;
	DbUtil dbUtil = new DbUtil();
	RecordDao recordDao = new RecordDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		System.out.println("id:"+id);
		try {
			con=dbUtil.getCon();
			Record record=recordDao.recordShow(con, id);
			System.out.println(record.toString());
			request.setAttribute("record", record);
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
		request.setAttribute("mainPage", "absence/apply.jsp");
		request.getRequestDispatcher("mainStudent.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
