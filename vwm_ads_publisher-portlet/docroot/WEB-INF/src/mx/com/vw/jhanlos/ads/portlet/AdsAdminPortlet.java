package mx.com.vw.jhanlos.ads.portlet;

import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.ProcessAction;
import javax.portlet.WindowState;

/**
 * Portlet implementation class AdminAdsPortlet
 */
public class AdsAdminPortlet extends MVCPortlet {
	
	@ProcessAction(name="addMailbox")
	public void addMailbox(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		
		String cmd = ParamUtil.getString(uploadRequest, "cmd");
		
		System.out.println("cmd: "+cmd);
		
		if (cmd!=null && cmd.equals("add")) {
					
			
		    File mailboxIcon = (File) uploadRequest.getFile("mailboxIcon");
		    
		    String mailboxName =  ParamUtil.getString(uploadRequest,"mailboxName");
		    
		    String mailboxAdmins = ParamUtil.getString(uploadRequest,"mailboxAdmins");
		    
		    System.out.println("name: "+mailboxName+" admin: "+mailboxAdmins);
		    
		}
		
		actionResponse.setPortletMode(PortletMode.VIEW);
		actionResponse.setWindowState(WindowState.NORMAL);
		
	}
	
}
