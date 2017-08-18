package com.alexandrelion.reactive;

import com.alexandrelion.reactive.entity.Transaction;
import org.springframework.context.annotation.Scope;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Scope("singleton")
public class InternalDatabase {

  private List<Transaction> memory;

  public InternalDatabase() {
    if (this.memory == null) {
      this.memory = new ArrayList<>();
    }
  }

  public Mono<Transaction> add (Transaction t) {
    this.memory.add(t);
    return Mono.just(t);
  }

  public Flux<Transaction> get() {
    return Flux.fromIterable(this.memory).delayElements(Duration.ofMillis(300));
  }

}
