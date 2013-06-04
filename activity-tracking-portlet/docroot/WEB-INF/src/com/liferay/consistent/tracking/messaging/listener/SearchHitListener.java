package com.liferay.consistent.tracking.messaging.listener;

import com.liferay.consistent.tracking.model.Phrase;
import com.liferay.consistent.tracking.model.Word;
import com.liferay.consistent.tracking.service.PhraseLocalServiceUtil;
import com.liferay.consistent.tracking.service.SearchPhraseHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.SearchWordHitLocalServiceUtil;
import com.liferay.consistent.tracking.service.WordLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

import java.util.Date;


public class SearchHitListener implements MessageListener{

	@Override
	public void receive(Message message) throws MessageListenerException {
				
		try {
			doReceive(message);
		}
		catch (Exception e) {
			_log.error("Unable to process message " + message, e);
		}
	}
	
	protected void doReceive(Message message)throws Exception {
		long companyId = message.getLong("companyId");
		String keywords = message.getString("keywords");
		boolean guest = message.getBoolean("guest");
		Date access = (Date)message.get("access");
		
		String keywordsArray[] = keywords.split(" ");
		if (keywordsArray.length > 1) {
			Phrase phrase = PhraseLocalServiceUtil.getPhrase(keywords.toLowerCase());
			SearchPhraseHitLocalServiceUtil.addSearchPhraseHit(companyId, phrase.getPhraseId(), guest, access);			
		}
				
		Word word;
		for (String keyword : keywordsArray) {
			word = WordLocalServiceUtil.getWord(keyword.toLowerCase());
			SearchWordHitLocalServiceUtil.addSearchWordHit(companyId, word.getWordId(), guest, access);
		}
						
	}
	
	private static Log _log = LogFactoryUtil.getLog(PortletHitListener.class);

}
