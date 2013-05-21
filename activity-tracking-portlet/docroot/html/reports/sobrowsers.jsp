<html>
<head>
<title>
Maqueta WVM
</title>
<style>
		#main{ font-family: sans-serif; font-size: 12px;}
		#tabla{
			padding: 20px 40px;
		}
		table {
		font-size: 12px;
				*border-collapse: collapse; /* IE7 and lower */
				border-spacing: 0;
				width: 100%;    
			}
			.bordered {
				border: solid #ccc 1px;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				-webkit-box-shadow: 0 1px 1px #ccc; 
				-moz-box-shadow: 0 1px 1px #ccc; 
				box-shadow: 0 1px 1px #ccc;         
			}
			.bordered tr:hover {
				background: #fbf8e9;
				-o-transition: all 0.1s ease-in-out;
				-webkit-transition: all 0.1s ease-in-out;
				-moz-transition: all 0.1s ease-in-out;
				-ms-transition: all 0.1s ease-in-out;
				transition: all 0.1s ease-in-out;     
			}    	
			.bordered td, .bordered th {
				border-left: 1px solid #ccc;
				border-top: 1px solid #ccc;
				padding: 10px;
				text-align: left;    
			}
			.bordered th {
				background-color: #dce9f9;
				background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
				background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image:    -moz-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image:     -ms-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image:      -o-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image:         linear-gradient(top, #ebf3fc, #dce9f9);
				-webkit-box-shadow: 0 1px 0 rgba(255,255,255,.8) inset; 
				-moz-box-shadow:0 1px 0 rgba(255,255,255,.8) inset;  
				box-shadow: 0 1px 0 rgba(255,255,255,.8) inset;        
				border-top: none;
				text-shadow: 0 1px 0 rgba(255,255,255,.5); 
			}
			.bordered td:first-child, .bordered th:first-child {
				border-left: none;
			}
			.bordered th:first-child {
				-moz-border-radius: 6px 0 0 0;
				-webkit-border-radius: 6px 0 0 0;
				border-radius: 6px 0 0 0;
			}
			.bordered th:last-child {
				-moz-border-radius: 0 6px 0 0;
				-webkit-border-radius: 0 6px 0 0;
				border-radius: 0 6px 0 0;
			}
			.bordered th:only-child{
				-moz-border-radius: 6px 6px 0 0;
				-webkit-border-radius: 6px 6px 0 0;
				border-radius: 6px 6px 0 0;
			}
			.bordered tr:last-child td:first-child {
				-moz-border-radius: 0 0 0 6px;
				-webkit-border-radius: 0 0 0 6px;
				border-radius: 0 0 0 6px;
			}
			.bordered tr:last-child td:last-child {
				-moz-border-radius: 0 0 6px 0;
				-webkit-border-radius: 0 0 6px 0;
				border-radius: 0 0 6px 0;
			}
			/*----------------------*/
			#alluser{
				padding: 20px 0 20px 40px;
				text-align:left;
				font-size: 13px;
				font-weight: bold;
				
			}
			#hline {
				margin:10px 15%;
				border-bottom: solid #CCCCCC;
				border-bottom-width: 8px;
				width: 70%;
			}
			#user-up{
				
			}
			.date{
				padding:10px 0 10px 40px; 
				
			}
			.date label{
				width: 100px;
				display: inline-block;	
			}
			.date input[type="date"]{
				font-family: sans-serif;
				color:gray;
			}
			.date input[type="button"]{
				padding:5px;
				width: 80px;
				background-color: #dce9f9;
				background-image: -webkit-gradient(linear, left top, left bottom, from(#ebf3fc), to(#dce9f9));
				background-image: -webkit-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image: -moz-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image: -ms-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image: -o-linear-gradient(top, #ebf3fc, #dce9f9);
				background-image: linear-gradient(top, #ebf3fc, #dce9f9);
				
				font-weight:bold;
			}
			#chartdiv{
				padding:20px 40px;
				height: 400px;
			}
			#chartdiv2{
				padding:20px 40px;
				height: 400px;
			}
			#left{widht:50%; float:left;}
			#right{widht:50%; float:left;}
		</style>
<script src="../../js/amcharts.js" type="text/javascript"></script>        
        <script type="text/javascript">
            var chart;
            var chartData = [{
                country: "organizacion 1",
                visits: 4025,
                color: "#FF0F00"
            }, {
                country: "organizacion 2",
                visits: 1882,
                color: "#FF6600"
            }, {
                country: "organizacion 3",
                visits: 1809,
                color: "#FF9E01"
            }, {
                country: "organizacion 4",
                visits: 1322,
                color: "#FCD202"
            }, {
                country: "Grupo 1",
                visits: 1122,
                color: "#F8FF01"
            }, {
                country: "Grupo 2",
                visits: 1114,
                color: "#B0DE09"
            }, {
                country: "Grupo 3",
                visits: 984,
                color: "#04D215"
            }, {
                country: "Grupo 4",
                visits: 711,
                color: "#0D8ECF"
            }, {
                country: "Grupo 5",
                visits: 665,
                color: "#0D52D1"
            }, {
                country: "Grupo 6",
                visits: 580,
                color: "#2A0CD0"
            }];


            AmCharts.ready(function () {
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.dataProvider = chartData;
                chart.categoryField = "country";
                // the following two lines makes chart 3D
                chart.depth3D = 20;
                chart.angle = 30;

                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.labelRotation = 90;
                categoryAxis.dashLength = 5;
                categoryAxis.gridPosition = "start";

                // value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.title = "Usuarios";
                valueAxis.dashLength = 5;
                chart.addValueAxis(valueAxis);

                // GRAPH            
                var graph = new AmCharts.AmGraph();
                graph.valueField = "visits";
                graph.colorField = "color";
                graph.balloonText = "[[category]]: [[value]]";
                graph.type = "column";
                graph.lineAlpha = 0;
                graph.fillAlphas = 1;
                chart.addGraph(graph);

                // WRITE
                chart.write("chartdiv");
				chart.write("chartdiv2");
            });
        </script>
</head>
<body>
<div id="main">
		<div id="left">
			<div id="tabla">
				<table class="bordered">
					<thead>

					<tr>
						<th>#</th>        
						<th>Sistema Operativo</th>
						<th>Version</th>
					</tr>
					</thead>
					<tbody><tr>
						<td>1</td>        
						<td>IE</td>
						<td>9</td>
					</tr>        
					<tr>
						<td>2</td>         
						<td>Firefox</td>
						<td>20</td>
					</tr>
					<tr>

						<td>3</td>         
						<td>2011</td>
						<td>1974</td>
					</tr>    
					</tbody>
				</table>
			</div>
		<div id="chartdiv"></div>	
		</div>
		<div id="right">
			<div id="tabla">
				<table class="bordered">
					<thead>

					<tr>
						<th>#</th>        
						<th>Navegador</th>
						<th>Version</th>
					</tr>
					</thead>
					<tbody><tr>
						<td>1</td>        
						<td>IE</td>
						<td>9</td>
					</tr>        
					<tr>
						<td>2</td>         
						<td>Firefox</td>
						<td>20</td>
					</tr>
					<tr>

						<td>3</td>         
						<td>2011</td>
						<td>1974</td>
					</tr>    
					</tbody>
				</table>
			</div>
		<div id="chartdiv1"></div>	
		</div>
</div>
</body>
</html>