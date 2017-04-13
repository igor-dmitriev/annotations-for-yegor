package com.annotation.example;

import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
public class CreditCardReportConverter {

  public static CreditCardReportDto toDto(CreditCardReport report) {
    CreditCardReportDto dto = new CreditCardReportDto();
    dto.setCardNumber(report.getCardNumber());
    dto.setIncome(NumberFormat.getCurrencyInstance().format(report.getIncome()));
    dto.setOutcome(NumberFormat.getCurrencyInstance().format(report.getOutcome()));
    dto.setBalance(NumberFormat.getCurrencyInstance().format(report.getBalance()));
    dto.setCardHolderName(report.getCardHolderName());
    dto.setFromDate(DateTimeFormatter.ISO_DATE.format(report.getFromDate()));
    dto.setToDate(DateTimeFormatter.ISO_DATE.format(report.getToDate()));
    return dto;
  }
}
