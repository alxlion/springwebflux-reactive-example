package com.alexandrelion.reactive.controller;

import com.alexandrelion.reactive.InternalDatabase;
import com.alexandrelion.reactive.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

  @Autowired
  private InternalDatabase internalDatabase;

  @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Transaction> findAll() {
    return this.internalDatabase.get();
  }

  @PostMapping
  public Mono<ResponseEntity<Transaction>> save(@RequestParam float amount) {
    Transaction t = new Transaction(amount);
    return this.internalDatabase.add(t)
            .map(savedTransaction -> new ResponseEntity<Transaction>(savedTransaction, HttpStatus.CREATED));
  }

}
