package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.ClientProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientProductRepo extends JpaRepository<ClientProduct, UUID> {
}
