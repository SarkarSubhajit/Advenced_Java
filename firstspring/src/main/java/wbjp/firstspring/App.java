package wbjp.firstspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import wbjp.firstspring.beans.Account;
import wbjp.firstspring.beans.FacebookAccount;
import wbjp.firstspring.config.ApplicationConfigurator;

public class App {
    public static void main(String[] args) {
        
    	try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfigurator.class)) {
    		
    		Account acc = (FacebookAccount) applicationContext.getBean("facebookAccount");
    		Account acc1 = (FacebookAccount) applicationContext.getBean("facebookAccount");
    		Account acc2 = (FacebookAccount) applicationContext.getBean("facebookAccount");
    		Account acc3 = (FacebookAccount) applicationContext.getBean("facebookAccount");
    		
    		System.out.println(acc);
    		System.out.println(acc1);
    		System.out.println(acc2);
    		System.out.println(acc3);
    		
    	}
    	
    }
}
