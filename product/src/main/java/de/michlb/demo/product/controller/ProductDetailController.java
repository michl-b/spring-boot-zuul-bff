package de.michlb.demo.product.controller;

import de.michlb.demo.product.constant.ApiConstants;
import de.michlb.demo.product.model.Product;
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
public class ProductDetailController {

  /**
   * Used to provide tools a HTTP 200 OK when service is running.
   */
  @RequestMapping(path = ApiConstants.API_PRODUCT_DETAIL)
  public ResponseEntity<List<Product>> getList() {
    List<Product> productList = new ArrayList<>();

    Product p1 = new Product();
    p1.setName("MacBook Pro");
    p1.setDescription(
            "MacBook Pro mit Retina Display. Jetzt mit dem Force Touch Trackpad, längerer Batterielaufzeit und schnellerem Flash-Speicher. 13 zoll ab 1.449 €. 15 zoll ab 2.249 €.");
    p1.setPictureUrl("http://images.apple.com/euro/macbook-pro/h/generic/images/overview_hero.jpg");
    productList.add(p1);

    return new ResponseEntity<>(productList, HttpStatus.OK);
  }
}