package com.lero.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lero.dao.BqpersonDao;
import com.lero.dao.RecordDao;
import com.lero.util.DbUtil;

/**
 * Servlet implementation class DealApplyServlet
 */
public class DealApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con = null;
	DbUtil dbUtil = new DbUtil();
	BqpersonDao bqpersonDao=new BqpersonDao();
	RecordDao recordDao=new RecordDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DealApplyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("id");
		String absencetime=request.getParameter("absencedata");
		String result=request.getParameter("deal");
		System.out.println(num);
		System.out.println(absencetime);
		System.out.println(result);
		String state="待审核";
		int i=0,j=0;
		if(result.equals("tg")) {
			state="通过";
			try {
				con=dbUtil.getCon();
				i=bqpersonDao.updateBqperson(con, num, state,absencetime);
				j=recordDao.recordDeleteByNumAndDate(con, num, absencetime);
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
		}
		if(result.equals("btg")) {
			state="不通过";
			try {
				con=dbUtil.getCon();
				i=bqpersonDao.updateBqperson(con, num, state,absencetime);
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
		}
		request.getRequestDispatcher("/queryapply").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
