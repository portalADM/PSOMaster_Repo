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

				<div class="bs-component">
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" ng-model="orderID" placeholder="Order Id">
						</div>
						<button type="submit" class="btn btn-default" ng-click="searchOrderDetails()">Submit</button>
					</form>

				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="bs-component">
					<h3>Order : {{portalOrderDetails.orderId}} 
					<a href="#updateOrder"><span tooltip-placement="bottom" uib-tooltip="Update Order" class="glyphicon glyphicon-edit floatRight panelHeaderIcon marRight50" aria-hidden="true"></span></a>  
					<a href="#sendEmail"><span tooltip-placement="bottom" uib-tooltip="Send Email" class="glyphicon glyphicon-envelope floatRight panelHeaderIcon" aria-hidden="true"></a></span>
					</h3> 
				</div>
			</div>
		</div>
		 

		<div class="bs-docs-section">
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
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">SIM :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.portalShipmentInfo[1].sim}} </label>
										</div>
									</div>
								</div>
								
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">IMEI :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.portalShipmentInfo[0].imei}} </label>
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
			                    <th>#</th>
			                    <th>Order ID</th>
			                    <th>Error Message</th>
			                    <th>Source</th>
			                    <th>API Name</th>
			                    <th>Creation Date</th>
			                   <!--  <th>Originator ID</th> -->
			                  </tr>
			                </thead>
			                <tbody>
			                  <tr>
			                    <td>1</td>
			                    <td>211467901</td>
			                    <td>null</td>
			                    <td>Brightpoint</td>
			                    <td>OrderSubmissionService</td>
			                    <td>2016-06-28 04:47:29.22</td>
			                   <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>2</td>
			                    <td>211467901</td>
			                    <td>Success:AccountId:558830028;Device Amount:53.49;Plan Amount:50.0;Amount on CC:103.49000000000001;zig~CNG-CSI~102255bc-858d-4560-a2f2-177a1b8b5eb2</td>
			                    <td>CSI</td>
			                    <td>AddWirelinePaymentService</td>
			                    <td>2016-06-28 04:47:26.14</td>
			                   <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>3</td>
			                    <td>211467901</td>
			                    <td>Success:CnvId:zig~CNG-CSI~102255bc-858d-4560-a2f2-177a1b8b5eb2 PreAuth:NDOATG160628438775Amt:103.49</td>
			                    <td>CSI</td>
			                     <td>ValidateCreditCardService</td>
			                    <td>2016-06-28 04:40:45.774</td>
			                    <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                 <tr>
			                    <td>4</td>
			                    <td>211467901</td>
			                    <td>Success</td>
			                    <td>CSM</td>
			                     <td>CalculateServiceTaxService</td>
			                    <td>2016-06-28 04:40:30.111</td>
			                    <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>5</td>
			                    <td>211467901</td>
			                    <td>Success</td>
			                    <td>CSM</td>
			                    <td>CalculateTaxV2Service</td>
			                    <td>2016-06-28 04:40:29.467</td>
			                    <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>6</td>
			                    <td>211467901</td>
			                    <td>Success:558830028;8083398478;48202000002</td>
			                    <td>CSM</td>
			                    <td>SubscriberCreationService</td>
			                    <td>2016-06-28 04:40:29.152</td>
			                   <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                 <tr>
			                    <td>7</td>
			                    <td>211467901</td>
			                    <td>Success:CnvId:zig~CNG-CSI~3212e220-6adb-4e12-8e41-ac2c2d8035b7</td>
			                    <td>CSI</td>
			                    <td>AddPaymentProfileService</td>
			                    <td>2016-06-28 04:40:09.968</td>
			                    <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>8</td>
			                    <td>211467901</td>
			                    <td>Success:558830028;84</td>
			                    <td>CSM</td>
			                    <td>ZigCSMCreateBANService</td>
			                    <td>2016-06-28 04:39:48.665</td>
			                  <!--  <td>atllvatapp12</td> -->
			                  </tr>
			                  <tr>
			                    <td>9</td>
			                    <td>211467901</td>
			                    <td>Success</td>
			                    <td>CSM</td>
			                    <td>ValidateAddressService</td>
			                    <td>2016-06-28 04:39:47.83</td>
			                 <!--  <td>atllvatapp12</td> -->
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