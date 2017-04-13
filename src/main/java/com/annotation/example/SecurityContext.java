package com.annotation.example;

import lombok.experimental.UtilityClass;

/**
 * Created by Igor Dmitriev on 4/13/17
 */
@UtilityClass
public class SecurityContext {

  private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

  public static User getCurrentUser() {
    return userThreadLocal.get();
  }

  public static void setUser(User user) {
    userThreadLocal.set(user);
  }

}
