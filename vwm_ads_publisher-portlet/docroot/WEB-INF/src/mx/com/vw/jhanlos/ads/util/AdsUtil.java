package mx.com.vw.jhanlos.ads.util;

import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;

public class AdsUtil {
	
	public static final long defaultOrganizationId = -1;
	
	public static String createURL(FileEntry fileEntry,DLFolder dLfolder){
		
		String url = "/documents/"+dLfolder.getRepositoryId()+
				"/"+fileEntry.getFolderId()+"/"+HttpUtil.encodeURL(fileEntry.getTitle(), true);;
		return url;
	}

}
