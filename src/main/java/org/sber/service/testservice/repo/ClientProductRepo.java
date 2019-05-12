package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.ClientProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientProductRepo extends JpaRepository<ClientProduct, Long> {
}
