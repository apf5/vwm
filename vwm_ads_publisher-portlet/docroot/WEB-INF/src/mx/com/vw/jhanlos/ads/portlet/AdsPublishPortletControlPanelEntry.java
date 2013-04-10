package mx.com.vw.jhanlos.ads.portlet;

import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.BaseControlPanelEntry;

/**
 * Control panel entry class PublishAdsPortletControlPanelEntry
 */

public class AdsPublishPortletControlPanelEntry extends BaseControlPanelEntry {

    @Override
    public boolean isVisible(PermissionChecker permissionChecker, Portlet portlet)
            throws Exception {
        return false;
    }

}