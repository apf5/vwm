<%@page import="com.liferay.consistent.tracking.model.Browser"%>
<%@page import="com.liferay.consistent.tracking.service.OSLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.OS"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.consistent.tracking.service.BrowserLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.service.impl.BrowserLocalServiceImpl"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/tracking/init.jsp" %>

<h1>Navegadores </h1>
		<liferay-ui:search-container 
		searchContainer="<%=new SearchContainer<Browser>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	<liferay-ui:search-container-results >
		<%
				 List<Browser> browserList = (List<Browser>) BrowserLocalServiceUtil.getBrowsers(-1, -1);
		         results = ListUtil.subList(browserList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = browserList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   %>
	   </liferay-ui:search-container-results>
	   <liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.Browser" modelVar="browser" >
				
				<liferay-ui:search-container-column-text name="Name"  property="name" />
				<liferay-ui:search-container-column-text name="Version"  property="version" />
				<liferay-ui:search-container-column-text name="Fecha de Salida"
					value="<%= dateFormat.format(calendar.getTime()) %>"  />
				 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	   </liferay-ui:search-container>
	   
	   <!-- Sistema Operativo -->
	   <h1>Sistema Operativo </h1>
	   <liferay-ui:search-container 
		searchContainer="<%=new SearchContainer<OS>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	<liferay-ui:search-container-results >
		<%
		List<OS> OSList = (List<OS>) OSLocalServiceUtil.getOSs(-1, -1);
		         results = ListUtil.subList(OSList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = OSList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   %>
	   </liferay-ui:search-container-results>
	   <liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.OS" modelVar="os" >
				
				<liferay-ui:search-container-column-text name="Name"  property="name" />
				<liferay-ui:search-container-column-text name="Version"  property="version" />
				<liferay-ui:search-container-column-text name="Fecha de Salida"
					value="<%= dateFormat.format(calendar.getTime()) %>"  />	 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	   </liferay-ui:search-container>