package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepo extends JpaRepository<Client, UUID> {}
//public interface ClientRepo extends JpaRepository<Client, Integer> {}
