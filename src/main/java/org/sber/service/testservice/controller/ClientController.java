package org.sber.service.testservice.controller;

import org.sber.service.testservice.model.Client;
import org.sber.service.testservice.repo.ClientRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    private final ClientRepo clientRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    public ClientController(ClientRepo clientRepo) {
        LOGGER.info("INIT Clients repository");
        this.clientRepo = clientRepo;
    }

    @GetMapping()
    public List<Client> getAll() {
        for (Client client : clientRepo.findAll()) {
            LOGGER.info("GET ALL " + client.toString());
        }
        return clientRepo.findAll();
    }

    @GetMapping("{id}")
    public Client getOne(@PathVariable("id") Client client) {
        LOGGER.info("GET " + client.toString());
        return client;
    }

    @PostMapping
    public Client create(@RequestBody Client client) {
        LOGGER.info("CREATE " + client.toString());
        return clientRepo.save(client);
    }

    @PutMapping("{id}")
    public Client edit(@NonNull @PathVariable("id") Client clientFromRepo,  @NonNull @RequestBody Client client) {
        LOGGER.info("EDIT " + clientFromRepo.toString() + " TO " + client.toString());
        BeanUtils.copyProperties(client, clientFromRepo, "uid");
        return clientRepo.save(clientFromRepo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Client client) {
        LOGGER.info("DELETE " + client.toString());
        clientRepo.delete(client);
    }
}
