package com.brevitaz.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapperConfig
{
    private ObjectMapper objectMapper;

    @Bean
    public ObjectMapper getObjectMapper()
    {
        if(objectMapper == null)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper;
        }
        else
        {
            return objectMapper;
        }
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
}
