package com.huawei.component.str;

import org.apache.commons.lang.StringUtils;

public class StringUtilsEx {
	// #region split

	public static String[] splitWithoutSpace(String strSrc) {
		return StringUtils.split(strSrc, null);
	}

	public static String[] splitWithoutSpace(String strSrc, String strSplit) {
		return StringUtils.split(strSrc, strSplit);
	}

	// #endregion
}
