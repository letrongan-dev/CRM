<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<section id="admin-content" class="p-3">
	<div class="row">
		<div class="col-md-6">
			<canvas id="myChart" width="400" height="400"></canvas>
		</div>
		<div class="col-md-6">
			<canvas id="myChart2" width="400" height="400"></canvas>
		</div>
		<div class="col-md-1"></div>
	</div>
</section>

<content tag="scripts">
	<script src='<c:url value="/static/js/chart.min.js" />'></script>
	<script src='<c:url value="/static/js/custom-chart.js" />'></script>
</content>