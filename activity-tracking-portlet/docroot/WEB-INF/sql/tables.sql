create table CONSIS_TRACK_Browser (
	browserId LONG not null primary key,
	name VARCHAR(75) null
);

create table CONSIS_TRACK_Browsinglog (
	browsinglogId LONG not null primary key,
	companyId LONG,
	userlogId LONG,
	clientHost VARCHAR(75) null,
	clientAddr VARCHAR(75) null,
	serverName VARCHAR(75) null,
	serverPort INTEGER,
	userAgent VARCHAR(255) null,
	url VARCHAR(255) null,
	plId LONG,
	accessName VARCHAR(75) null,
	accessFound BOOLEAN,
	accessDate LONG,
	elapseLoad LONG,
	uploadSize LONG,
	downloadSize LONG
);

create table CONSIS_TRACK_Filelog (
	FilelogId LONG not null primary key,
	companyId LONG,
	guest BOOLEAN,
	userlogId LONG,
	fileId LONG,
	fileVersion VARCHAR(75) null,
	accessDate LONG,
	elapseLoad LONG,
	trafic BOOLEAN,
	status BOOLEAN
);

create table CONSIS_TRACK_OS (
	osId LONG not null primary key,
	name VARCHAR(75) null
);

create table CONSIS_TRACK_OrganizationHit (
	hitId LONG not null primary key,
	companyId LONG,
	organizationId LONG,
	guest BOOLEAN,
	accessDate LONG
);

create table CONSIS_TRACK_Phrase (
	phraseId LONG not null primary key,
	phraseName TEXT null
);

create table CONSIS_TRACK_PortletHit (
	hitId LONG not null primary key,
	companyId LONG,
	portletId VARCHAR(75) null,
	guest BOOLEAN,
	userId LONG,
	userlogId LONG,
	accessDate LONG
);

create table CONSIS_TRACK_PortletProperty (
	propertyId LONG not null primary key,
	companyId LONG,
	name VARCHAR(75) null,
	value VARCHAR(75) null
);

create table CONSIS_TRACK_SearchPhraseHit (
	hitId LONG not null primary key,
	companyId LONG,
	phraseId LONG,
	guest BOOLEAN,
	accessDate LONG
);

create table CONSIS_TRACK_SearchWordHit (
	hitId LONG not null primary key,
	companyId LONG,
	wordId LONG,
	guest BOOLEAN,
	accessDate LONG
);

create table CONSIS_TRACK_SiteHit (
	hitId LONG not null primary key,
	companyId LONG,
	siteId LONG,
	guest BOOLEAN,
	accessDate LONG
);

create table CONSIS_TRACK_TrackEvent (
	trackEventId LONG not null primary key,
	companyId LONG,
	userName VARCHAR(200) null,
	createDate LONG,
	userlogId LONG,
	eventType VARCHAR(75) null,
	className VARCHAR(200) null,
	classPK VARCHAR(75) null,
	message VARCHAR(75) null,
	clientHost VARCHAR(255) null,
	clientAddr VARCHAR(75) null,
	serverName VARCHAR(255) null,
	serverPort INTEGER,
	additionalInfo TEXT null
);

create table CONSIS_TRACK_Userlog (
	userlogId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(200) null,
	serverName VARCHAR(255) null,
	serverPort INTEGER,
	remoteHost VARCHAR(255) null,
	remoteAddress VARCHAR(75) null,
	osId LONG,
	osManufacturer VARCHAR(75) null,
	browserId LONG,
	browserVersion VARCHAR(75) null,
	sessionId VARCHAR(75) null,
	accessDate LONG,
	timeSlapse LONG
);

create table CONSIS_TRACK_Word (
	wordId LONG not null primary key,
	wordName VARCHAR(75) null
);