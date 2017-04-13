package com.annotation.example;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Igor Dmitriev on 4/9/17
 */
public class Main {
  public static void main(String[] args) {
    SecurityContext.setUser(new User("Jon Andersen", Role.BANKER));
    CreditCardReport report = createReport();
    ReportDto reportDto = ReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(reportDto);
    // --------------------------------------------
    SecurityContext.setUser(new User("Artour Babaev", Role.CUSTOMER));
    report = createReport();
    reportDto = ReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(reportDto);
  }

  private static CreditCardReport createReport() {
    CreditCardReport report = new CreditCardReport();
    report.setCardHolderName("Artour Babaev");
    report.setCardNumber("4183 3256 4324 2224");
    report.setBalance(new BigDecimal(1000_000));
    report.setIncome(new BigDecimal(300_000));
    report.setOutcome(new BigDecimal(10_000));
    report.setFromDate(LocalDate.of(2017, 3, 3));
    report.setToDate(LocalDate.now());
    return report;
  }
}
