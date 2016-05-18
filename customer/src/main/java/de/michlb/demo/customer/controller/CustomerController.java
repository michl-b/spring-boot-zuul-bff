package de.michlb.demo.customer.controller;

import de.michlb.demo.customer.constant.ApiConstants;
import de.michlb.demo.customer.model.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an example controller with a feign client.
 */
@RestController
public class CustomerController {

  /**
   * Used to provide tools a HTTP 200 OK when service is running.
   */
  @RequestMapping(path = ApiConstants.API_CUSTOMER_INFO)
  public ResponseEntity<Customer> info() {
    Customer customer = new Customer();

    customer.setFirstname("Michael");
    customer.setLastname("B.");

    return new ResponseEntity<>(customer, HttpStatus.OK);
  }
}
