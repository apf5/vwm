<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@ include file="/html/tracking/init.jsp" %>

<liferay-ui:tabs
	names="user-log,site-log,search-log,doc-log,Tab 3"
	refresh="<%=false%>"
>
	<!-- Jhanlos: En cada tab se incluyen los jsps respectivos -->
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de usuarios -->
		<liferay-util:include page="/html/tracking/user_log.jsp" servletContext="<%= application %>" />
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de sitios -->
		<liferay-util:include page="/html/tracking/site_log.jsp" servletContext="<%= application %>" />
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de busquedas -->
		<liferay-util:include page="/html/tracking/search_log.jsp" servletContext="<%= application %>" />
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de docuemntos -->
		<liferay-util:include page="/html/tracking/doc_log.jsp" servletContext="<%= application %>" />
	</liferay-ui:section>
	
	
	<!-- Jhanlos: incluir los JSPs para los estadisticos respectivos  -->
	<liferay-ui:section>
		Tab 3
	</liferay-ui:section>
	
		
</liferay-ui:tabs>