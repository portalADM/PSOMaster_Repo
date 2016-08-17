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
						<span class="glyphicon glyphicon-shopping-cart marRight8"></span>{{title}}
					</h3>
				</div>

					<flash-message></flash-message> 
				
				<div class="bs-component">
					<form class="navbar-form navbar-left noPad" role="search">
						<div class="form-group">
							<input type="text" class="form-control" ng-model="orderID" placeholder="Order Id">
						</div>
						<button type="submit" class="btn btn-default" ng-click="searchOrderDetails()">Submit</button>
					</form>
					<div class="bs-component">
						<h3>
							<a  ng-href="{{orderID.length>0 ? '#updateOrder/'+orderID : '#updateOrder'}}" ><span tooltip-placement="bottom" uib-tooltip="Update Order" class="glyphicon glyphicon-edit floatRight panelHeaderIcon marRight50" aria-hidden="true"></span></a>  
							<a href="#sendEmail"><span tooltip-placement="bottom" uib-tooltip="Send Email" class="glyphicon glyphicon-envelope floatRight panelHeaderIcon" aria-hidden="true"></a></span>
						</h3> 
					</div>

				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="bs-component">
					<h3 ng-show="portalOrderDetails.orderId.length>0">Order : {{portalOrderDetails.orderId}}</h3>
				</div>
			</div>
		</div>
		 

		<div class="bs-docs-section"  ng-show="portalOrderDetails.orderId.length>0" >
			<!-- <div class="row">
				<div class="col-lg-12">
					<div class="page-header">
						<h3 id="forms">Order Details</h3>
					</div>
				</div>
			</div> -->

			<div class="row">
				<div class="col-lg-6">
					<div class="well bs-component">
						<form class="form-horizontal">
							<fieldset>
								<legend>Portal Order Details</legend>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Order ID :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.orderId}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Order Type :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.orderType}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Status Code :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.status}}  </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Retry Count :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label>{{portalOrderDetails.retry}}</label>
										</div>
									</div>
								</div>
								
							<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Originator ID :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label>{{portalOrderDetails.originatorId}}</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Order Created Date :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label>{{portalOrderDetails.sys_creation_date}}</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Last update Date :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label>{{portalOrderDetails.sys_update_date}}</label>
										</div>
									</div>
								</div>
								
								
							</fieldset>
						</form>
					</div>
				</div>
				
				
				<!-- RIGHT -->
				
				<div class="col-lg-6">
					<div class="well bs-component">
						<form class="form-horizontal">
							<fieldset>
								<legend>Ensemble Order Details</legend>
								
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Order ID :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.ensOrderId}} </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Order Status :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.orderStatus}} </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">BAN :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.ban}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">PTN :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.ptn}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">PTN Status :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.ptnStatus}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">APPLICATION :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.applicationId}} </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">SYS Creation Date :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.sys_creation_date}} </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">SYS Update Date :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{ensembleOrderDetails.sys_update_date}} </label>
										</div>
									</div>
								</div>
								
								
									
								
							</fieldset>
						</form>
						
					</div>
				</div>
				
				<!-- RIGHT END -->
				
			</div>
			
			
			 <div class="row">
			<div class="col-lg-6">
							<div class="well bs-component">
								<form class="form-horizontal">
										<fieldset>
											<legend>User Details</legend>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">First Name :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.enrollInfo.first_name}} </label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">Last Name:</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.enrollInfo.last_name}} </label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">Email Id :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.enrollInfo.email}} </label>
													</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">Phone Number :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.enrollInfo.phone_number}} </label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">Address :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label>{{portalOrderDetails.enrollInfo.address1}} {{portalOrderDetails.enrollInfo.address2}}, {{portalOrderDetails.enrollInfo.city}}, {{portalOrderDetails.enrollInfo.state}}</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">ZIP :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.enrollInfo.zip_code}} </label>
													</div>
												</div>
											</div>
											
											
										</fieldset>
									</form>
							</div>	
						</div>
						<!-- RIGHT -->
			             <div class="col-lg-6">
							<div class="well bs-component">
								<form class="form-horizontal">
										<fieldset>
											<legend>Shipment Details</legend>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">SIM :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label>{{portalOrderDetails.portalShipmentInfo.sim}} </label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">IMEI :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.portalShipmentInfo.imei}}</label>
													</div>
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">EPC Sku ID :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label>{{portalOrderDetails.portalShipmentInfo.epc_sku_id}}</label>
													</div>
												</div>
											</div>
											
											<div class="form-group">
												<label class="col-lg-6 control-label textAignLeft">Plan :</label>
												<div class="col-lg-6">
													<div class="radio">
														<label> {{portalOrderDetails.portalShipmentInfo.plan}}</label>
													</div>
												</div>
											</div>
											<div class="form-group" ng-show="portalOrderDetails.portalShipmentInfo.accessoryAvailable">
												<label class="col-lg-6 control-label textAignLeft">Accessories</label>
												<div class="col-lg-6">
													<div class="radio" ng-repeat="acc in portalOrderDetails.portalShipmentInfo.accessoryList">
														<label>{{acc}}</label>
													</div>
												</div>
											</div>
											<div class="form-group" ng-show="portalOrderDetails.portalShipmentInfo.addonAvailable">
												<label class="col-lg-6 control-label textAignLeft">AddOns :</label>
												<div class="col-lg-6">
													<div class="radio" ng-repeat="addon in portalOrderDetails.portalShipmentInfo.addonList">
														<label> {{addon}} </label>
													</div>
												</div>
											</div>
											
											
										</fieldset>
									</form>
							</div>	
						</div>
						<!-- RIGHT END -->
			</div>
			
				
		
			
			
			<div class="panel panel-info">
                <div class="panel-heading">
                  <h3 class="panel-title">API Details</h3>
                </div>
                <div class="panel-body">
                  		<div class="bs-component">
			              <table class="table table-striped table-hover ">
			                <thead>
			                  <tr>
			                  <th>Source</th>
			                    <th>Error Message</th>
			                    <th>API Name</th>
			                    <th>Creation Date</th>
			                   <th>Originator ID</th>
			                  </tr>
			                </thead>
			                <tbody>
			                  <tr ng-repeat=" api in apiOrderDetails">
			                  <td>{{api.source}}</td>
			                    <td>{{api.errorMessage}}</td>
			                    <td>{{api.apiname}}</td>
			                    <td>{{api.sysCreationDate}}</td>
			                   <td>{{api.originatorID}}</td>
			                  </tr>
			               
			                </tbody>
			              </table> 
			            </div><!-- /example -->
                </div>
              </div>
			
		</div>

	</div>

</body>
</html>
