package com.annotation.example;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Igor Dmitriev on 4/8/17
 */
@Getter
@Setter
@ToString
public class CreditCardReport implements Serializable {
  private String cardNumber;
  private BigDecimal balance;
  private BigDecimal income;
  private BigDecimal outcome;
  private LocalDate fromDate;
  private LocalDate toDate;
  private String cardHolderName;
}
