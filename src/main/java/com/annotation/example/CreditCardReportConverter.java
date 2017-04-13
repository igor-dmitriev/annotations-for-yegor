package com.annotation.example;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
public class CreditCardReportConverter {

  public static ReportDto toDto(CreditCardReport report) {
    ReportDto dto = new ReportDto();
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
