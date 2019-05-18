package org.sber.service.testservice.controller;

import org.sber.service.testservice.model.ClientProduct;
import org.sber.service.testservice.repo.ClientProductRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients-products")
public class ClientProductController {
    private final ClientProductRepo clientProductRepo;
    private static final Logger LOGGER = LoggerFactory.getLogger(ClientProductController.class);

    @Autowired
    public ClientProductController(ClientProductRepo clientProductRepo) {
        this.clientProductRepo = clientProductRepo;
    }

    @GetMapping()
    public List<ClientProduct> getAll() {
        for (ClientProduct clientProduct : clientProductRepo.findAll()) {
            LOGGER.info("GET ALL " + clientProduct.toString());
        }
        return clientProductRepo.findAll();
    }

    @GetMapping("{id}")
    public ClientProduct getOne(@PathVariable("id") ClientProduct clientProduct) {
        LOGGER.info("GET " + clientProduct.toString());
        return clientProduct;
    }

    @PostMapping
    public ClientProduct create(@RequestBody ClientProduct clientProduct) {
        LOGGER.info("CREATE " + clientProduct.toString());
        return clientProductRepo.save(clientProduct);
    }

    @GetMapping("{id}")
    public ClientProduct edit(@PathVariable("id") ClientProduct clientProductFromRepo, @RequestBody ClientProduct clientProduct) {
        LOGGER.info("EDIT " + clientProductFromRepo.toString() + " TO " + clientProduct.toString());
        BeanUtils.copyProperties(clientProduct, clientProductFromRepo, "uid");
        return clientProductRepo.save(clientProductFromRepo);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") ClientProduct clientProduct) {
        LOGGER.info("DELETE " + clientProduct.toString());
        clientProductRepo.delete(clientProduct);
    }
}
