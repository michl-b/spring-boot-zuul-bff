package de.michlb.demo.zuul.bff.controller;

import de.michlb.demo.zuul.feign.CustomerClient;
import de.michlb.demo.zuul.feign.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/bff/product")
public class ProductController {

  @Autowired
  private ProductClient productClient;

  @Autowired
  private CustomerClient customerClient;

  /**
   * This call needs to be split into at least two calls and the result needs to be aggreagted
   *
   * @return Map of String of the service as key and the JSON result ass the value
   */
  @RequestMapping(value = "/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Map<String, String> productDetail() {
    Map<String, String> aggregatedResult = new HashMap<>();

    aggregatedResult.put("product", productClient.detail());
    aggregatedResult.put("customer", customerClient.info());

    return aggregatedResult;
  }
}
