package org.sber.service.testservice.controller;

import org.sber.service.testservice.model.Product;
import org.sber.service.testservice.repo.ProductRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductRepo productRepo;

    @Autowired
    public ProductController(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @GetMapping()
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Product product) {
        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepo.save(product);
    }

    @PutMapping("{id}")
    public Product edit(@PathVariable("id") Product productFromRepo, @RequestBody Product product) {
        BeanUtils.copyProperties(product, productFromRepo, "uid");
        return productRepo.save(productFromRepo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product) {
        productRepo.delete(product);
    }
}
