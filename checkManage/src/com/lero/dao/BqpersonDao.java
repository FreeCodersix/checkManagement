package com.lero.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.lero.model.Bqperson;
import com.lero.model.DormBuild;
import com.lero.model.Record;

public class BqpersonDao {
	
	//添加
	public int bqpersonAdd(Connection con, Bqperson bqperson)throws Exception {
		String sql = "insert into t_bq(num,bqstyle,state,absenceTime,reason,applyTime) values(?,?,?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, bqperson.getNum());
		pstmt.setString(2, bqperson.getBqstyle());
		pstmt.setString(3, bqperson.getState());
		pstmt.setString(4, bqperson.getAbsenceTime());
		pstmt.setString(5, bqperson.getReason());
		pstmt.setString(6, bqperson.getApplyTime());
		return pstmt.executeUpdate();
	}
	
	//查询
//num     bqstyle  state      absenceTime          reason 
	public List<Bqperson> BqpersonList(Connection con)throws Exception {
		List<Bqperson> BqpersonList = new ArrayList<Bqperson>();
		String sql = "select * from t_bq where state=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, "待处理");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Bqperson person=new Bqperson();
			person.setId(rs.getInt("id"));
			person.setNum(rs.getString("num"));
			person.setBqstyle(rs.getString("bqstyle"));
			person.setAbsenceTime(rs.getString("absenceTime"));
			person.setState(rs.getString("state"));
			person.setReason(rs.getString("reason"));
			person.setApplyTime(rs.getString("applyTime"));
			BqpersonList.add(person);
		}
		return BqpersonList;
	}
	/**
	 * 
	 * @param con
	 * @return单个查询
	 * @throws Exception
	 */
	public List<Bqperson> BqpersonOne(Connection con,String num)throws Exception {
		List<Bqperson> BqpersonList = new ArrayList<Bqperson>();
		String sql = "select * from t_bq where num=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, num);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Bqperson person=new Bqperson();
			person.setId(rs.getInt("id"));
			person.setNum(rs.getString("num"));
			person.setBqstyle(rs.getString("bqstyle"));
			person.setAbsenceTime(rs.getString("absenceTime"));
			person.setState(rs.getString("state"));
			person.setReason(rs.getString("reason"));
			BqpersonList.add(person);
		}
		return BqpersonList;
	}
	/**
	 * 
	 * @param con
	 * @param id
	 * @return 管理员修改
	 * @throws Exception
	 */
	public int updateBqperson(Connection con,String num,String state,String date)throws Exception {
		Bqperson person=null;
		String sql = "update t_bq set state=? where num=? and absenceTime=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, state);
		pstmt.setString(2, num);
		pstmt.setString(3, date);
		return pstmt.executeUpdate();
	}
	

}
