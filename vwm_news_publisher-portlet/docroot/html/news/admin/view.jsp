<%@page import="mx.com.vw.jhanlos.news.util.NewsUtil"%>
<%@page import="com.liferay.portal.service.OrganizationLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Organization"%>
<%@page import="java.util.List"%>
<%@page import="mx.com.vw.jhanlos.news.util.PortletKeys"%>
<%@page import="mx.com.vw.jhanlos.news.service.PropertieLocalServiceUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<portlet:defineObjects />


<%
 // renderRequest and portletConfig are objects which, accoring to the
 // portlet spec, are required to be in context. So they should just be 
 // there for you to use.
 Locale locale = renderRequest.getLocale();
 ResourceBundle res = portletConfig.getResourceBundle(locale);

 %>
 

<script type="text/javascript" src="/html/js/liferay/service.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript" >
	
	/*
	 * Jhanlos: Inicilizando parametros basicos de interaccion de portlet
	 * 
	 * 
	 */
	 
	 var currentNamespace="<portlet:namespace/>";
	  
			 	 
	 
</script>

<script type="text/javascript" >
		
	/*
	 * Jhanlos: variables de control del html
	 *
	 */
	var organizationsGroups=[];
	var structures=[];
	var templates=[];
	
	
	var currentGroup=-1;
	var currentStructure=-1;
	var currentTemplate={};
	
	
	
	$(function() {
		loadConfigFieldset();
	});
   
         
   function loadConfigFieldset(){
	   	   	
	   Liferay.Service.vwm_news.Propertie.getInitValues({}, 
		  function(data){
		   currentGroup=data[0].value;
		   currentStructure=data[1].value;
		   currentTemplate['m']=data[2].value;
		   currentTemplate['o']=data[3].value;
		   Liferay.Service.vwm_news.Propertie.getOrganizationsGroups({},buildOrganization);		    
	   });
	   
   }
   
   function buildOrganization(data){
	   organizationsGroups=$.parseJSON(data);
	   var orgs = organizationsGroups;
	   $("#organizationId").html("");
	   
	   enableButton("saveConfig",false);
	   
	   resetSelectInput("structureId");
	   
	   resetSelectInputTemplate();
	   
	   for ( var item=0;item < orgs.length; item++){
		   $("#organizationId").append(buildOption(orgs[item].groupId,orgs[item].name,(orgs[item].groupId==currentGroup)));  		   
	   }
	   
	   if (currentGroup==-1) {
		   currentGroup = organizationsGroups[0].groupId;
	   }
	   Liferay.Service.Journal.JournalStructure.getStructures({groupId:currentGroup},
			   buildStructures);
	   
   }
   
	function buildStructures(strc){
	   
	   structures=strc;
	   
	   $("#structureId").html("");
	   for ( var item=0;item < strc.length; item++){
		   $("#structureId").append(buildOption(strc[item].structureId,strc[item].name,currentStructure==strc[item].structureId));  		   
	   }
	   
	   
	   
	   if (0 < strc.length) {
		   if (currentStructure==-1) {
			   currentStructure = strc[0].structureId;
		   }
	  		 $("#structureId").removeAttr("disabled");
	   
	   		Liferay.Service.Journal.JournalTemplate.getStructureTemplates({
	   			groupId:currentGroup,
	   			structureId:currentStructure},
			   buildTemplates);
	   }
	   
   }
	
	function buildTemplates(data){
		   
		   buildTemplate('m',data);
		   buildTemplate('o',data);
		   if (0 < data.length) {
			   enableButton("saveConfig",true);
		   }
		   
	   }
	
	function buildTemplate(type,data){
		 
	   $("#templateId_"+type).html("");
	   for ( var item=0;item < data.length; item++){
		   $("#templateId_"+type).append(buildOption(data[item].templateId,data[item].name,currentTemplate[type]==data[item].templateId));  		   
	   }
	   if (0 < data.length) {
	   		$("#templateId_"+type).removeAttr("disabled");
	   }
	   
   }
   
	function onchangeOrganization(item){
		currentGroup = $(item).val();
		
		enableButton("saveConfig",false);
		   
	    resetSelectInput("structureId");
	   
	    resetSelectInputTemplate();
		
		currentStructure=-1;
		currentTemplate={m:-1,o:-1};
		
		Liferay.Service.Journal.JournalStructure.getStructures({groupId:currentGroup},
				   buildStructures);
	}
	
	function onchangeStructure(item){
		
		enableButton("saveConfig",false);
		currentStructure = $(item).val();
		
		resetSelectInputTemplate();
		
		currentTemplate={m:-1,o:-1};
		
		Liferay.Service.Journal.JournalTemplate.getStructureTemplates({
   			groupId:currentGroup,
   			structureId:currentStructure},
		   buildTemplates);
	}
	   
	function saveConfigFieldset(){
		$("#msg-error").hide();
		$("#msg-success").hide();
		enableButton("saveConfig",false);
		enableButton("resetConfig",false);
		Liferay.Service.vwm_news.Propertie.saveConfig({
			    groupId:$("#organizationId").val(),
				structureId:$("#structureId").val(),
				templateIdM:$("#templateId_m").val(),
				templateIdO:$("#templateId_o").val()
			},
			function(response){
				if (response.exception ) {
					showMessage("msg-error",response.exception);
					
				} else {
					var resp = $.parseJSON(response);
					showMessage("msg-success",resp.msg);
				}
				enableButton("saveConfig",true);
				enableButton("resetConfig",true);
		});
	}
</script>


<!-- Jhanlos: para manejar el contexto del portlet  -->
<script type="text/javascript" >   
      
   function getVal(name){
	   return window[currentNamespace+name];
   }
   
   function setVal(name,value){
	   window[currentNamespace+name]=value;
   }
   
</script>


<!-- Jhanlos: para manejar la interfaz  -->
<script type="text/javascript" >   
      
   function setLoading(parent){
	   $(parent).html("<div class='loading-animation'></div>");
   }
   
   function buildOption(id,name,isSelected){
	   var val="<option value='"+id+"'";
	   if (isSelected) {
		   val=val+" selected='selected' ";
	   }
	   val=val+">"+name+"</option>";
	   return val ;
   }
   
   function resetSelectInputTemplate(){
	   resetSelectInput("templateId_m");
	   resetSelectInput("templateId_o");
   }
   function resetSelectInput(id){
	    $("#"+id).html("");
		$("#"+id).append(buildOption("-1","            "),true);
		$("#"+id).attr("disabled", "disabled");
  }
   
   function showMessage(id,msg){
	   $("#"+id+"-span").html(msg);
	   $("#"+id).show();
	   setTimeout("$('#"+id+"').hide()",5000);
   }
   
   function enableButton(id,value){
	   if (value) {
		   $("#"+id+" span input[type='button']").removeAttr("disabled");
		   $("#"+id).removeClass("aui-button-disabled");
		} else {
		   $("#"+id+" span input[type='button']").attr("disabled", "disabled");
		   $("#"+id).addClass("aui-button-disabled");
		}
   }
</script>


<div >
    
    <div id="msg-error" class="portlet-msg-error" style="display: none;">
    	<%= res.getString("mensaje-erro") %> <span id="msg-error-span"></span>
    </div>
    
    <div id="msg-success" class="portlet-msg-success" style="display: none;">
    	<%= res.getString("mensaje-succes") %> <span id="msg-success-span"></span>
    </div>
   
	<fieldset id="main_news">
		<legend><%= res.getString("Legenda") %></legend>
		
		<table>
			<tr>
				<td><label for="organizationId" ><%= res.getString("organizacion") %></label>
				</td>
				<td><select id="organizationId" onchange="onchangeOrganization(this)" ></select>
				</td>
			</tr>
			
			<tr>
				<td><label for="structureId" ><%= res.getString("estructura") %></label>
				</td>
				<td><select id="structureId" onchange="onchangeStructure(this)" ></select>
				</td>
			</tr>
			
			<tr>
				<td><label for="templateId_m" ><%= res.getString("Plantilla-principal") %></label>
				</td>
				<td><select id="templateId_m" ></select>
				</td>
			</tr>
			
			<tr>
				<td><label for="templateId_o" ><%= res.getString("Plantilla-secundaria") %></label>
				</td>
				<td><select id="templateId_o" ></select>
				</td>
			</tr>
		</table>
		
		
		
		
	</fieldset>
	
	<div style="padding-top: 10px;" >
		
		<!-- aui-button-disabled  -->
		<span class="aui-button delete-articles-button" id="resetConfig"> 
			<span class="aui-button-content"> 
				<input class="aui-button-input" onclick="loadConfigFieldset()" type="button"  value="<%=res.getString("recargar-apartado") %>" />
			</span>
		</span>
		
		<span class="aui-button delete-articles-button" id="saveConfig"> 
			<span class="aui-button-content"> 
				<input class="aui-button-input" onclick="saveConfigFieldset()" type="button" value="<%= res.getString("guardar-cambios") %>" />
			</span>
		</span>
		
	</div>
	
	
</div>




 
