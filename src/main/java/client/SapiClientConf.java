package client;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Client configuration used by all REST calls
 */
@Configuration
@EnableConfigurationProperties(SapiProperties.class)
@ConditionalOnClass(SapiClient.class)
public class SapiClientConf {

    @Bean
    @ConditionalOnMissingBean
    public SapiClient sapiClient() {
        return new SapiClient();
    }
}
