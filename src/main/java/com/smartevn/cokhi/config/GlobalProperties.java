package com.smartevn.cokhi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 
 * @author vadinh
 *
 */
@Component
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalProperties {

//    @Max(5)
//    @Min(0)
    @Value("${thread-pool}")
    private int threadPool;
    
    public int getThreadPool() {
        return threadPool;
    }

    public void setThreadPool(int threadPool) {
        this.threadPool = threadPool;
    }
    
}
