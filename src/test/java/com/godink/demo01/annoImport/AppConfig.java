package com.godink.demo01.annoImport;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ServiceImpl.class)
public class AppConfig {

}
