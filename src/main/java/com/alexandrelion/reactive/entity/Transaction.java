package com.alexandrelion.reactive.entity;

import java.util.Date;
import java.util.UUID;

public class Transaction {

  private UUID id;
  private float amount;
  private Date date;

  public Transaction(float amount) {
    this.amount = amount;
    this.date = new Date();
    this.id = UUID.randomUUID();
  }

  public UUID getId() {
    return id;
  }

  public float getAmount() {
    return amount;
  }

  public Date getDate() {
    return date;
  }

}
