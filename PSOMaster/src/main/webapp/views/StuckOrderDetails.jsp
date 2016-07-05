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




	<div id="updateOrder-modal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title">Update Order Status</h4>
				</div>
				<div class="modal-body">
					<div class="well" id="">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-lg-4 control-label textAlgnInit">Order</label>
								<div class="col-lg-8">
									<label class="col-lg-12 control-label textAlgnInit">25636589</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-4 control-label textAlgnInit">Current Status</label>
								<div class="col-lg-8">
									<label class="col-lg-12 control-label textAlgnInit">ORFI</label>
								</div>
							</div>
							<div class="form-group">
								<label for="select" class="col-lg-4 control-label textAlgnInit">New
									Status</label>
								<div class="col-lg-8">
									<select class="form-control" id="select">
										<option value="OPEN">OPEN</option>
										<option value="PDRS">PDRS</option>
										<option value="ACTI">ACTI</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-4"></div>
			                    <div class="col-lg-8">
			                      <button type="reset" class="btn btn-default">Cancel</button>
			                      <button type="submit" class="btn btn-primary">Submit</button>
			                    </div>
			                  </div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



</body>
</html>