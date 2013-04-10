package mx.com.vw.jhanlos.news.portlet;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * Control panel entry class AdminNewsPortletControlPanelEntry
 */

public class NewsAdminPortletControlPanelEntry extends BaseControlPanelEntry {

    @Override
    public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
            throws Exception {
        return permissionChecker.isOmniadmin();
    }

}