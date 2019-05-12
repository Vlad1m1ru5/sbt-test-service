package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepo extends CrudRepository<Product, String> {
}
