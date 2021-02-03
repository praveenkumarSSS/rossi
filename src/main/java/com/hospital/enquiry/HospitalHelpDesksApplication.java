package com.hospital.enquiry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootExceptionReporter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@EnableJpaRepositories
@EnableCaching
public class HospitalHelpDesksApplication extends SpringBootServletInitializer{
	
	@Bean
    public RestTemplate getTemplate()
		{
			return new RestTemplate();
		}
		
		public static void main(String[] args) {	
		SpringApplication.run(HospitalHelpDesksApplication.class, args);
}
}