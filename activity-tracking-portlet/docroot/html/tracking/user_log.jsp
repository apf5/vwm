<%@page import="com.liferay.consistent.tracking.model.Userlog"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.service.UserlogLocalService"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.consistent.tracking.service.UserlogLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.Userlog"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/tracking/init.jsp" %>

<h1>Usuarios</h1>
		<%
				 List<Userlog> userList1 = (List<Userlog>)UserlogLocalServiceUtil.getUserlogs(-1, -1);%>

		<liferay-ui:search-container 
		searchContainer="<%=new SearchContainer<Userlog>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<Userlog> userList = (List<Userlog>)UserlogLocalServiceUtil.getUserlogs(-1, -1);
		         results = ListUtil.subList(userList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = userList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.Userlog"  modelVar="Userlog" >
				
				<liferay-ui:search-container-column-text name="Id"  property="userlogId" />
				<liferay-ui:search-container-column-text name="Nombre de usuario"  property="userName" />
				<liferay-ui:search-container-column-text name="Direccion remota"  property="remoteAddress" />
				<liferay-ui:search-container-column-text name="Hora inicial"  value="<%= timeFormat.format(Userlog.getAccessDate()) %>" />
				<liferay-ui:search-container-column-text name="Hora final"  value="<%= (timeFormat.format(Userlog.getAccessDate()+ Userlog.getTimeSlapse()))%>" />
				<liferay-ui:search-container-column-text name="time slapsse"  value="<%=timeFormat.format(Userlog.getTimeSlapse())%>" />
				
												 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	 	
<html>
<head>


<script src="/activity-tracking-portlet/js/amcharts.js" type="text/javascript"></script>        
        <script type="text/javascript">
        
               
var data=new Array();
        
        var nombre = "<%=userList1%>";
        <%
        for(int j=0 ; j < userList1.size();j++){
        	double f=Math.random()*10;
        	double g=Math.random()*10;
        	double h=Math.random()*10;
        	String a=toString().valueOf(f);
        	String b=toString().valueOf(g);
        	String c=toString().valueOf(h);
        	
        %>  
         var obj = {
           user: "<%=userList1.get(j).getUserName()%>",
           tiempo: "<%=userList1.get(j).getTimeSlapse()%>",
           color: "#c"+"<%=a%>"+"a"+"<%=b%>"+"c"+"<%=c%>"
           
           };
         data.push(obj);
        <% 
        }
        %>
                       
            AmCharts.ready(function () {
            	
            	
                // SERIAL CHART
                chart = new AmCharts.AmSerialChart();
                chart.pathToImages = "<c:url value='<%="/js/images/"%>'/>";
                chart.dataProvider = data;
                chart.categoryField = "user";
                
                // the following two lines makes chart 3D
                
                chart.depth3D = 20;
                chart.angle = 30;
                var chartScrollbar = new AmCharts.ChartScrollbar();
                chartScrollbar.dragIconWidth=11;
                chart.addChartScrollbar(chartScrollbar);
                
                // AXES
                // category
                var categoryAxis = chart.categoryAxis;
                categoryAxis.labelRotation = 90;
                categoryAxis.dashLength = 5;
                categoryAxis.gridPosition = "start";

                // value
                var valueAxis = new AmCharts.ValueAxis();
                valueAxis.title = "tiempo";
                valueAxis.dashLength = 5;
                chart.addValueAxis(valueAxis);

                // GRAPH            
                var graph = new AmCharts.AmGraph();
                graph.valueField = "tiempo";
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
		<div id="chartdiv" style="width: 100%; height: 400px;">
			
			
			
		</div>
</div>
</body>
</html>
</liferay-ui:search-container>