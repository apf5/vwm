<html>
<head>
<title>
Maqueta WVM
</title>
<style>
			#navbar{
			width:auto;
			height:36px;
			background:url(img/navbar-bg.png) left top repeat-x; }
			#navbar .inbar{
			display:block;
			height:36px;
			background:url(img/right-round.png) right top no-repeat; }
			#navbar ul, #navbar ul li{
			border:0px;
			margin:0px;
			padding:0px;
			list-style:none;
			height:36px;
			line-height:36px; } #navbar ul{
			background:url(img/left-round.png) left top no-repeat; }
			#navbar ul li{
			float:left;
			display:block;
			line-height:36px; }
			#navbar ul li a{
			color:#403e32;
			text-decoration:none;
			font-weight:bold;
			display:block; }
			#navbar ul li a span{
			padding:0 20px 0 0;
			height:36px;
			line-height:36px;
			display:block;
			margin-left:20px; }
			#navbar .navhome a, #navbar .navhome a:hover{
			background:url(img/a-bg.png) left top no-repeat;
			height:36px;
			line-height:36px; }
			#navbar .navhome a span, #navbar .navhome a:hover span{
			color:#FFFFFF;
			background:url(img/span-bg.png) right top no-repeat;
			height:36px;
			line-height:36px; }
			#navbar ul li a:hover{
			background:url(img/ahover-bg.png) left top no-repeat;
			height:36px;
			line-height:36px; }
			#navbar ul li a:hover span{
			background:url(img/spanhover-bg.png) right top no-repeat;
			height:36px;
			line-height:36px; }
			/* Menú Vertical
			----------------------------------------------- */
			#menuvert ul {
			list-style-type: none;
			margin: 0px;
			padding: 0px;
			width: 200px; /* ancho del menú */
			font-size: 11pt;
			}
			#menuvert ul li {
			background: url(img/navbar-bg.png) #B0CBDD; /* color de fondo del menú */
			padding: 0px;
			}
			#menuvert ul li a {
			color: #000; /* color de las letras */
			text-decoration: none;
			display: block;
			padding: 10px 10px 10px 20px;
			}
			#menuvert ul li a:hover {
			background: gray; /* color del botón al pasar el cursor */
			border-left: 5px solid #FFF; /* color del rectángulo junto al título */
			color: #FFFFFF; /* color de las letras al pasar el cursor */
			}
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
            });
        </script>
</head>
<body>
<div id="main">
	<div id="main-left" style="float:left; width:20%; height:100px; padding: 50px 0 0 10px">
		<div id="menuvert">
		<ul>
		<li><a href="URL del enlace">Título 1</a></li>
		<li><a href="URL del enlace">Título 2</a></li>
		<li><a href="URL del enlace">Título 3</a></li>
		<li><a href="URL del enlace">Título 4</a></li>
		</ul>
		</div>
	</div>
	<div id="main-right" style="float:left; width:60%">
	
		<div id="navbar">
		<span class="inbar">
		<ul>
			<li class="navhome"><a href="#"><span>Trafico del portal</span></a></li>
			<li><a href="#"><span>Trafico Usuarios</span></a></li>
			<li><a href="#"><span>SO y Browsers</span></a></li>
			<li><a href="#"><span>Detalle usuarios</span></a></li>
		</ul>
		</span>

		</div>
		<div>
		<table>
		<thead><tr><th>head</th></tr></thead>
		<tbody><tr><td>body</td></tr></tbody>
		</table>
		</div>
		<div id="chartdiv" style="width: 100%; height: 400px;"></div>
	</div>
</div>
</body>
</html>