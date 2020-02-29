package br.com.correios.api.sara.atendimento;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.hateoas.FeignHalAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.ForwardedHeaderFilter;

import br.com.correios.api.gcssynch.EnableGcs;


@EnableAutoConfiguration(exclude={FeignHalAutoConfiguration.class}) // TODO: Para o swagger rodar no springboot 2.0.0


@EnableScheduling
@EnableFeignClients
@EnableGcs
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages= {"br.com.correios.api.commons", "br.com.correios.api.sara.atendimento"})  //"br.com.correios.api.leader"
@PropertySources({@PropertySource("classpath:messages.properties"), @PropertySource("classpath:commons-mensagens.properties") })
public class SaraAtendimentoApplication {


    public static void main(String[] args) {
    	SpringApplication.run(SaraAtendimentoApplication.class, args);
    	
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


