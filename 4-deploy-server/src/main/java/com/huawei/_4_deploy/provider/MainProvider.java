package com.huawei._4_deploy.provider;

import java.util.List;

import com.huawei._2_registry.reg_server.RegistryserverProvider;
import com.huawei._2_registry.vo.RegistryServiceVo;

public class MainProvider {
	// #region Consts
	
	private static String DEPLOY_CLIENT_SERVICE_TYPE = "DEPLOYCLIENT";
	
	// #endregion

	// #region getAllDeployClients
	
	public static List<RegistryServiceVo> getAllDeployClients() {
		return RegistryserverProvider.getInstance(DEPLOY_CLIENT_SERVICE_TYPE);
	}
	
	// #endregion
	
	// #region operation

	public static String operation(ClientVo oClientVo) {
		// TODO Auto-generated method stub
		return "ok";
	}
	
	// #endregion
}
