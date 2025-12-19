package wbjp.webmvc.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import wbjp.webmvc.dao.CategoryDao;
import wbjp.webmvc.dao.CategoryDaoImpl;
import wbjp.webmvc.dao.UserDao;
import wbjp.webmvc.dao.UserDaoImpl;

@org.springframework.context.annotation.Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "wbjp.webmvc.controller" })
public class AppConfigurator implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
	
	@Bean
	public UserDao userDao() {
		return new UserDaoImpl();
	}
	
	@Bean
	public CategoryDao categoryDao() {
		return new CategoryDaoImpl();
	}
	
	
	@Bean
	public SessionFactory hibernateFactory() {
		Configuration hibernateConfiguration = new Configuration();
		hibernateConfiguration.configure();
		return hibernateConfiguration.buildSessionFactory();
	}

}
