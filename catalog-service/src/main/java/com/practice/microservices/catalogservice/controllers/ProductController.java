package com.practice.microservices.catalogservice.controllers;

import com.practice.microservices.catalogservice.entities.Product;
import com.practice.microservices.catalogservice.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@Slf4j
public class ProductController {

  private final ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("")
  public List<Product> allProducts(HttpServletRequest request) {
    log.info("Finding all products");
    String auth_header = request.getHeader("AUTH_HEADER");
    log.info("AUTH_HEADER: " + auth_header);
    return productService.findAllProducts();
  }

}