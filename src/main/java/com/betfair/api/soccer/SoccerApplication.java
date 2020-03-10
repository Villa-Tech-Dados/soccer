package com.betfair.api.soccer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.ForwardedHeaderFilter;
@SpringBootApplication(scanBasePackages= {"com.betfair.api.soccer"})  //"br.com.correios.api.leader"
public class SoccerApplication {


    public static void main(String[] args) {
    	SpringApplication.run(SoccerApplication.class, args);
    	
    }       

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
        validatorFactoryBean.setValidationMessageSource(messageSource);
        return validatorFactoryBean;
    }

    // Para a paginação funcionar, inserindo o serviceId na url. Ex: "http://localhost:8080/ppms/v1/clientes?nome=CLAITON&page=0&size=50&sort=nome,asc"
    @Bean                                                                                                                                                                                                                                                                                                                                                                                 
    public FilterRegistrationBean<ForwardedHeaderFilter> forwardedHeaderFilter() {                                                                                                                                                                                                                                                                                                        
        final FilterRegistrationBean<ForwardedHeaderFilter> filter = new FilterRegistrationBean<>();                                                                                                                                                                                                                                                                                  
        filter.setFilter(new ForwardedHeaderFilter());                                                                                                                                                                                                                                                                                                                                
        return filter;                                                                                                                                                                                                                                                                                                                                                                
    } 
    
}


