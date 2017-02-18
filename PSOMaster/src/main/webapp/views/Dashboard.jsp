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
      	 <div class="panel panel-info col-lg-12">
          <div class="panel-heading">
            <h3 class="panel-title">Stuck Order backlogs in last 10 Days</h3>
          </div>
          <div class="panel-body panelMinHeight" ng-init="accordion=2">
			<!--  <canvas id="bar" class="chart chart-bar"
			  chart-data="dataBar" chart-labels="labelsBar" chart-series="seriesBar">
			</canvas>
			<table class="marTop20">
				<tbody><tr><td ng-repeat="st in seriesBar" ><span style="color: {{seriesColors[seriesBar.indexOf(st)]}}" class="glyphicon glyphicon-stop  marLeft40 marRight5"></span>{{st}}</td></tr></tbody>
			</table> -->
			
			 <ul class="nav nav-tabs">
                <li ng-class="{active:accordion==0}"><a data-toggle="tab" ng-click="accordion = 0">1 Jan</a></li>
                <li ng-class="{active:accordion==1}"><a data-toggle="tab" ng-click="accordion = 1">2 Jan</a></li>
                <li ng-class="{active:accordion==2}"><a data-toggle="tab" ng-click="accordion = 2">3 Jan</a></li>
              </ul>
              <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade active in" id="home" ng-show="accordion==0">
                  <!-- <p>Raw denim you probably haven't heard of them jean shorts Austin. Nesciunt tofu stumptown aliqua, retro synth master cleanse. Mustache cliche tempor, williamsburg carles vegan helvetica. Reprehenderit butcher retro keffiyeh dreamcatcher synth. Cosby sweater eu banh mi, qui irure terry richardson ex squid. Aliquip placeat salvia cillum iphone. Seitan aliquip quis cardigan american apparel, butcher voluptate nisi qui.</p> -->
                  
                  <!-- <canvas id="bar" class="chart chart-bar"
			  chart-data="dataBar" chart-labels="labelsBar" chart-series="seriesBar">
			</canvas> -->
						 <div fusioncharts id="test1"
					       width="600"
					       height="400"
					       type="column2d"
					       dataSource="{{myDataSource}}" >
					    </div>
			
                  
                </div>
                <div class="tab-pane fade active in" id="profile" ng-show="accordion==1">
                  <!-- <p>Food truck fixie locavore, accusamus mcsweeney's marfa nulla single-origin coffee squid. Exercitation +1 labore velit, blog sartorial PBR leggings next level wes anderson artisan four loko farm-to-table craft beer twee. Qui photo booth letterpress, commodo enim craft beer mlkshk aliquip jean shorts ullamco ad vinyl cillum PBR. Homo nostrud organic, assumenda labore aesthetic magna delectus mollit.</p> -->
                  
                  <!-- <canvas id="bar" class="chart chart-bar"
			  chart-data="dataBar" chart-labels="labelsBar" chart-series="seriesBar">
			</canvas> -->
			
						<div fusioncharts id="test2"
					       width="600"
					       height="400"
					       type="column2d"
					       dataSource="{{myDataSource2}}" >
					    </div>
			
                  
                </div>
                <div class="tab-pane fade active in" id="dropdown1" ng-show="accordion==2">
                  <!-- <p>Etsy mixtape wayfarers, ethical wes anderson tofu before they sold out mcsweeney's organic lomo retro fanny pack lo-fi farm-to-table readymade. Messenger bag gentrify pitchfork tattooed craft beer, iphone skateboard locavore carles etsy salvia banksy hoodie helvetica. DIY synth PBR banksy irony. Leggings gentrify squid 8-bit cred pitchfork.</p> -->
                  
                  <div fusioncharts id="test3"
					       width="600"
					       height="400"
					       type="column2d"
					       dataSource="{{myDataSource3}}" >
					    </div>
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
           <canvas id="pie" class="chart chart-pie"
			  chart-data="dataPie" chart-labels="labelsPie" chart-options="options">
			</canvas> 
          </div>
        </div>
        
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
      </div>
      
      <!--  <div class="row" class="col-lg-12">
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
      </div> -->
      
</body>
</html>