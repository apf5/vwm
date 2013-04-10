<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
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
	 /*
		 * Jhanlos: variables de control del html
		 *
		 */
			
		var currentGroup=-1;
		var currentStructure=-1;
		var currentTemplate=-1;
		
		
		
		$(function() {
			loadConfigFieldset();
		});
	   
	         
	   function loadConfigFieldset(){
		   	   	
		   Liferay.Service.vwm_ads.Propertie.getInitValues({}, 
			  function(data){
			   
			   currentGroup=data[0].value;
			   currentStructure=data[1].value;
			   currentTemplate=data[2].value;
			   Liferay.Service.vwm_ads.Propertie.getOrganizationsGroups({},buildOrganization);		    
		   });
		   
	   }
	   
	   function buildOrganization(data){
		   
		   var orgs=$.parseJSON(data);
		   
		   $("#organizationId").html("");
		   
		   enableButton("saveConfig",false);
		   
		   resetSelectInput("structureId");
		   
		   resetSelectInput("templateId");
		   
		   for ( var item=0;item < orgs.length; item++){
			   $("#organizationId").append(buildOption(orgs[item].groupId,orgs[item].name,(orgs[item].groupId==currentGroup)));  		   
		   }
		   
		   if (currentGroup==-1) {
			   currentGroup = orgs[0].groupId;
		   }
		   Liferay.Service.Journal.JournalStructure.getStructures({groupId:currentGroup},
				   buildStructures);
		   
	   }
	   
		function buildStructures(strc){
		   
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
			
			$("#templateId").html("");
			for ( var item=0;item < data.length; item++){
				   $("#templateId").append(buildOption(data[item].templateId,data[item].name,currentTemplate==data[item].templateId));  		   
			}
			if (0 < data.length) {
				  enableButton("saveConfig",true);
				  $("#templateId").removeAttr("disabled");
			}
			   
		}
		
			   
		function onchangeOrganization(item){
			currentGroup = $(item).val();
			
			enableButton("saveConfig",false);
			   
		    resetSelectInput("structureId");
		   
		    resetSelectInput("templateId");
			
			currentStructure=-1;
			currentTemplate=-1;
			
			Liferay.Service.Journal.JournalStructure.getStructures({groupId:currentGroup},
					   buildStructures);
		}
		
		function onchangeStructure(item){
			
			enableButton("saveConfig",false);
			currentStructure = $(item).val();
			
			resetSelectInput("templateId");
			
			currentTemplate=-1;
			
			Liferay.Service.Journal.JournalTemplate.getStructureTemplates({
	   			groupId:currentGroup,
	   			structureId:currentStructure},
			   buildTemplates);
		}
		   
		function saveConfigFieldset(){
			$("#msg-error-config").hide();
			$("#msg-success-config").hide();
			enableButton("saveConfig",false);
			enableButton("resetConfig",false);
			Liferay.Service.vwm_ads.Propertie.saveConfig({
				    groupId:$("#organizationId").val(),
					structureId:$("#structureId").val(),
					templateId:$("#templateId").val()
				},
				function(response){
					if (response.exception ) {
						showMessage("msg-error-config",response.exception);
						
					} else {
						var resp = $.parseJSON(response);
						showMessage("msg-success-config",resp.msg);
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

<%
	String tabNames = res.getString("ads-mailbox-admin")+", "+res.getString("ads-settings");
%>

<liferay-ui:tabs
	names="<%=tabNames %>"
	refresh="<%= false %>"
>

	<liferay-ui:section>
		sample 1
	</liferay-ui:section>
	
	
	
	<liferay-ui:section>
		
		<div >
		    
		    <div id="msg-error-config" class="portlet-msg-error" style="display: none;">
		    	<%= res.getString("msg-error") %> <span id="msg-error-config-span"></span>
		    </div>
		    
		    <div id="msg-success-config" class="portlet-msg-success" style="display: none;">
		    	<%= res.getString("msg-success") %> <span id="msg-success-config-span"></span>
		    </div>
		   
			<fieldset id="main_config">
				<legend><%= res.getString("legend-config") %></legend>
				
				<table>
					<tr>
						<td><label for="organizationId" ><%= res.getString("organization") %></label>
						</td>
						<td><select id="organizationId" onchange="onchangeOrganization(this)" ></select>
						</td>
					</tr>
					
					<tr>
						<td><label for="structureId" ><%= res.getString("structure") %></label>
						</td>
						<td><select id="structureId" onchange="onchangeStructure(this)" ></select>
						</td>
					</tr>
					
					<tr>
						<td><label for="templateId" ><%= res.getString("template") %></label>
						</td>
						<td><select id="templateId" ></select>
						</td>
					</tr>
					
				</table>
				
				
				
				
			</fieldset>
			
			<div style="padding-top: 10px;" >
				
				<!-- aui-button-disabled  -->
				<span class="aui-button delete-articles-button" id="resetConfig"> 
					<span class="aui-button-content"> 
						<input class="aui-button-input" onclick="loadConfigFieldset()" type="button"  value="<%=res.getString("reload-form") %>" />
					</span>
				</span>
				
				<span class="aui-button delete-articles-button" id="saveConfig"> 
					<span class="aui-button-content"> 
						<input class="aui-button-input" onclick="saveConfigFieldset()" type="button" value="<%= res.getString("save-changes") %>" />
					</span>
				</span>
				
			</div>
			
			
		</div>		
	</liferay-ui:section>
	
	
</liferay-ui:tabs>