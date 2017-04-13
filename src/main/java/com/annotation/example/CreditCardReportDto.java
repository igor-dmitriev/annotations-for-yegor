package com.annotation.example;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
@Getter
@Setter
@ToString
public class CreditCardReportDto {
  @Secure
  private String cardNumber;
  @Secure
  private String balance;
  private String income;
  private String outcome;
  private String fromDate;
  private String toDate;
  private String cardHolderName;
}

