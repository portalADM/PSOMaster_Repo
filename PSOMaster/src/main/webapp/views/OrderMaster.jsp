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
							<a permission="['ADMINISTRATOR','REMIDIATOR']" ng-href="{{orderID.length>0 ? '#updateOrder/'+orderID : '#updateOrder'}}">
								<span tooltip-placement="bottom" uib-tooltip="Update Order" class="glyphicon glyphicon-edit floatRight panelHeaderIcon marRight50" aria-hidden="true"></span>
								</a> 
								<!-- <a href="#sendEmail"><span tooltip-placement="bottom" uib-tooltip="Send Email" class="glyphicon glyphicon-envelope floatRight panelHeaderIcon" aria-hidden="true"></a>
								</span>  -->
								<a class="cursorPointer" ng-click="getHelp()"><span tooltip-placement="bottom" uib-tooltip="Help" class="glyphicon glyphicon-info-sign floatRight panelHeaderIcon" aria-hidden="true"></span></a>
								
								<a class="cursorPointer" ng-click="getInventory()"><span tooltip-placement="bottom" uib-tooltip="Check Inventory" class="glyphicon glyphicon glyphicon-search floatRight panelHeaderIcon" aria-hidden="true"></span></a>
								
								<a class="cursorPointer" ng-click="getName()"><span tooltip-placement="bottom" uib-tooltip="Check Name using SIM/IMEI" class="glyphicon glyphicon-modal-window floatRight panelHeaderIcon" aria-hidden="true"></span></a>
								
						</h3>
					</div>

				</div>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-12">
				<div class="bs-component">
					<h3 ng-show="portalOrderDetails.orderId.length>0">Order :
						{{portalOrderDetails.orderId}}</h3>
				</div>
			</div>
		</div>



		<div class="bs-docs-section"
			ng-show="portalOrderDetails.orderId.length>0">
			<div class="row">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Order Details</h3>
					</div>
					<div class="panel-body">
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
													<label> {{portalOrderDetails.status}} </label>
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
					</div>
				</div>
			</div>


		<!-- ORDER LINE ITEM DETAILS PANEL START -->

			<div class="row">
				<div class="panel panel-success">
					<div class="panel-heading">
						<h3 class="panel-title">Order Line Items</h3>
					</div>
					<div class="panel-body">
						<div class="col-lg-12">
							<div class="page-header">
								<h3 id="progress">Portal Subscribers and Lines <span ng-click="getPortStatus()" class="glyphicon glyphicon-exclamation-sign floatRight cursorPointer panelHeaderIcon" tooltip-placement="bottom" uib-tooltip="Get Port Status" aria-hidden="true"></span></h3>
							</div>
							<div class="bs-component">
								<table class="table table-striped table-hover ">
									<thead>
										<tr>
											<th></th>
											<th>LINE ID</th>
											<th>SUBSCRIBER ID</th>
											<th>PTN</th>
											<th>LINE TYPE</th>
											<th>SUB FLOW TYPE</th>
											<th>Updated Subscriber</th>
											<th>Device Purchased</th>
										</tr>
									</thead>
									<tbody ng-repeat="lineItem in portalOrderDetails.portalLineItemList">
										<tr >
											<td>
								              <span class="glyphicon glyphicon-minus-sign cursorPointer" ng-if="lineItem.expanded" ng-click="lineItem.expanded = false"></span>
								              <span class="glyphicon glyphicon-plus-sign cursorPointer" ng-if="!lineItem.expanded" ng-click="lineItem.expanded = true"></span>
								            </td>
											<td>{{lineItem.lineId}}</td>
											<td>{{lineItem.subscriberId}}</td>
											<td>{{lineItem.wirelessNumber}}</td>
											<td>{{lineItem.lineType}}</td>
											<td>{{lineItem.subFlowType}}</td>
											<td><span ng-class="{{lineItem.updateSubCalled}} ? 'glyphicon glyphicon-ok clrGREEN marLeft60' : 'glyphicon glyphicon-remove clrRED marLeft60'"></span></td>
											<td><span ng-class="{{lineItem.purchseDeviceCalled}} ? 'glyphicon glyphicon-ok clrGREEN marLeft60' : 'glyphicon glyphicon-remove clrRED marLeft60'"></span></td>
										</tr>
										<tr ng-if="lineItem.expanded" ng-repeat="ship in portalOrderDetails.portalShipmentInfo | filter : lineItem.lineId" ng-repeat-end="">
											<th colspan="2" ng-if="ship.productType=='device' || ship.productType=='plan' || ship.productType=='addon' || ship.productType=='accessory'">{{ship.productType | uppercase}} : </th>
											<td colspan="6" ng-if="ship.productType=='device'  || ship.productType=='plan' || ship.productType=='addon' || ship.productType=='accessory'">{{ship.epcSkuId}} (<i> {{ship.deviceDisplayName}} </i>)</td>
							            </tr> 
							            <tr ng-if="lineItem.expanded" ng-repeat="ship in portalOrderDetails.portalShipmentInfo | filter : lineItem.lineId" ng-repeat-end="">
											<th colspan="2" ng-if="ship.productType=='sim'">DEVICE : </th>
											<td colspan="6" ng-if="ship.productType=='sim'">{{ship.epcSkuId}} (<i> {{ship.deviceDisplayName}} </i>)</td>
							            </tr> 
							            <tr ng-if="lineItem.expanded" ng-repeat="ship in portalOrderDetails.portalShipmentInfo | filter : lineItem.lineId" ng-repeat-end="">
											<th colspan="2" ng-if="ship.productType=='device' || ship.productType=='sim'">SIM : </th>
											<td colspan="6" ng-if="ship.productType=='device' || ship.productType=='sim'">{{ship.sim}}</td>
							            </tr>
							            <tr ng-if="lineItem.expanded" ng-repeat="ship in portalOrderDetails.portalShipmentInfo | filter : lineItem.lineId" ng-repeat-end="">
											<th colspan="2" ng-if="ship.productType=='device'">IMEI : </th>
											<td colspan="6" ng-if="ship.productType=='device'">{{ship.imei}}</td>
							            </tr>
									</tbody>
								</table>
							</div>
							<!-- /example -->
						</div>


						<div class="col-lg-12">
							<div class="page-header">
								<h3 id="progress">Ensemble Subscribers and Lines</h3>
							</div>
							<div class="bs-component">
								<table class="table table-striped table-hover ">
									<thead>
										<tr>
											<th>ACCOUNT NO</th>
											<th>SUBSCRIBER ID</th>
											<th>PTN</th>
											<th>PTN STATUS</th>
											<th>APPLICATION</th>
											<th>SUBLINE STATUS</th>
										</tr>
									</thead>
									<tbody>
										<tr ng-repeat="lineItem in ensembleOrderDetails.ensLineItemList">
											<td>{{lineItem.accountNo}}</td>
											<td>{{lineItem.subscriberNo}}</td>
											<td>{{lineItem.ptn}}</td>
											<td>{{lineItem.ptnStatus}}</td>
											<td>{{lineItem.applicationId}}</td>
											<td>{{lineItem.sublineStatus}}</td>
										</tr>
									</tbody>
								</table>
							</div>
							<!-- /example -->
						</div>

					</div>
				</div>
			</div>
			
			<!-- ORDER LINE ITEM DETAILS PANEL END -->

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
											<label> {{portalOrderDetails.enrollInfo.firstName}}
											</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Last Name:</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.enrollInfo.lastName}} </label>
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
											<label>
												{{portalOrderDetails.enrollInfo.phoneNumber}} </label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">Address :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label>{{portalOrderDetails.enrollInfo.address1}}
												{{portalOrderDetails.enrollInfo.address2}},
												{{portalOrderDetails.enrollInfo.city}},
												{{portalOrderDetails.enrollInfo.state}}</label>
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="col-lg-6 control-label textAignLeft">ZIP :</label>
									<div class="col-lg-6">
										<div class="radio">
											<label> {{portalOrderDetails.enrollInfo.zipCode}} </label>
										</div>
									</div>
								</div>


							</fieldset>
						</form>
					</div>
				</div>
				<!-- RIGHT -->
				<!-- <div class="col-lg-6">
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
								<div class="form-group"
									ng-show="portalOrderDetails.portalShipmentInfo.accessoryAvailable">
									<label class="col-lg-6 control-label textAignLeft">Accessories</label>
									<div class="col-lg-6">
										<div class="radio" ng-repeat="acc in portalOrderDetails.portalShipmentInfo.accessoryList">
											<label>{{acc}}</label>
										</div>
									</div>
								</div>
								<div class="form-group"
									ng-show="portalOrderDetails.portalShipmentInfo.addonAvailable">
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
				</div> -->
				<!-- RIGHT END -->
			</div>





			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">API Details</h3>
				</div>
				<div class="panel-body">
					<div class="bs-component">
						<div class="form-group">
							<input type="text" class="form-control" ng-model="apiName" placeholder="Filter by API Name">
						</div>
						<table class="table table-striped table-hover ">
							<thead>
								<tr>
									<th></th>
									<th>Source</th>
									<th>API Name</th>
									<th>Creation Date</th>
									<th>Originator ID</th>
									<th>Req / Res</th>
								</tr>
							</thead>
							<tbody  ng-repeat=" api in apiOrderDetails | filter: apiName">
								<tr ng-class="(api.errorInResponse=='Y') ? ['highlightRowRed'] : []">
									<td>
						              <span class="glyphicon glyphicon-minus-sign cursorPointer clrBlue" ng-if="api.expanded" ng-click="api.expanded = false"></span>
						              <span class="glyphicon glyphicon-plus-sign cursorPointer clrBlue" ng-if="!api.expanded" ng-click="api.expanded = true"></span>
						            </td>
									<td>{{api.source}}</td>
									<td>{{api.aPIName}}</td>
									<td>{{api.sysCreationDate}}</td>
									<td>{{api.originatorID}}</td>
									<td>
										<span class="glyphicon glyphicon-upload marLeft10 cursorPointer clrBlue" ng-click="getAPIRequestResponse(api.seqNumber,'request')"></span>
										<span class="glyphicon glyphicon-download marLeft10 cursorPointer clrBlue" ng-click="getAPIRequestResponse(api.seqNumber,'response')"></span>
									</td>
								</tr>
								<tr ng-if="api.expanded" ng-repeat-end="">
									<th colspan="2">Error Message</th>
					            	<td colspan="4">{{api.errorMessage}}</td>
					            </tr>
							</tbody>
						</table> 
						
						
					</div>
				</div>
			</div>
		</div>	
		
			<!-- Order API Req Body Popup Panel start -->
			<div id="orderApiReqBody-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">{{orderAPIReqPanelTitle}}</h4>
						</div>
						<div class="modal-body wordWrapString" id="apiReqResBody">
							{{orderAPIReqBody}}</div>
					</div>
				</div>
			</div>
			<!-- Order API Req Body Popup Panel start -->


			<!-- Order Help Popup Panel start -->
			<div id="orderHelp-modal" class="modal fade"
				ng-if="portalOrderDetails.status!=undefined && portalOrderDetails.status!=null">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Stuck Order Help</h4>
						</div>
						<div class="modal-body ">
							<div ng-repeat="(key, data) in orderHelpData">
								<ul ng-if="portalOrderDetails.status == key"
									ng-repeat="line in data">
									<li><b>{{line}}</b></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Order Help Popup Panel start -->
			
			<!-- Order Inventory status Popup start -->
			<div id="inventoryDetail-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Inventory Status</h4>
						</div>
						<div class="modal-body ">
							<form class="navbar-form navbar-left noPad" role="search">
								<div class="form-group">
									<input type="text" class="form-control" ng-model="skuIDInvSearch" placeholder="SKU ID"/>
								</div>
								<button type="button" class="btn btn-default" ng-click="getInvStatusDetails()"> Search</button>
							</form>
							<div class="row">
							 	<table class="table table-striped table-hover ">
									<thead>
										<tr>
											<th>Display Name</th>
											<th>Avail Status</th>
											<th>Stock Level</th>
											<th>Stock Thresh</th>
											<th>Stock Status</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>{{inventoryStatusDetails.displayName}}</td>
											<td>{{inventoryStatusDetails.availStatus}}</td>
											<td>{{inventoryStatusDetails.stockLevel}}</td>
											<td>{{inventoryStatusDetails.stockThresh}}</td>
											<td>{{inventoryStatusDetails.stockStatus}}</td>
										</tr>
									</tbody>
								</table>
							 </div>
						</div>
					</div>
				</div>
			</div>
			<!-- Order Inventory status Popup End -->
			
			<!-- Customer Name details Popup start -->
			<div id="nameDetail-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title">Name Details</h4>
						</div>
						<div class="modal-body ">
							<form class="navbar-form navbar-left noPad" role="search">
								<div class="form-group">
									<input type="text" class="form-control" ng-model="esnNameSearch" placeholder="SIM/IMEI"/>
								</div>
								<button type="button" class="btn btn-default" ng-click="getNameDetails()"> Search</button>
							</form>
							<div class="row">
									 	<table class="table table-striped table-hover ">
											<thead>
												<tr>
													<th>First Name</th>
													<th>last Name</th>
													<th>Customer Id</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>{{nameDetails.firstName}}</td>
													<td>{{nameDetails.lastName}}</td>
													<td>{{nameDetails.custId}}</td>
												</tr>
											</tbody>
										</table>
									 </div>
						</div>
					</div>
				</div>
			</div>
			<!-- Customer Name details Popup End -->
			
			
			<!-- Order Help Popup Panel start -->
			<div id="orderPortDetails-modal" class="modal fade">
				<div class="modal-dialog modal-lg">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							<h4 class="modal-title">Portin Details</h4>
						</div>
						<div class="modal-body ">
						
							<div class="panel panel-info">
				                <div class="panel-heading">
				                  <h3 class="panel-title">Portal Portin Details</h3>
				                </div>
				                <div class="panel-body">
				                  
				                   <div class="row">
									 	<table class="table table-striped table-hover ">
											<thead>
												<tr>
													<th>LINE ID</th>
													<th>PORT STATUS</th>
													<th>SP NAME</th>
													<th>PTN</th>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat=" port in portalOrderPortInDetails">
													<td>{{port.lineId}}</td>
													<td>{{port.portStatus}}</td>
													<td>{{port.spName}}</td>
													<td>{{port.transberNumber}}</td>
												</tr>
											</tbody>
										</table>
									 </div>
				                  
				                </div>
				              </div>
				              
				              
				              <div class="panel panel-info">
				                <div class="panel-heading">
				                  <h3 class="panel-title">Ensemble Portin Details</h3>
				                </div>
				                <div class="panel-body">
				                  	<div class="row">
									 	<table class="table table-striped table-hover ">
											<thead>
												<tr>
													<th>REQUEST NO</th>
													<th>EXT REQ NO</th>
													<th>PTN</th>
													<th>PORT TYPE</th>
													<th>PORT STATUS</th>
													<th>STATUS DESC</th>
												</tr>
											</thead>
											<tbody>
												<tr ng-repeat=" port in ensOrderPortInDetails">
													<td>{{port.requestNo}}</td>
													<td>{{port.externalReqNo}}</td>
													<td>{{port.ptn}}</td>
													<td>{{port.portType}}</td>
													<td>{{port.requestStatus}}</td>
													<td>{{port.statusDesc}}</td>
												</tr>
											</tbody>
										</table>
									 </div>
				                  	
				                </div>
				              </div>
							 
						</div>
					</div>
				</div>
			</div>
			<!-- Order Help Popup Panel start -->

		

	</div>

</body>
</html>
