<%@page import="com.liferay.portlet.asset.service.AssetEntryServiceUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="mx.com.vw.jhanlos.news.model.Propertie"%>
<%@page import="mx.com.vw.jhanlos.news.util.PortletKeys"%>
<%@page import="com.liferay.portlet.layoutconfiguration.util.RuntimePortletUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="mx.com.vw.jhanlos.news.service.PropertieLocalServiceUtil"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	Propertie organization = null;
		Propertie structure = null;
		Propertie template = null;
		
		try {
			organization = PropertieLocalServiceUtil.getValue(PortletKeys.CURRENT_GROUP,-1);
			
			structure = PropertieLocalServiceUtil.getValue(PortletKeys.CURRENT_STRUCTURE,-1);
			
			template = PropertieLocalServiceUtil.getValue(PortletKeys.CURRENT_TEMPLATE_MAIN,-1);
	
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<JournalArticle> journalArticles = 
		JournalArticleLocalServiceUtil
		.getStructureArticles(Long.valueOf(organization.getValue()), structure.getValue());

		
		
		for(JournalArticle article:journalArticles){
			JournalArticleDisplay articleDisplay = 
			JournalArticleLocalServiceUtil
			.getArticleDisplay(Long.valueOf(organization.getValue()),
			article.getArticleId(), template.getValue(), "VIEW", LanguageUtil.getLanguageId(request), themeDisplay);
			
			AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), articleDisplay.getResourcePrimKey());
%>
						
						
						<div class="journal-content-article" id="article_<%= articleDisplay.getCompanyId() %>_<%= articleDisplay.getGroupId() %>_<%= articleDisplay.getArticleId() %>_<%= articleDisplay.getVersion() %>">
							<%= RuntimePortletUtil.processXML(application, request, response, renderRequest, renderResponse, articleDisplay.getContent()) %>
						</div>
						
						
						<div class="taglib-ratings-wrapper">
							<liferay-ui:ratings
								className="<%= JournalArticle.class.getName() %>"
								classPK="<%= articleDisplay.getResourcePrimKey() %>"
							/>
						</div>

<%
		}
	
%>




