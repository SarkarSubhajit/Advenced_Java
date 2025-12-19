package wbjp.spring.firstboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {
		"wbjp.spring.firstboot.controller",
		"wbjp.spring.firstboot.service",
		"wbjp.spring.firstboot.dao"
})
@EntityScan(basePackages = {"wbjp.spring.firstboot.entity"})
@EnableJpaRepositories(basePackages = {"wbjp.spring.firstboot.repository"})
public class FirstbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootApplication.class, args);
	}

}
