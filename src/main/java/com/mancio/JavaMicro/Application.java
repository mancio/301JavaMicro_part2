package com.mancio.JavaMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@EnableDiscoveryClient
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableCaching      // to enable spring cache
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
