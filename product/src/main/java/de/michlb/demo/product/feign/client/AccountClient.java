package de.michlb.demo.product.feign.client;


import de.michlb.demo.product.feign.FeignConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "${account.service.name}", configuration =  FeignConfiguration.class)
public interface AccountClient {

    @RequestMapping(value = "/api/accounts/{id}/balance", method = RequestMethod.GET)
    ResponseEntity<Integer> getBalance(@PathVariable("id") long id);
}
