package com.huawei._4_deploy;

import java.util.List;

import org.springframework.stereotype.Service;

import com.huawei._2_registry.vo.RegistryServiceVo;
import com.huawei._4_deploy.provider.ClientVo;
import com.huawei._4_deploy.provider.MainProvider;

@Service
public class DeployService {

	public List<RegistryServiceVo> getAllDeployClients() {
		return MainProvider.getAllDeployClients();
	}

	public String operation(ClientVo oClientVo) {
		return MainProvider.operation(oClientVo);
	}

}
