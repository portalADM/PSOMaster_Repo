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
					</h3>
				</div>
			</div>
		</div>
	
	
	
		<div class="row">
			<div class="col-lg-4">
				<div class=" noPadBtm">
					<div class="bs-component">
						<form class="form-horizontal">
							<fieldset>
								<div class="form-group">
									<div class="col-lg-12">
										<div class="radio">
											<p><a class="btn btn-primary btn-lg col-lg-12" ng-click="updateOrderPopup()">Update Order Status</a></p>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-lg-12">
										<div class="radio">
										<p><a class="btn btn-primary btn-lg col-lg-12" ng-click="updateSimModal()">Update Order SIM</a></p>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-lg-12">
										<div class="radio">
										<p><a class="btn btn-primary btn-lg col-lg-12" ng-click="updateImeiModal()">Update Order IMEI</a></p>
										</div>
									</div>
								</div>
								<div class="form-group">
									<div class="col-lg-12">
										<div class="radio">
										<p><a class="btn btn-primary btn-lg col-lg-12" ng-click="updateRetryModal()">Update Order RetryCount</a></p>
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	
	
	
	
	<!-- UPDATE ORDER POPUP START -->
	
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
                                                              <label class="col-lg-12 control-label textAlgnInit noPadLeft">25636589</label>
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Current Status</label>
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
	
	
	<!-- UPDATE ORDER POPUP END -->
	
	
	<!-- UPDATE SIM POPUP START -->
	
	<div id="updateSim-modal" class="modal fade">
              <div class="modal-dialog">
                     <div class="modal-content">
                           <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h4 class="modal-title">Update SIM </h4>
                           </div>
                           <div class="modal-body">
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
	
	
	<!-- UPDATE SIM POPUP END -->
	
<!-- UPDATE IMEI POPUP START -->
	
	<div id="updateImei-modal" class="modal fade">
              <div class="modal-dialog">
                     <div class="modal-content">
                           <div class="modal-header">
                                  <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                  <h4 class="modal-title">Update IMEI </h4>
                           </div>
                           <div class="modal-body">
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
	
	<!-- UPDATE SIM POPUP END -->
	
	<!-- UPDATE RETRY POPUP START -->
	
	<div id="updateRetry-modal" class="modal fade">
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
	
	
	<!-- UPDATE RETRY POPUP END -->
	
</body>
</html>