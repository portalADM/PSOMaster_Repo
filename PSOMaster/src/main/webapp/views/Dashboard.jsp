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
      
       <!-- Forms
      ================================================== -->
      <div>

        <div class="row">
          <div class="col-lg-12">
            <div class="">
              <h3 id="tables">Stuck Orders</h3>
            </div>

            <div class="bs-component">
              <table class="table table-striped table-hover Width30Per">
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
              </table> 
            </div><!-- /example -->
          </div>
        </div>
      </div>
      
       <div class="">
              <h3 id="tables">Stuck Orders Statistics</h3>
            </div>
      
      <div class="row" class="col-lg-12">
      	 <div class="panel panel-info col-lg-6">
          <div class="panel-heading">
            <h3 class="panel-title">Stuck Order backlogs in last 10 Days</h3>
          </div>
          <div class="panel-body panelMinHeight">
			 <canvas id="bar" class="chart chart-bar"
			  chart-data="dataBar" chart-labels="labelsBar"> chart-series="seriesBar"
			</canvas>
			
          </div>
        </div>
        
        <div class="panel panel-info  col-lg-6">
          <div class="panel-heading">
            <h3 class="panel-title">Stuck Orders handled in Last 10 Days</h3>
          </div>
          <div class="panel-body panelMinHeight">
           <canvas id="pie" class="chart chart-pie"
			  chart-data="dataPie" chart-labels="labelsPie" chart-options="options">
			</canvas> 
          </div>
        </div>
      </div>
      
       <div class="row" class="col-lg-12">
      	 <div class="panel panel-info col-lg-6">
          <div class="panel-heading">
            <h3 class="panel-title">Orders stuck in different statuses</h3>
          </div>
          <div class="panel-body panelMinHeight">
           <canvas id="doughnut" class="chart chart-doughnut"
			  chart-data="dataDounuts" chart-labels="labelsDounuts">
			</canvas>
          </div>
        </div>
        
        <div class="panel panel-info col-lg-6">
          <div class="panel-heading">
            <h3 class="panel-title">Orders stuck due to failure from Third Parties in last 10 Days</h3>
          </div>
          <div class="panel-body panelMinHeight">
           <canvas id="line" class="chart chart-line" chart-data="data"
			chart-labels="labels" chart-series="series" chart-options="options"
			chart-dataset-override="datasetOverride" chart-click="onClick"></canvas>
          </div>
        </div>
      </div>
      
</body>
</html>