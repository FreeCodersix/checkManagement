<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
		<div class="data_list_title">
			补勤申请
		</div>
		
		<div>
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>学号</th>
					<th>申请时间</th>
					<th>缺勤日期</th>
					<th>缺勤原因</th>
					<th>补勤方式</th>
					<th width="15%">审核</th>
				</tr>
				<c:forEach  var="person" items="${bqlist}">
					<tr>
					<th>${person.num }</th>
					<th>${person.applyTime }</th>
					<th>${person.absenceTime }</th>
					<th>${person.reason }</th>
					<th>${person.bqstyle }</th>
					<th width="15%">
						<a href="dealapply?id=${person.num}&absencedata=${person.absenceTime }&deal=tg">通过</a>
						&nbsp&nbsp&nbsp&nbsp&nbsp
						<a href="dealapply?id=${person.num}&absencedata=${person.absenceTime }&deal=btg">不通过</a>
					</th>
				</tr>
				</c:forEach>
				
			</table>
		</div>
</div>