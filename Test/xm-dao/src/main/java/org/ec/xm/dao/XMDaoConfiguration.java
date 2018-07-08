package org.ec.xm.dao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // 配置注解
@PropertySource(value = "classpath:org/ec/xm/dao/application.properties")
@MapperScan("org.ec.xm.dao.mapper")
public class XMDaoConfiguration {
}