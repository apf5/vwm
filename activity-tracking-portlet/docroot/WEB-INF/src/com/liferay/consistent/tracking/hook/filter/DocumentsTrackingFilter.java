package com.liferay.consistent.tracking.hook.filter;

import com.liferay.consistent.tracking.model.Filelog;
import com.liferay.consistent.tracking.service.FilelogLocalServiceUtil;
import com.liferay.consistent.tracking.util.PortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.PortalSessionThreadLocal;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFileShortcut;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;


import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hsqldb.lib.StopWatch;

/**
 * 
 * @author Jorge Loayza
 *
 */

public class DocumentsTrackingFilter implements Filter {

	@Override
	public void destroy() {
				
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		
		/* Filtrar urls de este tipo
		 * 
		 * http://localhost:8080/c/document_library/get_file?uuid=2e2894f4-45fb-47b4-b4c1-616136205a1c&groupId=18
		 * 
		 * <a href='<%=themeDisplay.getPortalURL()+
				"/c/document_library/get_file?uuid="+dlFileEntry.getUuid()+
				"&groupId="+themeDisplay.getScopeGroupId() %>' >
		MyFile </a>*/
		
		
		
			HttpServletRequest request = (HttpServletRequest) servletRequest;
			Date now = new Date();
			
			if (_stopWatch == null) {
				_stopWatch = new StopWatch();
			}

			_stopWatch.start();
			
			User user = null;
			
			try {
				user = _getUser(request);
			} catch (Exception e) {
				_log.error("Unable to recovey user for filter documents " + e);
				
			}
									
			String path = HttpUtil.fixPath(request.getPathInfo());
			String[] pathArray = StringUtil.split(path, CharPool.SLASH);
					
						
			Filelog filelog = null;
			
			long userlogId = -1;
			
			try {
				userlogId = (Long)request.getSession().getAttribute(PortletKeys.USER_LOG_ID);
			} catch (Exception e) {
				
			}
			
			if (Validator.isNumber(pathArray[0]) && isFileEntry(request.getQueryString())) {
				try {
					FileEntry fileEntry = getFileEntry(pathArray);
					
					filelog = FilelogLocalServiceUtil.addFilelogDownload(
							PortalUtil.getCompanyId(request), fileEntry.getFileEntryId(),
							fileEntry.getFileVersion().getVersion(), 
							user.getDefaultUser(), 
							userlogId, now );
				} catch (Exception e) {
					_log.error("Unable to save filelog filter documents " + e);
				}
				
			}
							
			
			filterChain.doFilter(servletRequest, servletResponse);
			
			long elapseLoad = 0;
			if (_stopWatch != null) {
				_stopWatch.stop();

				elapseLoad = _stopWatch.elapsedTime();
			}
			
			if (filelog!=null) {
				try {
					FilelogLocalServiceUtil.updateElapseFilelog(filelog.getFilelogId(), elapseLoad);
				} catch (SystemException e) {
					_log.error("Unable to update filelog filter documents " + e);
					
				}
			}
						
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
				
	}
	
	private static User _getUser(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();

		if (PortalSessionThreadLocal.getHttpSession() == null) {
			PortalSessionThreadLocal.setHttpSession(session);
		}

		User user = PortalUtil.getUser(request);

		if (user != null) {
			return user;
		}

		String userIdString = (String)session.getAttribute("j_username");
		String password = (String)session.getAttribute("j_password");

		if ((userIdString != null) && (password != null)) {
			long userId = GetterUtil.getLong(userIdString);

			user = UserLocalServiceUtil.getUser(userId);
		}
		else {
			long companyId = PortalUtil.getCompanyId(request);

			Company company = CompanyLocalServiceUtil.getCompany(companyId);

			user = company.getDefaultUser();
		}

		return user;
	}
	
	public static FileEntry getFileEntry(String[] pathArray) throws PortalException, SystemException {
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
	    if(permissionChecker == null){
	      try {
	        // initialize to guest
	        Long companyId = CompanyThreadLocal.getCompanyId();
	        if(companyId == null){
	          companyId = PortalUtil.getDefaultCompanyId();
	        }
	        User defaultUser = UserLocalServiceUtil.getDefaultUser(companyId);
	        permissionChecker = PermissionCheckerFactoryUtil.create(defaultUser);
	        PermissionThreadLocal.setPermissionChecker(permissionChecker);
	      } catch (Exception e){
	        throw new RuntimeException(e.getMessage(), e);
	      }
	    }
		if (pathArray.length == 1) {
			long dlFileShortcutId = GetterUtil.getLong(pathArray[0]);

			DLFileShortcut dlFileShortcut = DLAppServiceUtil.getFileShortcut(
				dlFileShortcutId);

			return DLAppServiceUtil.getFileEntry(
				dlFileShortcut.getToFileEntryId());
		}
		else if (pathArray.length == 2) {
			long groupId = GetterUtil.getLong(pathArray[0]);

			return DLAppServiceUtil.getFileEntryByUuidAndGroupId(
				pathArray[1], groupId);
		}
		else if (pathArray.length == 3) {
			long groupId = GetterUtil.getLong(pathArray[0]);
			long folderId = GetterUtil.getLong(pathArray[1]);
			String fileName = HttpUtil.decodeURL(pathArray[2]);

			if (fileName.contains(StringPool.QUESTION)) {
				fileName = fileName.substring(
					0, fileName.indexOf(StringPool.QUESTION));
			}

			return DLAppServiceUtil.getFileEntry(groupId, folderId, fileName);
		}
		else {
			long groupId = GetterUtil.getLong(pathArray[0]);

			String uuid = pathArray[3];
			return DLAppServiceUtil.getFileEntryByUuidAndGroupId(uuid, groupId);
		}
	}
	
	public boolean isFileEntry(String queryString){
		return !(queryString!=null && 
				(queryString.toLowerCase().contains("thumbnail") || 
						queryString.toLowerCase().contains("preview")));
	}
	private transient StopWatch _stopWatch;
	
	private static Log _log = LogFactoryUtil.getLog(DocumentsTrackingFilter.class);
}
