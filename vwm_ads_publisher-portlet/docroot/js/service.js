Liferay.Service.register("Liferay.Service.vwm_ads", "mx.com.vw.jhanlos.ads.service", "vwm_ads_publisher-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vwm_ads, "Propertie",
	{
		getInitValues: true,
		getOrganizationsGroups: true,
		getInitValue: true,
		saveConfig: true
	}
);