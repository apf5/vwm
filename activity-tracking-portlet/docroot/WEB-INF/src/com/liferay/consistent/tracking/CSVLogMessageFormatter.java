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
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * @author Jorge Loayza Soloisolo
 */
public class CSVLogMessageFormatter implements LogMessageFormatter {

	public String format(AuditMessage auditMessage) {
		StringBundler sb = new StringBundler(_columns.length * 4 - 1);

		JSONObject jsonObject = auditMessage.toJSONObject();

		for (int i = 0; i < _columns.length; i++) {
			sb.append(StringPool.QUOTE);
			sb.append(jsonObject.getString(_columns[i]));
			sb.append(StringPool.QUOTE);

			if ((i + 1) < _columns.length) {
				sb.append(StringPool.COMMA);
			}
		}

		return sb.toString();
	}

	public void setColumns(String columns) {
		_columns = StringUtil.split(columns);
	}

	private String[] _columns;

}