package com.huawei._2_registry.reg_server;

import java.util.List;

import com.huawei._2_registry.reg_server.eureka.EurekaProvider;
import com.huawei._2_registry.vo.RegistryServiceVo;
import com.huawei.core.ioc.IOCUtils;

/**
 * @author zhangxincheng
 *
 */
public class RegistryserverProvider {	
	// #region getInstance
	
	/**
	 * getInstance<br>
	 * get specify type of services by eureka<br>
	 * @param strServiceType
	 * @return
	 */
	public static List<RegistryServiceVo> getInstance(String strServiceType)
	{
		EurekaProvider oEurekaProvider = IOCUtils.getInstance().getBean(EurekaProvider.class);
		return oEurekaProvider.getInstance(strServiceType);
	}
	
	// #endregion
	
	// #region getAllInstance

	/**
	 * getAllInstances<br>
	 * get all services by eureka<br>
	 * @return
	 */
	public static List<RegistryServiceVo> getAllInstances()
	{
		EurekaProvider oEurekaProvider = IOCUtils.getInstance().getBean(EurekaProvider.class);
		return oEurekaProvider.getAllInstances();
	}

	// #endregion
}
