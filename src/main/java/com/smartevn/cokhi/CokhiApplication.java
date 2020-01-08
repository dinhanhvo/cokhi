package com.smartevn.cokhi;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = {
		CokhiApplication.class,
		Jsr310JpaConverters.class
})
public class CokhiApplication extends SpringBootServletInitializer  {

//	@PostConstruct
//	void init() {
//		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
//        
//	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CokhiApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(CokhiApplication.class, args);
		
//		Map<String, String> env = System.getenv();
//		System.out.println("CokhiApplication.main()=====" + env);
	}

}
