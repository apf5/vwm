<%@page import="com.liferay.consistent.tracking.service.SiteHitLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.SiteHit"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/tracking/init.jsp" %>

<h1>Sitios</h1>
		<liferay-ui:search-container 
		searchContainer="<%=new SearchContainer<SiteHit>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<SiteHit> siteList = (List<SiteHit>)SiteHitLocalServiceUtil.getSiteHits(-1, -1);
		     	 results = ListUtil.subList(siteList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = siteList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		<%=siteList %>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.SiteHit"  modelVar="SiteHit" >
				
				<liferay-ui:search-container-column-text name="Id"  property="hitId" />
				<liferay-ui:search-container-column-text name="Nombre de usuario"  property="siteId" />
				<liferay-ui:search-container-column-text name="Hora"  value="<%= dateFormat.format(SiteHit.getAccessDate()) %>" />
								 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>