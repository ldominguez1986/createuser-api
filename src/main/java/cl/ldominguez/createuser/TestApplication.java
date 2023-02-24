package cl.ldominguez.createuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 
 * @author ldominguez
 *
 */
@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class TestApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}
