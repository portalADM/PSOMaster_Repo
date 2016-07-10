<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Order</title>
</head>
<body>
	<div class=" clearfix">
		<div class="row">
			<div class="col-lg-12">
				<div class="page-header noPadBtm">
					<h3 id="navbar">
						<span class="glyphicon glyphicon-edit marRight8"></span>{{title}}
						<a href="#orderMaster" tooltip-placement="bottom" uib-tooltip="back"
							class="glyphicon glyphicon-chevron-left floatRight cursorPointer"></a>
					</h3>
				</div>
			</div>
		</div>
	
	
		<div ng-init="accordion=0">

			<!-- Update Order Status Panel Start -->
			<div class="panel panel-primary ">
				<div class="panel-heading accordion cursorPointer" ng-class="{active:accordion==1}">
					<h3 class="panel-title" ng-click="accordion = 1" >Update Order Status
					</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==1">
					<div class="">
						<div class="">
							<div class="well" id="">
								<form class="form-horizontal">
									<div class="form-group">
										<label class="col-lg-4 control-label textAlgnInit">Order</label>
										<div class="col-lg-8">
											<label class="col-lg-12 control-label textAlgnInit noPadLeft">25636589</label>
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-4 control-label textAlgnInit">Current
											Status</label>
										<div class="col-lg-8 noPadLeft">
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
											<button type="reset" class="btn btn-default">Submit</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Update Order Status Panel End -->
			
			<!-- Update Order SIM Panel Start -->
			<div class="panel panel-primary">
				<div class="panel-heading accordion cursorPointer" ng-click="accordion = 2" ng-class="{active:accordion==2}">
					<h3 class="panel-title">Update Order SIM</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==2">
					<div class="">
                           <div class="">
                                  <div class="well" id="">
                                         <form class="form-horizontal">
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-8 noPadLeft">
                                                              <label class="col-lg-12 control-label textAlgnInit noPadLeft">25636589</label>
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <label for="select" class="col-lg-4 control-label textAlgnInit">New
                                                              SIM</label>
                                                            <input type="text" class="form-control" id="inputEmail" placeholder="SIM">
                                                </div>
                                                <div class="form-group">
                                                       <div class="col-lg-4"></div>
                                         <div class="col-lg-8 noPadLeft">
                                           <button type="reset" class="btn btn-default">Submit</button>
                                         </div>
                                       </div>
                                         </form>
                                  </div>
                           </div>
                     </div>	
				</div>
			</div>
			<!-- Update Order SIM Panel End -->
			
			<!-- Update Order IMEI Panel Start -->
			<div class="panel panel-primary">
				<div class="panel-heading accordion cursorPointer" ng-click="accordion = 3" ng-class="{active:accordion==3}">
					<h3 class="panel-title">Update Order IMEI</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==3">
					 <div class="">
                           <div class="">
                                  <div class="well" id="">
                                         <form class="form-horizontal">
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-8 noPadLeft">
                                                              <label class="col-lg-12 control-label textAlgnInit noPadLeft">25636589</label>
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <label for="select" class="col-lg-4 control-label textAlgnInit">New
                                                              IMEI</label>
                                                            <input type="text" class="form-control" id="inputEmail" placeholder="IMEI">
                                                </div>
                                                <div class="form-group">
                                                       <div class="col-lg-4"></div>
                                         <div class="col-lg-8 noPadLeft">
                                           <button type="reset" class="btn btn-default">Submit</button>
                                         </div>
                                       </div>
                                         </form>
                                  </div>
                           </div>
                     </div>
				</div>
			</div>
			<!-- Update Order IMEI Panel Start -->
			
			
			<!-- Update Order RetryCount Panel Start -->
			<div class="panel panel-primary">
				<div class="panel-heading accordion cursorPointer" ng-click="accordion = 4" ng-class="{active:accordion==4}">
					<h3 class="panel-title">Update Order RetryCount</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==4">
					 <div class="">
                           <div class="">
                                  <div class="well" id="">
                                         <form class="form-horizontal">
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-8 noPadLeft">
                                                              <label class="col-lg-12 control-label textAlgnInit ">25636589</label>
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <label for="select" class="col-lg-4 control-label textAlgnInit">Set
                                                              Retry Count</label>
                                                       <div class="col-lg-8">
                                                       <input type="number" class="form-control" id="inputEmail" placeholder="count">
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <div class="col-lg-4"></div>
                                         <div class="col-lg-8">
                                           <button type="reset" class="btn btn-default">Submit</button>
                                         </div>
                                       </div>
                                         </form>
                                  </div>
                           </div>
                     </div>
				</div>
			</div>
			<!-- Update Order RetryCount Panel Start -->
			
		</div>

	</div>
	
	
	
</body>
</html>