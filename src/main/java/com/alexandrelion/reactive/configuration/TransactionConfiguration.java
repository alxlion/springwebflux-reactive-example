package com.alexandrelion.reactive.configuration;

import com.alexandrelion.reactive.InternalDatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransactionConfiguration {

  @Bean
  public InternalDatabase internalDatabase() {
    return new InternalDatabase();
  }

}
