package com.huawei._2_registry.reg_server.eureka;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.huawei._2_registry.vo.RegistryServiceVo;

@Component
public class EurekaProvider {
	// #region Fields
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	// #endregion
	
	// #region getInstance
	
	/**
	 * getInstance<br>
	 * get specify type of services by eureka<br>
	 * @param strServiceType
	 * @return
	 */
	public List<RegistryServiceVo> getInstance(String strServiceType)
	{
		List<RegistryServiceVo> lstServiceVo = new ArrayList<RegistryServiceVo>();
		
		List<ServiceInstance> lstServiceIns = this.discoveryClient.getInstances(strServiceType);
		for (ServiceInstance serviceIns : lstServiceIns)
		{
			RegistryServiceVo oRegistryServiceVo = new RegistryServiceVo();
			oRegistryServiceVo.setServiceType(serviceIns.getServiceId());
			oRegistryServiceVo.setIp(serviceIns.getHost());
			oRegistryServiceVo.setPort(serviceIns.getPort());
			lstServiceVo.add(oRegistryServiceVo);
		}
		return lstServiceVo;
	}
	
	// #endregion
	
	// #region getAllInstance

	/**
	 * getAllInstances<br>
	 * get all services by eureka<br>
	 * @return
	 */
	public List<RegistryServiceVo> getAllInstances()
	{
		List<RegistryServiceVo> lstServiceVo = new ArrayList<RegistryServiceVo>();
		
		List<String> lstServiceType = this.discoveryClient.getServices();
		for (String strServiceType : lstServiceType)
		{
			lstServiceVo.addAll(getInstance(strServiceType));
		}
		return lstServiceVo;
	}

	// #endregion
}
