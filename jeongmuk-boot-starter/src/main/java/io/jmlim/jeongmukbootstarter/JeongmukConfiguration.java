package io.jmlim.jeongmukbootstarter;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(JeongmukProperties.class)
public class JeongmukConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public Jeongmuk jeongmuk(JeongmukProperties properties) {
        Jeongmuk jeongmuk = new Jeongmuk();
        jeongmuk.setFirstname(properties.getFirstname());
        jeongmuk.setHowLong(properties.getHowLong());
        return jeongmuk;
    }
}
