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
						<a href="#orderMaster" tooltip-placement="bottom" uib-tooltip="back" class="glyphicon glyphicon-chevron-left floatRight cursorPointer"></a>
					</h3>
				</div>
			</div>
		</div>
	
		<flash-message></flash-message> 
		
		<div ng-init="accordion=0">
		
			<!-- Update Order SIM Panel Start -->
			<div ng-show="restrictedUpdates.indexOf('UPDATE_SIM')===-1" class="panel panel-info">
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
                                                       <div class="col-lg-2 noPadLeft">
                                                            <label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
															<input ng-if="orderID==undefined" type="text" class="form-control" ng-model="updateData.simOrderId" placeholder="Order ID">
                                                       </div>
                                                       <h3  ng-click="getPortalLineSimandImeiDetails('sim')" type="reset"  class=""><span tooltip-placement="bottom" uib-tooltip="Get Line Details"  class="glyphicon glyphicon-list-alt getLineBtn"></span></h3>
                                                </div>
                                                <div class="form-group">
                                                       <!-- <label for="select" class="col-lg-4 control-label textAlgnInit">New SIM</label>
                                                       <input type="text" ng-model="newSIM" class="form-control" id="inputEmail" placeholder="SIM" maxlength="20"> -->
                                                       
                                                        <div class="row mar10">
												          <div class="col-lg-12">
												            <div class="bs-component">
												              <table class="table table-striped table-hover ">
												                <thead>
												                  <tr>
												                    <th>#</th>
												                    <th>LINE ID		</th>
												                    <th>SUBSCRIBER ID</th>
												                    <th>PTN</th>
												                    <th>Current SIM Value</th>
												                    <th  class="col-lg-4">New SIM Value</th>
												                  </tr>
												                </thead>
												                <tbody>
												                  <tr ng-repeat="line in PortalLineSimAndImeiDetails">
												                    <td>1</td>
												                    <td >{{line.lineItemNo}}</td>
												                    <td >{{line.subscriberId}}</td>
												                    <td >{{line.ptn}}</td>
												                    <td >{{line.sim}}</td>
												                    <td><h4 ng-show="!showEditSimTB1"><span class="glyphicon glyphicon-edit cursorPointer" ng-click="showEditSimTB1 = !showEditSimTB1"></span></h4>
												                    	<div ng-show="showEditSimTB1" class="col-lg-12 noPad">
												                    		<input ng-show="showEditSimTB1"  type="text" ng-model="newObject[line.lineItemNo]" class="form-control col-lg-6 simTBWidth" placeholder="SIM" maxlength="20">
												                    		<div >
												                    			<h4><span class="glyphicon glyphicon-ok-sign cursorPointer marLeft40" ng-click="updateSimAndImei(line,newObject[line.lineItemNo],'sim')" tooltip-placement="bottom" uib-tooltip="Update"  ></span>
												                    			<span class="glyphicon glyphicon-remove-sign cursorPointer marLeft8 " tooltip-placement="bottom" uib-tooltip="Cancel"  ng-click="showEditSimTB1 = !showEditSimTB1; newObject[line.lineItemNo]=null"></span>
												                    			</h4>
												                    		</div>
												                    	</div>
												                    </td>
												                  </tr>	
												                </tbody>
												              </table> 
												            </div><!-- /example -->
												          </div>
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
			<div ng-show="restrictedUpdates.indexOf('UPDATE_IMEI')===-1" class="panel panel-info">
				<div class="panel-heading accordion cursorPointer" ng-click="accordion = 3" ng-class="{active:accordion==3}">
					<h3 class="panel-title">Update Order IMEI</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==3">
					 <div class="">
                           <div class="">
                                  <div class="well" id="">
                                         <form class="form-horizontal">
                                                <!-- <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-8 noPadLeft">
                                                              <label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
															  <input ng-if="orderID==undefined" type="text" class="form-control" ng-model="orderID" placeholder="Order ID">
                                                       </div>
                                                </div> -->
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-2 noPadLeft">
                                                            <label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
															<input ng-if="orderID==undefined" type="text" class="form-control" ng-model="updateData.imeiOrderId" placeholder="Order ID">
                                                       </div>
                                                       <h3  ng-click="getPortalLineSimandImeiDetails('imei')" type="reset"  class=""><span tooltip-placement="bottom" uib-tooltip="Get Line Details"  class="glyphicon glyphicon-list-alt getLineBtn"></span></h3>
                                                </div>
                                               <!--  <div class="form-group">
                                                       <label for="select" class="col-lg-4 control-label textAlgnInit">New IMEI</label>
                                                            <input type="text" ng-model="newIMEI" class="form-control" id="inputEmail" placeholder="IMEI" maxlength="15">
                                                </div> -->
                                                <div class="form-group">
                                                       <!-- <label for="select" class="col-lg-4 control-label textAlgnInit">New SIM</label>
                                                       <input type="text" ng-model="newSIM" class="form-control" id="inputEmail" placeholder="SIM" maxlength="20"> -->
                                                       
                                                        <div class="row mar10">
												          <div class="col-lg-12">
												            <div class="bs-component">
												              <table class="table table-striped table-hover ">
												                <thead>
												                  <tr>
												                    <th>#</th>
												                    <th>LINE ID		</th>
												                    <th>SUBSCRIBER ID</th>
												                    <th>PTN</th>
												                    <th>Current IMEI Value</th>
												                    <th  class="col-lg-4">New IMEI Value</th>
												                  </tr>
												                </thead>
												                <tbody>
												                  <tr ng-repeat="line in PortalLineSimAndImeiDetails">
												                    <td>1</td>
												                    <td >{{line.lineItemNo}}</td>
												                    <td >{{line.subscriberId}}</td>
												                    <td >{{line.ptn}}</td>
												                    <td >{{line.imei}}</td>
												                    <td><h4 ng-show="!showEditImeiTB1"><span class="glyphicon glyphicon-edit cursorPointer" ng-click="showEditImeiTB1 = !showEditImeiTB1"></span></h4>
												                    	<div ng-show="showEditImeiTB1" class="col-lg-12 noPad">
												                    		<input ng-show="showEditImeiTB1"  type="text" ng-model="newObject[line.lineItemNo]" class="form-control col-lg-6 simTBWidth" placeholder="IMEI" maxlength="20">
												                    		<div >
												                    			<h4><span class="glyphicon glyphicon-ok-sign cursorPointer marLeft40" ng-click="updateSimAndImei(line,newObject[line.lineItemNo],'imei')" tooltip-placement="bottom" uib-tooltip="Update"  ></span>
												                    			<span class="glyphicon glyphicon-remove-sign cursorPointer marLeft8 " tooltip-placement="bottom" uib-tooltip="Cancel"  ng-click="showEditImeiTB1 = !showEditImeiTB1; newObject[line.lineItemNo]=null"></span>
												                    			</h4>
												                    		</div>
												                    	</div>
												                    </td>
												                  </tr>	
												                </tbody>
												              </table> 
												            </div><!-- /example -->
												          </div>
												        </div>
                                                </div>
                                               <!--  <div class="form-group">
                                                       <div class="col-lg-4"></div>
                                         <div class="col-lg-8 noPadLeft">
                                           <button type="reset" class="btn btn-default"  ng-click="updateOrder('imei')">Submit</button>
                                         </div>
                                       </div> -->
                                         </form>
                                  </div>
                           </div>
                     </div>
				</div>
			</div>
			<!-- Update Order IMEI Panel End -->
			
			<!-- Update Order Status Panel Start -->
			<div ng-show="restrictedUpdates.indexOf('UPDATE_STATUS')===-1"  class="panel panel-info ">
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
											<label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
											<input ng-if="orderID===undefined" type="text" id="orderNUmber" class="form-control" ng-model="updateData.statusOrderId" placeholder="Order ID">
										</div>
									</div>
									<div class="form-group">
										<label for="select" class="col-lg-4 control-label textAlgnInit">New Status</label>
										<div class="col-lg-8">
											<select class="form-control" ng-model="newStatus" id="select">
												<option value="OPEN">OPEN</option>
												<option value="PDRS">PDRS</option>
												<option value="ORFI">ORFI</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-4"></div>
										<div class="col-lg-8">
											<button type="button" class="btn btn-default" ng-click="updateOrder('status')">Submit</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Update Order Status Panel End -->
			
			
			<!-- Update Order RetryCount Panel Start -->
			<div ng-show="restrictedUpdates.indexOf('UPDATE_RETRYCOUNT')===-1" class="panel panel-info">
				<div class="panel-heading accordion cursorPointer" ng-click="accordion = 4" ng-class="{active:accordion==4}">
					<h3 class="panel-title">Update Order RetryCount</h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==4">
                                  <div class="well" id="">
                                         <form class="form-horizontal">
                                                <div class="form-group">
                                                       <label class="col-lg-4 control-label textAlgnInit">Order</label>
                                                       <div class="col-lg-8 noPadLeft">
                                                               <label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
															   <input ng-if="orderID==undefined" type="text" class="form-control" ng-model=updateData.retryCntOrderID placeholder="Order ID">
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <label for="select" class="col-lg-4 control-label textAlgnInit">Set
                                                              Retry Count</label>
                                                       <div class="col-lg-8 noPad">
                                                       <input type="text" ng-model="newRetry" class="form-control" id="inputEmail" placeholder="count" maxlength="1">
                                                       </div>
                                                </div>
                                                <div class="form-group">
                                                       <div class="col-lg-4"></div>
                                         				<div class="col-lg-8 noPad">
				                                           <button type="button" class="btn btn-default" ng-click="updateOrder('retry')">Submit</button>
				                                         </div>
		                                       </div>
                                         </form>
                                  </div>
				</div>
			</div>
			<!-- Update Order RetryCount Panel End -->
			
			<!-- Multi Update Order Panel Start -->
			<div ng-show="restrictedUpdates.indexOf('UPDATE_STATUS')===-1"  class="panel panel-info ">
				<div class="panel-heading accordion cursorPointer" ng-class="{active:accordion==6}"  ng-click="accordion = 6">
					<h3 class="panel-title">Multi Updates <span class="glyphicon glyphicon-th-list marLeft8"></span></h3>
				</div>
				<div class="panel-body accordion-content" ng-show="accordion==6">
					<div class="">
						<div class="">
							<div class="well" id="">
								<form class="form-horizontal">
									<div class="alert alert-dismissible alert-info" ng-show="multiUpdateMessage.length>0">
						                <button type="button" class="close" data-dismiss="alert">×</button>
						                {{multiUpdateMessage}}
						            </div>
								
									<div class="form-group">
										<label class="col-lg-4 control-label textAlgnInit">Order</label>
										<div class="col-lg-8">
											<label ng-if="orderID.length>0" class="col-lg-12 control-label textAlgnInit noPadLeft">{{orderID}}</label>
											<input ng-if="orderID===undefined" type="text" id="orderNUmber" class="form-control" ng-model="updateData.statusOrderId" placeholder="Order ID">
										</div>
									</div>
									<div class="form-group">
										<label for="select" class="col-lg-4 control-label textAlgnInit">Select Table & Column</label>
										<div class="col-lg-2">
											<select class="form-control" ng-change="populateColumnList()" ng-disabled="multiTblDisabled"  ng-model="tableSelect" id="select">
												<option value="">------- TABLE -------</option>
												<option value="ZIG_AUTO_MASTER">ZIG_AUTO_MASTER</option>
												<option value="ZIG_ORDER_SHIPMENT_INFO">ZIG_ORDER_SHIPMENT_INFO</option>
												<option value="ZIG_EXTRA_ORDER">ZIG_EXTRA_ORDER</option>
							 				</select>
										</div>
										<div class="col-lg-2 noPadLeft marLeft75" ng-show="tableCloumnList.length>0">
											<select class="form-control dpWidth" ng-model="tableColName" ng-options="col.name for col in tableCloumnList" >
												<option value="">------- COLUMN -------</option>
											</select>
										</div>
										<div class="col-lg-2 " ng-show="tableCloumnList.length>0">
											<span class="glyphicon glyphicon-plus-sign addMultiUpdateIcon cursorPointer" ng-click="populateUpdateTable()" tooltip-placement="bottom" uib-tooltip="Add"></span>
											<span class="glyphicon glyphicon-remove-circle  addMultiUpdateIcon cursorPointer marLeft8"  ng-click="resetMultiUpdatePanel()" tooltip-placement="bottom" uib-tooltip="Reset"></span>
										</div>
									</div>
									<div class="form-group" ng-show="multiUpdateData.length>0">
										<div class="col-lg-4"></div>
										<div class="col-lg-8">
											<table class="table table-striped table-hover ">
												<thead>
													<tr>
														<th>Column</th>
														<th>Value</th>
														<th></th>
													</tr>
												</thead>
												<tbody>
													<tr ng-repeat="multi in multiUpdateData">
														<td class="multiUpdateTableData">{{multi.colName}}</td>
														<td><input type="text" class="form-control" ng-model="multi.colValue" value=""></td>
														<td class="multiUpdateTableData fontSize20"><span class="glyphicon glyphicon-trash cursorPointer" ng-click="removeMultiUpdateData($index)"></span></td>
													</tr>
												</tbody>
											</table>
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-4"></div>
										<div class="col-lg-8">
											<button type="button" class="btn btn-default" ng-click="updateMultiOrderData()">Update</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- Multi Update Order Panel End -->
			
			
		<!-- 	<a class="btn btn-warning btn-lg">Bulk Order Update <span class="glyphicon glyphicon-list-alt marLeft8"></span></a> -->
			
			
		<!-- Buld Order Update Panel Start -->	
		 <div ng-show="restrictedUpdates.indexOf('BULK_UPDATE')===-1" class="panel panel-warning">
               <div class="panel-heading  accordion cursorPointer" ng-click="accordion = 5" ng-class="{active:accordion==5}">
                 	<h3 class="panel-title">Bulk Order Update <span class="glyphicon glyphicon-th marLeft8"></span></h3>
               </div>
               <div class="panel-body  accordion-content"  ng-show="accordion==5">
        	 			<div class="well" id="">
                                <form class="form-horizontal">
                                	 <div class="form-group">
						                    <label class="col-lg-2 control-label textAlgnInit">Update Type</label>
						                    <div class="col-lg-10">
						                      <div class="radio">
						                        <label class="col-lg-2">
						                          <input type="radio" ng-model="updateType"  value="status"> Status
						                        </label>
						                        <label class="col-lg-2">
						                           <input type="radio" ng-model="updateType" value="sim"> SIM
						                        </label>
						                        <label class="col-lg-2">
						                           <input type="radio" ng-model="updateType" value="imei"> IMEI
						                        </label>
						                        <label class="col-lg-2">
						                           <input type="radio" ng-model="updateType" value="retry"> Retry Count
						                        </label>
						                        <label class="col-lg-4">
						                        		<a tooltip-placement="bottom" uib-tooltip="Help" ng-click='openHelpModel()'  class="glyphicon glyphicon-info-sign  helpIcon floatRight cursorPointer"></a>
														<a href="downloadSampleExcel/{{updateType}}">
															<img class="excelIcon floatRight marRight8" tooltip-placement="left" uib-tooltip="Download Excel" src="resources/images/excel2.png">
														</a> 
						                        </label>
						                      </div>
						                    </div>
					                  </div>
                                       <div class="form-group marTop30">
                                              <label class="col-lg-2 control-label textAlgnInit noPadTop">Upload File</label>
                                              <div class="col-lg-10 noPadLeft">
						   							  <input type = "file" class="custom-file-input padLeft15" file-model = "myFile"/>
                                              </div>
                                       </div>
                                       <div class="form-group marTop30">
                                              <div class="col-lg-2"></div>
			                                  <div class="col-lg-10 ">
			                                      <button  type="button" class="btn btn-defaul"  ng-click = "uploadFile()">Update</button>
			                                  </div>
		                              </div>
                                </form>
                        </div>
               </div>
         </div>
		<!-- Buld Order Update Panel End -->	
			
			
		<!-- Help Popup Panel start -->
		 <div id="UpdateHelp-modal" class="modal fade">
	        <div class="modal-dialog modal-lg">
	          <div class="modal-content">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	              <h4 class="modal-title">Bulk Order Update</h4>
	            </div>
	            <div class="modal-body helpPupupHeight">
	              <table cellpadding="10px" cellspacing="10px">
	              	<tbody>
	              		<tr>
	              			<td>Bulk Order update will allow user to update orders in bulk in one Go.</td>
	              		</tr>
	              		<tr>
	              			<td>Please follow below steps to update multiple orders:</td>
	              		</tr>
	              		<tr>
	              			<td>1) Select Order Update type.</td>
	              		</tr>
	              		<tr>
	              			<td>2) Click on Download Icon to download sample excel sheet.</td>
	              		</tr>
	              		<tr>
	              			<td>3) Add order details in downloaded Excel sheet and the type of data you want to update [i.e. Status, SIM, IMEI, Retry Count]</td>
	              		</tr>
	              	</tbody>    
	              </table>
	              
	              <img src="resources/images/Capture3.jpg" class="helpPopupImage">
	              
	              <div class="col-lg-12">
		              <img class="helpExcelImage" src="resources/images/HelpExcelImage.PNG" >
	              </div>
	            </div>
	          </div>
	        </div>
	      </div>
		
		<!-- Help Popup Panel End -->
			
		
		<!-- Bulk Update Message Popup Panel start -->
		<div id="UpdateResponse-modal" class="modal fade">
	        <div class="modal-dialog modal-lg">
	          <div class="modal-content">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	              <h4 class="modal-title">Please review and Update</h4>
	            </div>
	            <div class="modal-body " ng-init="accordion='Valid'">
           		 	<ul class="nav nav-tabs">
		               <li ng-class="{active:accordion=='Valid'}"><a data-toggle="tab" ng-click="accordion = 'Valid'">Valid Order Data</a></li>
		               <li ng-class="{active:accordion=='InValid'}"><a data-toggle="tab" ng-click="accordion = 'InValid'">InValid Order Data</a></li>
		            </ul>
		            <div id="myTabContent" class="tab-content">
		                <div class="tab-pane fade active in" id="home" ng-show="accordion=='Valid'">
							 <table class="table table-striped table-hover ">
							 	<thead>
							 		<tr>
								 		<th>Order ID</th>
								 		<th ng-show="tempTblUpdateType=='sim' || tempTblUpdateType=='imei'">Line ID</th>
								 		<th ng-show="tempTblUpdateType=='status'">Status</th>
								 		<th ng-show="tempTblUpdateType=='sim'">SIM</th>
								 		<th ng-show="tempTblUpdateType=='imei'">IMEI</th>
								 		<th ng-show="tempTblUpdateType=='retry'">Retry Count</th>
								 	</tr>
							 	</thead>
				              	<tbody>
				              		<tr ng-repeat="data in tempTableDataList">
				              			<td>{{data.orderId}}</td>
				              			<td ng-show="tempTblUpdateType=='sim' || tempTblUpdateType=='imei'">{{data.lineId}}</td>
				              			<td ng-show="tempTblUpdateType=='status'">{{data.status}}</td>
				              			<td ng-show="tempTblUpdateType=='sim'">{{data.sim}}</td>
				              			<td ng-show="tempTblUpdateType=='imei'">{{data.imei}}</td>
				              			<td ng-show="tempTblUpdateType=='retry'">{{data.retryCount}}</td>
				              		</tr>
				              	</tbody>    
				              </table>
				              <button type="submit" class="btn btn-default" ng-click="searchOrderDetails()">Update</button>
		                </div>
		                <div class="tab-pane fade active in" id="profile" ng-show="accordion=='InValid'">
							 <table cellpadding="10px" cellspacing="10px">
				              	<tbody>
				              		<tr ng-repeat="orders in inValidOrders">
				              			<td>{{orders}}</td>
				              		</tr>
				              	</tbody>    
				              </table>
		                </div>
		            </div>
				      
	            </div>
	          </div>
	        </div>
	      </div>
		<!-- Bulk Update Message Popup Panel start -->
		
		
			
		</div>

	</div>
	
	
	
</body>
</html>
