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
    CreditCardReportDto creditCardReportDto = CreditCardReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(creditCardReportDto);

    assertThat(creditCardReportDto.getCardNumber(), is("SECURE INFO"));
    assertThat(creditCardReportDto.getBalance(), is("SECURE INFO"));
  }

  @Test
  public void shouldShowSecureDataForCreditCardHolder() {
    SecurityContext.setUser(new User("Artour Babaev", Role.CUSTOMER));
    CreditCardReport report = createReport();
    CreditCardReportDto creditCardReportDto = CreditCardReportHandler.handle(CreditCardReportConverter.toDto(report));
    System.out.println(creditCardReportDto);

    assertThat(creditCardReportDto.getCardNumber(), is("4183 3256 4324 2224"));
    assertThat(creditCardReportDto.getBalance(), is("UAH1,000,000.00"));
  }

}
