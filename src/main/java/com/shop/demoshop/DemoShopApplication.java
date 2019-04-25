package com.shop.demoshop;

import com.shop.demoshop.config.FileStorageProperties;
import com.shop.demoshop.config.SecurityConfig;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class DemoShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShopApplication.class, args);
    }

}
