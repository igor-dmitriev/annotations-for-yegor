package com.annotation.example;

import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
public class CreditCardReportHandlerTest {

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

  @Test
  public void shouldHideSecureDataForBanker() {
    SecurityContext.setUser(new User("Jon Andersen", Role.BANKER));
    CreditCardReport report = createReport();
    ReportDto reportDto = CreditCardReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(reportDto);

    assertThat(reportDto.getCardNumber(), is("SECURE INFO"));
    assertThat(reportDto.getBalance(), is("SECURE INFO"));
  }

  @Test
  public void shouldShowSecureDataForCreditCardHolder() {
    SecurityContext.setUser(new User("Artour Babaev", Role.CUSTOMER));
    CreditCardReport report = createReport();
    ReportDto reportDto = CreditCardReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(reportDto);

    assertThat(reportDto.getCardNumber(), is("4183 3256 4324 2224"));
    assertThat(reportDto.getBalance(), is("UAH1,000,000.00"));
  }

}
