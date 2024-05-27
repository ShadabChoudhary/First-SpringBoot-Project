package com.example.firstspringbootdemo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

//since it is a config class we can create an object of this class using configuration annotation
//we can also use Service annotation here but Spring have diff type of annotations for diff type of classes
//so that whatever purpose the particular class is performing, we have similar type of annotations for it
//And we will use this class in our FakeStoreProductService because there we are writing all our logic part
@Configuration
public class ApplicationConfig {
    //creating a Rest template
    //with the help of Bean annotation we create an object of this method
    //so that we could inject it in other files also and use its method
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate();
    }
}
