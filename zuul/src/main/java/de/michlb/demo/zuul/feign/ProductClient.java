package de.michlb.demo.zuul.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("product")
public interface ProductClient {

  @RequestMapping(value = "api/product/detail", method = RequestMethod.GET)
  String detail();
}
