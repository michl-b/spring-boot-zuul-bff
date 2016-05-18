package de.michlb.demo.customer.constant;

import com.shedhack.exception.core.BusinessCode;

/**
 * <pre>
 *     Business Codes which are shared with clients.
 * </pre>
 */
public enum GlobalBusinessCodes implements BusinessCode {

  C001("something"),
  C002("something+1");

  private final String description;

  GlobalBusinessCodes(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public String getCode() {
    return this.name();
  }
}
