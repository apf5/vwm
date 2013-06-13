
<%@page import="com.liferay.consistent.tracking.service.PhraseLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.Phrase"%>
<%@page import="com.liferay.consistent.tracking.service.WordLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.Word"%>
<%@page import="com.liferay.consistent.tracking.service.SearchPhraseHitLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.service.SearchPhraseHitLocalService"%>
<%@page import="com.liferay.consistent.tracking.model.SearchPhraseHit"%>
<%@page import="com.liferay.consistent.tracking.service.SearchWordHitLocalServiceUtil"%>
<%@page import="com.liferay.consistent.tracking.model.SearchWordHit"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/tracking/init.jsp" %>
<h1>Búsquedas por Palabra</h1>
		<liferay-ui:search-container curParam="cursearchpal"
		searchContainer="<%=new SearchContainer<SearchWordHit>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<SearchWordHit> searchWordList = (List<SearchWordHit>)SearchWordHitLocalServiceUtil.getSearchWordHits(-1, -1);
				 results = ListUtil.subList(searchWordList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = searchWordList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.SearchWordHit" modelVar="SearchWordHit" keyProperty="wordId" >
				
				<liferay-ui:search-container-column-text name="Id"  property="hitId" />
				<liferay-ui:search-container-column-text name="Id-Palabra"  property="wordId" />
				<liferay-ui:search-container-column-text name="Hora"  value="<%= dateFormat.format(SearchWordHit.getAccessDate()) %>" />
				
								 
			</liferay-ui:search-container-row>
						
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>
		
		<liferay-ui:search-container curParam="cursearchpal2"
		searchContainer="<%=new SearchContainer<Word>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<Word> wordList = (List<Word>)WordLocalServiceUtil.getWords(-1, -1);
				 results = ListUtil.subList(wordList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = wordList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.Word" modelVar="Word" keyProperty="wordId" >
				<liferay-ui:search-container-column-text name="Nombre"  property="wordName" />
			</liferay-ui:search-container-row>
						
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>
		
<h1>Búsquedas por Frase</h1>
		<liferay-ui:search-container curParam="cursearchfrase"
		searchContainer="<%=new SearchContainer<SearchPhraseHit>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<SearchPhraseHit> searchPhraseList = (List<SearchPhraseHit>)SearchPhraseHitLocalServiceUtil.getSearchPhraseHits(-1, -1);
		         results = ListUtil.subList(searchPhraseList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = searchPhraseList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.SearchPhraseHit"  modelVar="SearchPhraseHit" >
				
				<liferay-ui:search-container-column-text name="Id"  property="hitId" />
				<liferay-ui:search-container-column-text name="Id-Frase"  property="phraseId" />
				<liferay-ui:search-container-column-text name="Hora"  value="<%= dateFormat.format(SearchPhraseHit.getAccessDate()) %>" />
								 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>
		
		<liferay-ui:search-container curParam="cursearchfrase2"
		searchContainer="<%=new SearchContainer<Phrase>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, 20, portletURL, null, msg) %>"
	 	>
	 		<liferay-ui:search-container-results >
			<%
				 List<Phrase> PhraseList = (List<Phrase>)PhraseLocalServiceUtil.getPhrases(-1, -1);
		         results = ListUtil.subList(PhraseList, searchContainer.getStart(), searchContainer.getEnd()); 
	             total = PhraseList.size();
				 pageContext.setAttribute("results", results);
	       		 pageContext.setAttribute("total", total);
	   		%>
	   		</liferay-ui:search-container-results>
	   		
	   		<liferay-ui:search-container-row
				className="com.liferay.consistent.tracking.model.Phrase"  modelVar="Phrase" >
				
				<liferay-ui:search-container-column-text name="Id"  property="phraseId" />
				<liferay-ui:search-container-column-text name="Frase"  property="phraseName" />
				
								 
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator  paginate="true" />
	 		
		</liferay-ui:search-container>