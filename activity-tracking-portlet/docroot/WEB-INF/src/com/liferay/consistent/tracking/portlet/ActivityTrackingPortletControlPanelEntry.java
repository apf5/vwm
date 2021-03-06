package com.liferay.consistent.tracking.portlet;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * Control panel entry class ActivityTrackingPortletControlPanelEntry
 */

public class ActivityTrackingPortletControlPanelEntry extends BaseControlPanelEntry {

    @Override
    public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
            throws Exception {
        return permissionChecker.isCompanyAdmin();
    }

}