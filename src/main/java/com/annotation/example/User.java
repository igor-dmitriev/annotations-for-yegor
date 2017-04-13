package com.annotation.example;

import lombok.Data;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
@Data
public class User {
  private final String name;
  private final Role role;
}
