<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="data_list">
		<div class="data_list_title">
			补勤申请结果
		</div>
		
		<div>
			<table class="table table-hover table-striped table-bordered">
				<tr>
					<th>学号</th>
					<th>缺勤时间</th>
					<th>缺勤原因</th>
					<th>补勤方式</th>
					<th width="15%">审核结果</th>
				</tr>
				<c:forEach  var="person" items="${bqpersonlist}">
					<tr>
					<th>${person.num }</th>
					<th>${person.absenceTime }</th>
					<th>${person.reason }</th>
					<th>${person.bqstyle }</th>
					<th>${person.state }</th>
				
				</tr>
				</c:forEach>
				
			</table>
		</div>
</div>