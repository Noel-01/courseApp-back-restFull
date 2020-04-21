package com.byBatis.courses.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
* The Class SwaggerConfig.
*/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

   /**
    * Api.
    *
    * @return the docket
    */
   @Bean
   public Docket productApi() {

       List<ResponseMessage> responseMessages = new ArrayList<>();
       responseMessages.add(new ResponseMessageBuilder().code(400).message("Error en la llamada.").build());
       responseMessages.add(new ResponseMessageBuilder().code(404).message("Recurso no encontrado.").build());
       responseMessages.add(new ResponseMessageBuilder().code(500).message("Error en el servidor.").build());
       responseMessages.add(new ResponseMessageBuilder().code(401).message("Usuario no autenticado.").build());

       return new Docket(DocumentationType.SWAGGER_2).enable(true).useDefaultResponseMessages(false)
               .globalResponseMessage(RequestMethod.GET, responseMessages)
               .globalResponseMessage(RequestMethod.POST, responseMessages)
               .globalResponseMessage(RequestMethod.DELETE, responseMessages)
               .globalResponseMessage(RequestMethod.PUT, responseMessages).apiInfo(apiInfo()).select()
               .apis(RequestHandlerSelectors.basePackage("com.byBatis.courses.controllers"))
               .paths(PathSelectors.any()).build();
   }

   /**
    * Api info.
    *
    * @return the api info
    */
   private ApiInfo apiInfo() {
       return new ApiInfoBuilder().title("APIss Demo Swagger").build();
   }
}