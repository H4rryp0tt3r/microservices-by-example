package com.practice.microservices.catalogservice.services;

import com.practice.microservices.catalogservice.entities.Product;
import com.practice.microservices.catalogservice.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ProductService {
  private final ProductRepository productRepository;

  @Autowired
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public List<Product> findAllProducts() {
    List<Product> products = productRepository.findAll();
    return products;
  }

}