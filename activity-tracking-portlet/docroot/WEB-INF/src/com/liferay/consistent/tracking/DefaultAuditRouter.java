/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.consistent.tracking;

import com.liferay.portal.kernel.audit.AuditException;
import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditMessageProcessor;
import com.liferay.portal.kernel.audit.AuditRouter;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
  * @author Jorge Loayza Soloisolo
 */
public class DefaultAuditRouter implements AuditRouter {

	public void route(AuditMessage auditMessage) throws AuditException {
		for (AuditMessageProcessor globalAuditMessageProcessor :
				_globalAuditMessageProcessors) {

			globalAuditMessageProcessor.process(auditMessage);
		}

		String eventType = auditMessage.getEventType();

		Set<AuditMessageProcessor> auditMessageProcessors =
			_auditMessageProcessors.get(eventType);

		if (auditMessageProcessors != null) {
			for (AuditMessageProcessor auditMessageProcessor :
					auditMessageProcessors) {

				auditMessageProcessor.process(auditMessage);
			}
		}
	}

	public void setAuditMessageProcessors(
		Map<String, List<AuditMessageProcessor>> auditMessageProcessors) {

		for (Map.Entry<String, List<AuditMessageProcessor>> entry :
				auditMessageProcessors.entrySet()) {

			String eventType = entry.getKey();

			Set<AuditMessageProcessor> auditMessageProcessorsSet =
				_auditMessageProcessors.get(eventType);

			if (auditMessageProcessorsSet == null) {
				auditMessageProcessorsSet =
					new HashSet<AuditMessageProcessor>();

				_auditMessageProcessors.put(
					eventType, auditMessageProcessorsSet);
			}

			auditMessageProcessorsSet.addAll(entry.getValue());
		}
	}

	public void setGlobalAuditMessageProcessors(
		List<AuditMessageProcessor> globalAuditMessageProcessors) {

		_globalAuditMessageProcessors.addAll(globalAuditMessageProcessors);
	}

	private Map<String, Set<AuditMessageProcessor>> _auditMessageProcessors =
		new ConcurrentHashMap<String, Set<AuditMessageProcessor>>();
	private List<AuditMessageProcessor> _globalAuditMessageProcessors =
		new CopyOnWriteArrayList<AuditMessageProcessor>();

}