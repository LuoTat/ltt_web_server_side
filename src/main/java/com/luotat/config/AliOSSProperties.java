package com.luotat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/*阿里云OSS相关配置*/
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    // 区域ss
    private String endpoint;
    // 身份ID
    private String accessKeyId ;
    // 身份密钥
    private String accessKeySecret ;
    // 存储空间
    private String bucketName;
}