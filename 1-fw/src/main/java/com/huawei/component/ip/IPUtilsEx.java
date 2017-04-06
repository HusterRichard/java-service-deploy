package com.huawei.component.ip;

public class IPUtilsEx {
	// #region const

	private static final String SPLIT_COLON = ":";

	private static final String SPLIT_SQUARE_BRACKET = "]";

	// #endregion

	// #region getIPAddress

	/**
	 * deal with 127.0.0.1:49130 or [::]:135 or *:*
	 * 
	 * @param strAddress
	 * @return IPAddressVo
	 */
	public static IPAddressVo getIPAddress(String strAddress) {
		IPAddressVo oRes = new IPAddressVo();

		if (strAddress.contains(SPLIT_SQUARE_BRACKET)) {
			int iIndex4Bracket = strAddress.indexOf(SPLIT_SQUARE_BRACKET);
			oRes.setIp(strAddress.substring(0, iIndex4Bracket + 1));
			oRes.setPort(strAddress.substring(iIndex4Bracket + 2));
		} else {
			int iIndex4Colon = strAddress.indexOf(SPLIT_COLON);
			oRes.setIp(strAddress.substring(0, iIndex4Colon));
			oRes.setPort(strAddress.substring(iIndex4Colon + 1));
		}

		return oRes;
	}

	// #endregion
}
