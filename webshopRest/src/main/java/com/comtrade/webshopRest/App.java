package com.comtrade.webshopRest;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.comtrade.daoFacade", "com.comtrade.webshopRest", "com.comtrade.elasticsearch"})
public class App 
{
	static int port;
	
	public static void main(String[] args) throws Exception {		
		if (args.length == 0) port = 8082;
		else if (args[0].equals("-p")) 
			port = Integer.parseInt(args[1]);
		else throw new Exception("run --help");
		
		ApplicationContext ctx = SpringApplication.run(App.class, args);        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }       
	}	

	@Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return (container -> {
        	container.setPort(port);
        });
    }
}
