package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.ClientProduct;
import org.springframework.data.repository.CrudRepository;

public interface ClientProductRepo extends CrudRepository<ClientProduct, Long> {
}
