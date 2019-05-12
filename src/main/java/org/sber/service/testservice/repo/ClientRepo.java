package org.sber.service.testservice.repo;

import org.sber.service.testservice.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, String> {
}
