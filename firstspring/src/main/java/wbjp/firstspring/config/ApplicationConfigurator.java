package wbjp.firstspring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import wbjp.firstspring.beans.Account;
import wbjp.firstspring.beans.FacebookAccount;
import wbjp.firstspring.beans.Users;

@Configuration
@PropertySource("")
//@ComponentScan(basePackages= {})
public class ApplicationConfigurator {

	@Autowired
	Environment env;
	
	@Bean
	@Scope("prototype")
	public Account facebookAccount() {
		return new FacebookAccount();
	}
	
	@Bean
	@Scope("prototype")
	public Users addUser(@Value("defName")String name,
							@Value("defPwd")String pwd) {
		
		return new Users(name, pwd);
	}
}
