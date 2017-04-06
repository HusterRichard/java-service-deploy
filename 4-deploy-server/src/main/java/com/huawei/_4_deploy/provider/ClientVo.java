package com.huawei._4_deploy.provider;

import lombok.Getter;
import lombok.Setter;

public class ClientVo {
	// #region Fields

	@Setter
	@Getter
	private String ip;

	@Setter
	@Getter
	private String port;

	@Setter
	@Getter
	private String operationType;

	// #endregion
}
