<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Insert title here</title>
</head>
<body>
	<div class=" clearfix">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header noPadBtm">
					<h3 id="navbar">
						<span class="glyphicon glyphicon-list-alt marRight8"></span>{{title}}
						<a href="#dashboard"  tooltip-placement="bottom" uib-tooltip="back"
							class="glyphicon glyphicon-chevron-left floatRight cursorPointer"></a>
					</h3>
				</div>
			</div>
		</div>


		<div class="row">
			<div class="col-lg-12">
				<h2 id="type-blockquotes">{{orderStatus}}</h2>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="bs-component">
					<blockquote>
						<div ng-repeat="desc in orderStatusDesc">
							<p ng-if="desc.code == orderStatus">{{desc.desc}}</p>
						</div>
					</blockquote>
				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<h3 id="type-blockquotes">Orders</h3>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-8">
				<div class="bs-component" style="margin-bottom: 15px;">
					<div class="btn-group btn-group-justified mar10" ng-repeat="groups in grouppedOrders">
						<div ng-if="groups.length>1">
							<a href="#getOrder/{{order}}" class="btn btn-default col-lg-3 mar5"  ng-repeat="order in groups"><p>{{order}}</p></a>
						</div>
						<div ng-if="groups.length==1">
							<a href="#getOrder/{{groups[0]}}" class="btn btn-default col-lg-3 mar5"  ><p>{{groups[0]}}</p></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</div>

</body>
</html>