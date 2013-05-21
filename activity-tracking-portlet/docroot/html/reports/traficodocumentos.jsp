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
			
		</style>
</head>
<body>
<div id="main">
			<div id="fields">
					<div class="date">
						 <label>Seleccionar: </label>            
						  <input type = "radio"
								 name = "radTipo"
								 id = "radCarga"
								 value = "carga"
								 checked = "checked" />
						  <label for = "radCarga">Carga</label>
						  <input type = "radio"
								 name = "radTipo"
								 id = "radDescarga"
								 value = "descarga" />
						  <label for = "radDescarga">Descarga</label>
						  
						  <input type="button" name="ver" id="bVer" value="Ver"/>
					</div>
			</div>
			<div id="tabla">
				<table class="bordered">
					<thead>

					<tr>
						<th>#</th>        
						<th>Nombre Documento</th>
						<th>Tipo</th>
						<th>Tamaño</th>
						<th>Fecha</th>
					</tr>
					</thead>
					<tbody><tr>
						<td>1</td>        
						<td>2013</td>
						<td>www.example.com</td>
						<td>1994</td>
						<td>1994</td>
					</tr>        
					<tr>
						<td>2</td>         
						<td>2012</td>
						<td>1972</td>
						<td>1994</td>
						<td>1994</td>
					</tr>
					<tr>

						<td>3</td>         
						<td>2011</td>
						<td>1974</td>
						<td>1994</td>
						<td>1994</td>
					</tr>    
					</tbody>
				</table>
			</div>
</div>
</body>
</html>