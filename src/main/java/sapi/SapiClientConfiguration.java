package sapi;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(SapiClient.class)
public class SapiClientConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public SapiClient sapiClient() {
        return new SapiClient();
    }
}
