package com.lero.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lero.dao.BqpersonDao;
import com.lero.model.Bqperson;
import com.lero.util.DbUtil;

/**
 * Servlet implementation class ApplyInsert
 */
public class ApplyInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection con = null;
	DbUtil dbUtil = new DbUtil();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplyInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("userId");
		String reason= request.getParameter("reason");
		String bqstyle= request.getParameter("bqstyle");
		String userNum= request.getParameter("userNum");
		String absencetime= request.getParameter("datetime");
		
		
		System.out.println(reason);
		System.out.println(bqstyle);
		System.out.println(userNum);
		String state ="待处理";
		Date date=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String datestr=sf.format(date);
		Bqperson bqperson=new Bqperson(userNum, bqstyle, state, absencetime, reason,datestr);
		System.out.println("bqperson:"+bqperson.toString());
		BqpersonDao bqpersonDao=new BqpersonDao();
		int i=0;
		try {
			con=dbUtil.getCon();
			i=bqpersonDao.bqpersonAdd(con, bqperson);
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
		if(i>0) {
			request.getRequestDispatcher("/record").forward(request, response);
		}else {
			//request.getRequestDispatcher("/record").forward(request, response);
		}
		
		
	}

}
