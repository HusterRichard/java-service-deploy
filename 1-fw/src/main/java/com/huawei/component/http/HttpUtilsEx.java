package com.huawei.component.http;

import com.huawei.component.http.provider.rest_template.RestTemplateProvider;
import com.huawei.core.ioc.IOCUtils;

public class HttpUtilsEx {
	// #region getRestTemplateProvider

	public static RestTemplateProvider getProvider() {
		RestTemplateProvider oRestTemplateProvider = IOCUtils.getInstance().getBean(RestTemplateProvider.class);
		return oRestTemplateProvider;
	}

	// #endregion
}
