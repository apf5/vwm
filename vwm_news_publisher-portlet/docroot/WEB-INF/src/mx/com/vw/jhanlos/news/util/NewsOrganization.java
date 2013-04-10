package mx.com.vw.jhanlos.news.util;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

public class NewsOrganization {
	
	public String name;
	public long groupId;
	
	public NewsOrganization(String name,long groupId) {
		setName(name);
		setGroupId(groupId);
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public JSONObject toJSON(){
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("name", name);
		jsonObject.put("groupId", groupId);
		return jsonObject;
	}
}
