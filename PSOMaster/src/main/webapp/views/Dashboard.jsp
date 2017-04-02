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
	
	            <div class="bs-component  col-lg-3 noPadLeft">
	              <ul class="list-group">
	                <li class="list-group-item">
	                  <span class="badge">14</span> ACTIVATION
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">2</span> CANCELLATION
	                </li>
	              </ul>
	            </div><!-- /example -->
	            <div class="bs-component  col-lg-3">
	              <ul class="list-group">
	                <li class="list-group-item">
	                  <span class="badge">14</span> PORTIN
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">2</span> REGULAR
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">1</span> ACCESSORY
	                </li>
	              </ul>
	            </div><!-- /example -->
	             <div class="bs-component  col-lg-3">
	              <ul class="list-group">
	                <li class="list-group-item">
	                  <span class="badge">14</span> PRE-PURCHASE
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">2</span> BYOD
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">1</span>SAVEDESK 
	                </li>
	              </ul>
	            </div><!-- /example -->
	             <div class="bs-component  col-lg-3">
	              <ul class="list-group">
	                <li class="list-group-item">
	                  <span class="badge">14</span>SIM_SWAP
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">2</span>UPGRADE
	                </li>
	                <li class="list-group-item">
	                  <span class="badge">1</span>ADDLINE
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
	          <div class="modal-content">
	            <div class="modal-header">
	              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
	              <h4 class="modal-title">Customize Statistics</h4>
	            </div>
	            <div class="modal-body">
	            
	            </div>
	          </div>
	        </div>
	      </div>
		
		<!-- Dynamic Graph Panel End -->
      
</body>
</html>