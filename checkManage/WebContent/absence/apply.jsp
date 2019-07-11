<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div>
	<form action="applyInsert" method="post">
			<div class="data_form" >
				<input type="hidden" id="studentId" name="studentId" value="${record.recordId }"/>
					<table align="center">
						<tr style="display: none">
							<td><font color="red">*</font>学生id：</td>
							<td><input type="text" id="userId"  name="userId" value="${record.recordId }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>学号：</td>
							<td><input type="text" id="userNum"  name="userNum" value="${record.studentNumber }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>姓名</td>
							<td><input type="text" id="username"  name="username" value="${record.studentName  }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>日期</td>
							<td><input type="text" id="datetime"  name="datetime" value="${record.date }"  style="margin-top:5px;height:30px;" /></td>
						</tr>
						<tr>
							<td><font color="red">*</font>缺勤原因：</td>
							<td><textarea name="reason" rows="4" cols="4"></textarea></td>
						</tr>
						<tr>
							<td><font color="red">*</font>补勤方式：</td>
							<td><input type="text" id="bqstyle"  name="bqstyle" value=""  style="margin-top:5px;height:30px;" /></td>
						</tr>
					
							
					</table>
					<div align="center">
						<input type="submit" class="btn btn-primary" value="提交"/>
						&nbsp;<button class="btn btn-primary" type="button" onclick="javascript:window.location='student'">返回</button>
					</div>
					<div align="center">
						<font id="error" color="red">${error }</font>
					</div>
			</div>
		</form>

</div>