package com.huawei.component.threadpool;

import com.huawei.component.threadpool.provider.ThreadPoolProvider;
import com.huawei.core.ioc.IOCUtils;

public class ThreadPoolUtils {
	// #region getProvider

	public static ThreadPoolProvider getProvider() {
		return IOCUtils.getInstance().getBean(ThreadPoolProvider.class);
	}

	// #endregion
}
