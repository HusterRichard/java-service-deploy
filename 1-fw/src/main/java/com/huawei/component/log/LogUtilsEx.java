package com.huawei.component.log;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.huawei.component.log.vo.ConfigLogVo;
import com.huawei.core.ioc.IOCUtils;

public class LogUtilsEx {
	// #region log2File

	public static void log2File(String strMsg, Class<?> oClazz, boolean bIsDebug) {
		if (bIsDebug) {
			ConfigLogVo oConfigLogVo = IOCUtils.getInstance().getBean(ConfigLogVo.class);
			File oFile = new File(oConfigLogVo.getDirPathRoot() + File.separator + oClazz.getSimpleName() + ".txt");
			try {
				FileUtils.writeStringToFile(oFile, strMsg + "\r\n", true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// #endregion

	// #region log

	public static void log(String strMsg, boolean bIsDebug) {
		if (bIsDebug) {
			System.out.println(strMsg);
		}
	}

	// #endregion
}
