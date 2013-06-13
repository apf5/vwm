<%@page import="com.liferay.consistent.tracking.service.FilelogLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.Filelog"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/tracking/init.jsp" %>



<h1>Documentos</h1>
		<liferay-ui:search-container 
		searchContainer="<%=new SearchContainer<Filelog>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<Filelog> docList = (List<Filelog>)FilelogLocalServiceUtil.getFilelogs(-1, -1);
		         results = ListUtil.subList(docList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = docList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.Filelog"  modelVar="Filelog" >
				
				<liferay-ui:search-container-column-text name="Id"  property="FilelogId" />
				<liferay-ui:search-container-column-text name="Nombre de usuario"  property="fileVersion" />
				<liferay-ui:search-container-column-text name="Hora"  value="<%= dateFormat.format(Filelog.getAccessDate()) %>" />
								 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>
