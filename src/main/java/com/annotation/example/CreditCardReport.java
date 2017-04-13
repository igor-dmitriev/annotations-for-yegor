package com.annotation.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Igor Dmitriev on 4/8/17
 */
@Getter
@Setter
public class CreditCardReport implements Serializable {
  private String cardNumber;
  private BigDecimal balance;
  private BigDecimal income;
  private BigDecimal outcome;
  private LocalDate fromDate;
  private LocalDate toDate;
  private String cardHolderName;
}
