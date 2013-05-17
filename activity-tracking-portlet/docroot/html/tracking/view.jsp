
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<portlet:defineObjects />


<liferay-ui:tabs
	names="user-log,site-log,search-log,doc-log"
	refresh="<%=false%>"
>
	<!-- Jhanlos: En cada tab se incluyen los jsps respectivos -->
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de usuarios -->
		<jsp:include page="/html/tracking/user_log.jsp"></jsp:include>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de sitios -->
		<jsp:include page="/html/tracking/site_log.jsp"></jsp:include>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de busquedas -->
		<jsp:include page="/html/tracking/search_log.jsp"></jsp:include>
	</liferay-ui:section>
	
	<liferay-ui:section>
		<!-- Jhanlos: JSP de registros de monitoreo de docuemntos -->
		<jsp:include page="/html/tracking/doc_log.jsp"></jsp:include>
	</liferay-ui:section>
	
	
	<!-- Jhanlos: incluir los JSPs para los estadisticos respectivos  -->
	<liferay-ui:section>
		Tab 3
	</liferay-ui:section>
	
		
</liferay-ui:tabs>