create table vwm_ads_Mailbox (
	mailboxId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate LONG,
	modifiedDate LONG,
	name VARCHAR(75) null,
	iconId LONG
);

create table vwm_ads_MailboxAdmin (
	mailboxAdminId LONG not null primary key,
	createDate LONG,
	modifiedDate LONG,
	mailboxId LONG,
	userId LONG
);

create table vwm_ads_Propertie (
	propertieId LONG not null primary key,
	companyId LONG,
	userId LONG,
	createDate LONG,
	modifiedDate LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);