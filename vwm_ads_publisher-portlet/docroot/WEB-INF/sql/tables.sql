create table vwm_ads_Propertie (
	propertieId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate LONG,
	modifiedDate LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);