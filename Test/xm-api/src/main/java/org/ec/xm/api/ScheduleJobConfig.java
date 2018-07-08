package org.ec.xm.api;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.ec.xm.api.job"})
@ConditionalOnProperty(name = {"xxl.job.admin.addresses"})
public class ScheduleJobConfig {
    private Logger logger = LoggerFactory.getLogger(ScheduleJobConfig.class);
    @Value("${xxl.job.admin.addresses}")
    private String adminAddresses;
    @Value("${xxl.job.executor.appname}")
    private String appName;
    @Value("${xxl.job.executor.ip}")
    private String ip;
    @Value("${xxl.job.executor.port}")
    private int port;
    @Value("${xxl.job.accessToken}")
    private String accessToken;
    @Value("${xxl.job.executor.logpath}")
    private String logPath;
    @Value("${xxl.job.executor.logretentiondays}")
    private int logRetentionDays;

    @Bean(initMethod = "start", destroyMethod = "destroy")
    @NotNull
    public XxlJobExecutor JobExecutor() {
        this.logger.info(">>>>>>>>>>> xm-job config init.");
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setAdminAddresses(this.adminAddresses);
        xxlJobExecutor.setAppName(this.appName);
        xxlJobExecutor.setIp(this.ip);
        xxlJobExecutor.setPort(this.port);
        xxlJobExecutor.setAccessToken(this.accessToken);
        xxlJobExecutor.setLogPath(this.logPath);
        xxlJobExecutor.setLogRetentionDays(this.logRetentionDays);
        return xxlJobExecutor;
    }
}
