<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class=" clearfix">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header noPadBtm">
					<h3 id="navbar">
						<span class="glyphicon glyphicon-list-alt marRight8"></span>{{title}}
						<a href="#dashboard"
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
			<div class="col-lg-6">
				<div class="bs-component" style="margin-bottom: 15px;">
					<div class="btn-group btn-group-justified mar10">
						<a href="#getOrder/211468608" class="btn btn-default">211468608</a> 
						<a href="#getOrder/211468607" class="btn btn-default">211468607</a> 
						<a href="#getOrder/211468606" class="btn btn-default">211468606</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">12121456</a> 
						<a href="#" class="btn btn-default">56756755</a> 
						<a href="#" class="btn btn-default">56765776</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">56756734</a> 
						<a href="#" class="btn btn-default">56756756</a> 
						<a href="#" class="btn btn-default">56756765</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">1212112</a> 
						<a href="#" class="btn btn-default">2342349</a> 
						<a href="#" class="btn btn-default">3453453</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">12121456</a> 
						<a href="#" class="btn btn-default">56756755</a> 
						<a href="#" class="btn btn-default">56765776</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">56756734</a> 
						<a href="#" class="btn btn-default">56756756</a> 
						<a href="#" class="btn btn-default">56756765</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">1212112</a> 
						<a href="#" class="btn btn-default">2342349</a> 
						<a href="#" class="btn btn-default">3453453</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">12121456</a> 
						<a href="#" class="btn btn-default">56756755</a> 
						<a href="#" class="btn btn-default">56765776</a>
					</div>
					
					<div class="btn-group btn-group-justified mar10">
						<a href="#" class="btn btn-default">56756734</a> 
						<a href="#" class="btn btn-default">56756756</a> 
						<a href="#" class="btn btn-default">56756765</a>
					</div>
				</div>
			</div>
		</div>

	</div>

</body>
</html>