package com.huawei._2_registry.vo;

import lombok.Getter;
import lombok.Setter;

public class RegistryServiceVo {
	// #region Fields
	
	@Setter
	@Getter
	private String serviceType;
	
	@Setter
	@Getter
	private String ip;
	
	@Setter
	@Getter
	private int port;
	
	// #endregion
}
