package org.sber.service.testservice.controller;

import org.sber.service.testservice.model.Product;
import org.sber.service.testservice.repo.ProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {
    private final ProductRepo productRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    public ProductController(ProductRepo productRepo) {
        LOGGER.info("INIT Products repository");
        this.productRepo = productRepo;
    }

    @GetMapping()
    public List<Product> getAll() {
        for (Product product : productRepo.findAll()) {
            LOGGER.info("GET ALL " + product.toString());
        }
        return productRepo.findAll();
    }

    @GetMapping("{id}")
    public Product getOne(@PathVariable("id") Product product) {
        LOGGER.info("GET " + product.toString());
        return product;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        LOGGER.info("CREATE " + product.toString());
        return productRepo.save(product);
    }

    @PutMapping("{id}")
    public Product edit( @PathVariable("id") Product productFromRepo, @RequestBody Product product) {
        LOGGER.info("EDIT " + productFromRepo.toString() + " TO " + product.toString());
        BeanUtils.copyProperties(product, productFromRepo, "uid");
        return productRepo.save(productFromRepo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Product product) {
        LOGGER.info("DELETE " + product.toString());
        productRepo.delete(product);
    }
}
