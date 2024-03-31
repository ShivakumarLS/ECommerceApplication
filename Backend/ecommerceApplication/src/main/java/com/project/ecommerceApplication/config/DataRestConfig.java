package com.project.ecommerceApplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.project.ecommerceApplication.entity.Product;
import com.project.ecommerceApplication.entity.ProductCategory;


@Configuration
public class DataRestConfig implements RepositoryRestConfigurer{

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
       HttpMethod [] unsupportedActions = {HttpMethod.POST,HttpMethod.PUT,HttpMethod.DELETE};
       RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
       
       //disable put post and delete for Product entity 
       config.getExposureConfiguration().
        forDomainType(Product.class).
        withItemExposure((metdata,methods) -> methods.disable(unsupportedActions)).
        withCollectionExposure((metdata,methods) -> methods.disable(unsupportedActions));

        //disable put post and delete for Product Category entity
        config.getExposureConfiguration().
        forDomainType(ProductCategory.class).
        withItemExposure((metdata,methods) -> methods.disable(unsupportedActions)).
        withCollectionExposure((metdata,methods) -> methods.disable(unsupportedActions));

       
    }

}
