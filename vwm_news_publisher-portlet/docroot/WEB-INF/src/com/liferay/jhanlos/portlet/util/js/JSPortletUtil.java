package com.liferay.jhanlos.portlet.util.js;

public class JSPortletUtil {
	
	public JSPortletUtil(String namespace) {
		setNamespace(namespace);
	}
	
	private void setNamespace(String namespace) {
		this.namespace = namespace;
	}
	
	public String getNamespace() {
		return namespace;
	}
		
	public String buildVarJSPortlet(String nameVar,Object valueVar){
		return "var "+namespace+nameVar+"="+valueVar+";";
	}
	
	private String namespace;
	
}
