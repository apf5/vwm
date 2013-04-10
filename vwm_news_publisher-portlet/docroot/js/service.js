Liferay.Service.register("Liferay.Service.vwm_news", "mx.com.vw.jhanlos.news.service", "vwm_news_publisher-portlet");

Liferay.Service.registerClass(
	Liferay.Service.vwm_news, "Propertie",
	{
		getInitValues: true,
		getOrganizationsGroups: true,
		getInitValue: true,
		saveConfig: true
	}
);