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
              <h3 id="navbar"><span class="glyphicon glyphicon-th-list  marRight8"></span>{{title}}</h3>
            </div>

          </div>
        </div>
      </div>
      
       
      <!-- START -->
      
     <!--  <div >
	    <pre>Selected date is: <em>{{dt | date:'fullDate' }}</em></pre>
	
	    <h4>Popup</h4>
	    <div class="row">
	      <div class="col-md-6">
	        <p class="input-group">
	          <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="dt" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
	          <span class="input-group-btn">
	            <button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
	          </span>
	        </p>
	      </div>
	
	      <div class="col-md-6">
	        <p class="input-group">
	          <input type="text" class="form-control" uib-datepicker-popup ng-model="dt" is-open="popup2.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" />
	          <span class="input-group-btn">
	            <button type="button" class="btn btn-default" ng-click="open2()"><i class="glyphicon glyphicon-calendar"></i></button>
	          </span>
	        </p>
	      </div>
	    </div>
	    <div class="row">
	      <div class="col-md-6">
	        <label>Format: <span class="muted-text">(manual alternate <em>{{altInputFormats[0]}}</em>)</span></label> <select class="form-control" ng-model="format" ng-options="f for f in formats"><option></option></select>
	      </div>
	    </div>
	
	    <hr />
	    <button type="button" class="btn btn-sm btn-info" ng-click="today()">Today</button>
	    <button type="button" class="btn btn-sm btn-default" ng-click="setDate(2009, 7, 24)">2009-08-24</button>
	    <button type="button" class="btn btn-sm btn-danger" ng-click="clear()">Clear</button>
	    <button type="button" class="btn btn-sm btn-default" ng-click="toggleMin()" uib-tooltip="After today restriction">Min date</button>
	</div> -->
      
      <!-- END -->
      
      
      <div>

        <div class="row">
          <div class="col-lg-12">
          
           <div class="col-lg-4">
            <div class="">
              <h3 id="tables">Stuck Orders</h3>
            </div>

            <div class="bs-component">
             <!--  <table class="table table-striped table-hover">
                <thead>
                  <tr>
                    <th>Orders</th>
                    <th>Count</th>
                  </tr>
                </thead>
                <tbody>
                  <tr ng-repeat="status in stuckOrderDetails">
                    <td><a href="#StuckOrderDetails/{{status.orderStatus}}" class="cursorPointer">{{status.orderStatus}}</a></td>
                    <td>{{status.count}}</td>
                  </tr>
                </tbody>
              </table> --> 
              
              <ul class="list-group">
	                <li class="list-group-item" ng-repeat="status in stuckOrderDetails">
	                  <span class="badge">{{status.count}}</span>
	                  <a href="#StuckOrderDetails/{{status.orderStatus}}" class="cursorPointer">{{status.orderStatus}}</a>
	                </li>
	              </ul>
              
            </div><!-- /example -->
            </div>
            
             <div class="col-lg-8">
		            <div class="">
		              <h3 id="tables">Regular Orders
		              	<a class=" btn btn-default glyphicon glyphicon-align-center floatRight marRight20 dynGrphIcon" ng-click="showDynamicGraphPopup()"></a>
		              </h3>
		            </div>
		
		            <div class="bs-component  col-lg-3 noPadLeft" >
		              <ul class="list-group">
		                <li class="list-group-item" ng-repeat="reg in regularOrderStatistics | filter : {group : 'STATUS'}">
		                  <span class="badge">{{reg.count}}</span> {{reg.typeOfOrder}}
		                </li>
		              </ul>
		            </div><!-- /example -->
		            <div class="bs-component  col-lg-3">
		               <ul class="list-group">
		                <li class="list-group-item" ng-repeat="reg in regularOrderStatistics | filter : {group : 'Order_Type'}">
		                  <span class="badge">{{reg.count}}</span> {{reg.typeOfOrder}}
		                </li>
		              </ul>
		            </div><!-- /example -->
		             <div class="bs-component  col-lg-3">
		               <ul class="list-group">
		                <li class="list-group-item" ng-repeat="reg in regularOrderStatistics | filter : {group : 'FLOW_Type'}">
		                  <span class="badge">{{reg.count}}</span> {{reg.typeOfOrder}}
		                </li>
		              </ul>
		            </div><!-- /example -->
		             <div class="bs-component  col-lg-3">
		               <ul class="list-group">
		                <li class="list-group-item" ng-repeat="reg in regularOrderStatistics | filter : {group : 'SUB_FLOW'}">
		                  <span class="badge">{{reg.count}}</span> {{reg.typeOfOrder}}
		                </li>
		              </ul>
		            </div><!-- /example -->
	            </div>
          </div>
        </div>
      </div>
      
       <div class="">
         <h3 id="tables">Stuck Orders Statistics</h3>
       </div>
      
      <div class="row" class="col-lg-12">
      	 <div class="panel panel-info col-lg-12">
	          <div class="panel-heading">
	            <h3 class="panel-title">Stuck Order backlogs in last 10 Days</h3>
	          </div>
	          <div class="panel-body panelMinHeight">
		       	<h3 id="navbar">
					<a class="glyphicon glyphicon-chevron-left cursorPointer marRight40 noTextDeco" ng-click="showGraph('prev')"></a>{{curDate}}
					<a class="glyphicon glyphicon-chevron-right cursorPointer marLeft40 noTextDeco" ng-click="showGraph('next')"></a>
				</h3>
	              <div id="myTabContent" class="tab-content">
	              			<div fusioncharts id="test3"
						       width="1000"
						       height="400"
						       type="column2d"
						       dataSource="{{myDataSource3}}" >
						    </div>
	              </div>
	          </div>
        </div>
      </div>
      
      
      <div class="row" class="col-lg-12">
        <div class="panel panel-info  col-lg-6">
	          <div class="panel-heading">
	            <h3 class="panel-title">Stuck Orders handled in Last 10 Days</h3>
	          </div>
	          <div class="panel-body panelMinHeight">
						<fusioncharts 
						    width="500" 
						    height="400"
						    type="pie3d"
						    datasource="{{myDataSourceOrderHandledPie}}"></fusioncharts>
				
	          </div>
        </div>
         <div class="panel panel-info col-lg-6">
	          <div class="panel-heading">
	            <h3 class="panel-title">Orders stuck in different statuses</h3>
	          </div>
	          <div class="panel-body panelMinHeight">
						<fusioncharts 
						    width="500" 
						    height="400"
						    type="pie3d"
						    datasource="{{myDataSourcePie}}"></fusioncharts>
	          </div>
        </div>
      </div>
      
      
      
      <!--Dynamic Graph Panel start -->
		 <div id="DynamicGraph-modal" class="modal fade">
	        <div class="modal-dialog modal-lg">
	          <div class="modal-content" style="z-index: 0 !important">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	              <h4 class="modal-title">Customize Statistics</h4>
	            </div>
	            <flash-message></flash-message>
	            <div class="modal-body dynGrphPopupMinHeight">
	            
	            	<form class="navbar-form navbar-left noPad" role="search">
						 <div class="col-md-4">
					        <p class="input-group">
					          <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="fromDate" is-open="popup1.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
					          <span class="input-group-btn">
					           	<button type="button" class="btn btn-default" ng-click="open1()"><i class="glyphicon glyphicon-calendar"></i></button>
					          </span>
					        </p>
					      </div>
					      <div class="col-md-4">
					        <p class="input-group">
					          <input type="text" class="form-control" uib-datepicker-popup="{{format}}" ng-model="toDate" is-open="popup2.opened" datepicker-options="dateOptions" ng-required="true" close-text="Close" alt-input-formats="altInputFormats" />
					          <span class="input-group-btn">
					           	<button type="button" class="btn btn-default" ng-click="open2()"><i class="glyphicon glyphicon-calendar"></i></button>
					          </span>
					        </p>
					      </div>
						<div class="form-group">
							<select class="form-control ng-pristine ng-valid ng-empty ng-touched"  ng-disabled="multiTblDisabled" ng-model="typeSelect" id="select">
												<option value="">Select Type</option>
												<option value="ACTIVATION">ACTIVATION</option>
												<option value="CANCELLATION">CANCELLATION</option>
												<option value="PORTIN">PORTIN</option>
												<option value="REGULAR">REGULAR</option>
												<option value="ACCESSORY">ACCESSORY</option>
												<option value="BYOD">BYOD</option>
												<option value="PRE-PURCHASE">PRE-PURCHASE</option>
												<option value="SAVEDESK">SAVEDESK</option>
												<option value="ADDLINE">ADDLINE</option>
												<option value="UPGRADE">UPGRADE</option>
												<option value="SIMSWAP">SIMSWAP</option>
							 				</select>
						</div>
						<button type="button" class="btn btn-default" ng-click="getDynamicGraphData()">Submit</button>
					</form>
						
					<div class="col-lg-12 marTop20">
						<div class="col-lg-8">
							<fusioncharts 
									    width="500" 
									    height="400"
									    type="pie3d"
									    datasource="{{myOrdersCreatedSourcePie}}"></fusioncharts>
						</div>
						<div class="col-lg-4 table-responsive222">
							<table  class="table table-striped table-hover col-lg-6">
									<thead>
										<tr>
											<th>DATE</th>
											<th>Count</th>
										</tr>
									</thead>
					              	<tbody>
					              		<tr  ng-repeat="reg in myOrdersCreatedSourcePie.data">
					              			<td>{{reg.label}}</td>
					              			<td>{{reg.value}}</td>
					              		</tr>
					              		<tr>
					              			<td>Total</td>
					              			<td>{{totalDynCount}}</td>
					              		</tr>
					              	</tbody>    
				              </table>
						</div>	
					</div>
					
					
	            </div>
	          </div>
	        </div>
	      </div>
		
		<!-- Dynamic Graph Panel End -->
      
</body>
</html>