create unique index IX_5763CDD5 on CONSIS_TRACK_Browser (name);

create index IX_955BE7FD on CONSIS_TRACK_Browsinglog (companyId);
create index IX_52D0DD19 on CONSIS_TRACK_Browsinglog (userlogId);

create index IX_7569F6B2 on CONSIS_TRACK_Filelog (companyId);
create index IX_CC422B96 on CONSIS_TRACK_Filelog (companyId, guest);
create index IX_32DEEBCE on CONSIS_TRACK_Filelog (userlogId);

create unique index IX_B81FE421 on CONSIS_TRACK_OS (name);

create index IX_E6CB549A on CONSIS_TRACK_OrganizationHit (companyId);
create index IX_2D1ED8AE on CONSIS_TRACK_OrganizationHit (companyId, guest);
create index IX_EA3CECC on CONSIS_TRACK_OrganizationHit (companyId, organizationId, guest);

create unique index IX_544AA96F on CONSIS_TRACK_Phrase (phraseName);

create index IX_EA6415B1 on CONSIS_TRACK_PortletHit (companyId);
create index IX_8695FFB7 on CONSIS_TRACK_PortletHit (companyId, guest);
create index IX_3F9E4734 on CONSIS_TRACK_PortletHit (companyId, portletId, guest);
create index IX_F88DD50E on CONSIS_TRACK_PortletHit (companyId, portletId, userId);
create index IX_EE6F1AF3 on CONSIS_TRACK_PortletHit (companyId, userlogId);

create index IX_2A85DC6B on CONSIS_TRACK_PortletProperty (companyId);
create unique index IX_CE85EFEA on CONSIS_TRACK_PortletProperty (companyId, name);

create index IX_A4C21DE8 on CONSIS_TRACK_SearchPhraseHit (companyId);
create index IX_613F9BA0 on CONSIS_TRACK_SearchPhraseHit (companyId, guest);
create index IX_B40ED4F8 on CONSIS_TRACK_SearchPhraseHit (companyId, phraseId, guest);

create index IX_3F954C39 on CONSIS_TRACK_SearchWordHit (companyId);
create index IX_D75BE02F on CONSIS_TRACK_SearchWordHit (companyId, guest);
create index IX_E831316 on CONSIS_TRACK_SearchWordHit (companyId, wordId, guest);

create index IX_1CC76AE on CONSIS_TRACK_SiteHit (companyId);
create index IX_E48AF81A on CONSIS_TRACK_SiteHit (companyId, guest);
create index IX_EF945FA4 on CONSIS_TRACK_SiteHit (companyId, siteId, guest);

create index IX_FF106C9B on CONSIS_TRACK_TrackEvent (companyId);
create index IX_BC8561B7 on CONSIS_TRACK_TrackEvent (userlogId);
create index IX_822B098D on CONSIS_TRACK_TrackEvent (userlogId, eventType);
create index IX_45FCB366 on CONSIS_TRACK_TrackEvent (userlogId, eventType, className);

create index IX_5516C230 on CONSIS_TRACK_Userlog (browserId, browserVersion);
create index IX_2ABB7C66 on CONSIS_TRACK_Userlog (browserId, userId);
create index IX_45CCF216 on CONSIS_TRACK_Userlog (browserName, userId);
create index IX_C9306F01 on CONSIS_TRACK_Userlog (companyId);
create index IX_74CA7BB2 on CONSIS_TRACK_Userlog (companyId, browserId);
create index IX_7497D7E2 on CONSIS_TRACK_Userlog (companyId, browserName);
create index IX_5CB95DE6 on CONSIS_TRACK_Userlog (companyId, browserName, browserVersion);
create index IX_9503D894 on CONSIS_TRACK_Userlog (companyId, osId);
create index IX_FCE023F0 on CONSIS_TRACK_Userlog (companyId, osId, osVersion);
create index IX_78A2BD0A on CONSIS_TRACK_Userlog (companyId, osManufacturer);
create index IX_6BED8444 on CONSIS_TRACK_Userlog (companyId, osName);
create index IX_DDEF4A40 on CONSIS_TRACK_Userlog (companyId, osName, osVersion);
create index IX_2FF7BE14 on CONSIS_TRACK_Userlog (osId, userId);
create index IX_ECFF8044 on CONSIS_TRACK_Userlog (osName, userId);
create index IX_E3ED8401 on CONSIS_TRACK_Userlog (userId);

create unique index IX_5CD90011 on CONSIS_TRACK_Word (wordName);