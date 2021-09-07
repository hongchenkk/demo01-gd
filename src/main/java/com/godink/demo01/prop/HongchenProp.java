package com.godink.demo01.prop;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("com.hongchen")
public class HongchenProp {
	private String title;
	private String desc;
	private List<String> roles;
}
