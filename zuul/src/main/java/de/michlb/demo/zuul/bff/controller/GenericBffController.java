package de.michlb.demo.zuul.bff.controller;

import de.michlb.demo.zuul.feign.CustomerClient;
import de.michlb.demo.zuul.feign.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@Slf4j
public class GenericBffController {

  @Autowired
  private ProductClient productClient;

  @Autowired
  private CustomerClient customerClient;

  private Map<String, Map<String, String>> bffConfig;

  @PostConstruct
  public void setup() {

    bffConfig = new HashMap<>();

    Map<String, String> r1 = new HashMap<>();
    r1.put("product", "productClient.detail()");
    r1.put("customer", "customerClient.info()");
    bffConfig.put("/bff/product/detail", r1);
  }

  /**
   * This call needs to be split into at least two calls and the result needs to be aggreagted
   *
   * @return Map of String of the service as key and the JSON result as the value
   */
  //@RequestMapping(value = "/detail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @RequestMapping(value = "/bff/**", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public Map<String, String> executeBffRequest(HttpServletRequest request) {
    Map<String, String> aggregatedResult = new HashMap<>();

    aggregatedResult.put("request", request.getRequestURI());

    if (bffConfig.containsKey(request.getRequestURI())) {
      Map<String, String> childRequests = bffConfig.get(request.getRequestURI());
      for (int i = 0; i < childRequests.size(); i++) {
        Set<String> keys = childRequests.keySet();
        for (String key : keys) {
          String val = childRequests.get(key);
          try {
            String childResult = null;

            // FIXME: do it right
            if (val.equals("productClient.detail()")) {
              childResult = productClient.detail();
            } else if (val.equals("customerClient.info()")) {
              childResult = customerClient.info();
            }

            if (childResult != null) {
              aggregatedResult.put(key, childResult);
            }
          } catch (Exception e) {
            log.error("client request failed", e);
          }
        }
      }
    } else {
      log.warn("could not find config for request " + request.getRequestURI());
      aggregatedResult.put("WARNING", "could not find config for request");
    }

    return aggregatedResult;
  }
}
