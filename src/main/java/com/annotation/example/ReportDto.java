package com.annotation.example;

import lombok.Data;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
@Data
public class ReportDto {
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

