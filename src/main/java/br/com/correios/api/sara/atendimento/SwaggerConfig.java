package br.com.correios.api.sara.atendimento;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.correios.api.commons.swagger.AbstractSwaggerConfig;
import br.com.correios.api.gcssynch.ApiConfig;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends AbstractSwaggerConfig {  
    
    @Autowired
    private ApiConfig apiConfig;
    private final ServletContext servletContext;

    @Autowired
    public SwaggerConfig(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    
    @Value("${api.service-id}")
    private String serviceId;


    @Bean
    public Docket api() {
        return super.api(this.apiConfig);
    }
    
    @Override
    public String basePackage() {
        return "br.com.correios.api.sara-atendimento.controller";
    }
    
    public RelativePathProvider basePath() {
        return new RelativePathProvider(servletContext) {
          @Override
          public String getApplicationBasePath() {
              return "/" + serviceId;
          }
      };
    }


}
