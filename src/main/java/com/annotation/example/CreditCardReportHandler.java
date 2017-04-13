package com.annotation.example;

import java.lang.reflect.Field;
import java.util.stream.Stream;

import lombok.SneakyThrows;

/**
 * Created by Igor Dmitriev on 4/8/17
 */
public class CreditCardReportHandler {

  public static CreditCardReportDto handle(CreditCardReportDto report) {
    Stream.of(report.getClass().getDeclaredFields())
        .forEach(field -> handle(report, field));
    return report;
  }

  @SneakyThrows
  private static void handle(CreditCardReportDto report, Field field) {
    if (!field.isAnnotationPresent(Secure.class)) {
      return;
    }

    if (SecurityContext.getCurrentUser().getRole() == Role.BANKER) {
      field.setAccessible(true);
      field.set(report, "SECURE INFO");
    }
  }
}
