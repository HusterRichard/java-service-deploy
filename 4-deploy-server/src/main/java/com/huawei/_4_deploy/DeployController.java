package com.huawei._4_deploy;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.huawei._2_registry.vo.RegistryServiceVo;
import com.huawei._4_deploy.provider.ClientVo;

/**
 * @author zhangxincheng
 *
 */
@RestController
public class DeployController {
	// #region Fields
	
	@Autowired
	private DeployService deployService;
	
	// #endregion
	
	// #region getAllInstance
	
	@RequestMapping("/getAllDeployClients")
	@ResponseBody
	public List<RegistryServiceVo> getAllDeployClients()
	{
		return deployService.getAllDeployClients();
	}
	
	// #endregion
	
	// #region operation
	
	@RequestMapping("/operation")
	@ResponseBody
	public String operation(@RequestBody ClientVo oClientVo)
	{
		return deployService.operation(oClientVo);
	}
	
	// #endregion
	
}
