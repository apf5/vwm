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

import com.liferay.portal.kernel.audit.AuditMessage;
import com.liferay.portal.kernel.audit.AuditMessageProcessor;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Jorge Loayza Soloisolo
 */
public class LogAuditRouterProcessor implements AuditMessageProcessor {

	public void process(AuditMessage auditMessage) {
		try {
			doProcess(auditMessage);
		}
		catch (Exception e) {
			_log.fatal("Unable to process audit message " + auditMessage, e);
		}
	}

	public void setLogMessageFormatter(
		LogMessageFormatter logMessageFormatter) {

		_logMessageFormatter = logMessageFormatter;
	}

	public void setOutputToConsole(boolean outputToConsole) {
		_outputToConsole = outputToConsole;
	}

	protected void doProcess(AuditMessage auditMessage) throws Exception {
		if (_log.isInfoEnabled() || _outputToConsole) {
			String logMessage = _logMessageFormatter.format(auditMessage);

			if (_log.isInfoEnabled()) {
				_log.info(logMessage);
			}

			if (_outputToConsole) {
				System.out.println("LogAuditRouterProcessor: " + logMessage);
			}
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		LogAuditRouterProcessor.class);

	private LogMessageFormatter _logMessageFormatter;
	private boolean _outputToConsole;

}