package com.huawei.component.log.vo;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ConfigurationProperties(prefix = "msCommon.log")
@EnableAutoConfiguration
@Component
@ToString
public class ConfigLogVo {
	// #region Fields

	@Setter
	@Getter
	private String dirPathRoot;

	// #endregion
}
