package org.sber.service.testservice.controller;

import org.sber.service.testservice.repo.ClientProductRepo;
import org.sber.service.testservice.repo.ClientRepo;
import org.sber.service.testservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/")
public class TestServiceController {
    private final ClientRepo clientRepo;
    private final ProductRepo productRepo;
    private final ClientProductRepo clientProductRepo;

    @Autowired
    public TestServiceController (ClientRepo clientRepo, ProductRepo productRepo, ClientProductRepo clientProductRepo) {
        this.clientRepo = clientRepo;
        this.productRepo = productRepo;
        this.clientProductRepo = clientProductRepo;
    }

    @GetMapping
    public String testService(Model model) {
        HashMap<Object, Object> data = new HashMap<>();

        data.put("clientsData", clientRepo.findAll());
        data.put("productsData", productRepo.findAll());
        // TODO
        //  data для clientsProductsRepo
        //  Как положить?

        model.addAttribute("testServiceData", data);

        return "index";
    }
}
