package org.sber.service.testservice.controller;

import org.sber.service.testservice.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("clients")
public class ClientController {
    private int counter = 4;
    private List<Map<String, String>> clients = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1"); put("name", "Ivan"); put("balance", "20000");
        }});

        add(new HashMap<String, String>() {{
            put("id", "2"); put("name", "Vladimir"); put("balance", "30000");
        }});

        add(new HashMap<String, String>() {{
            put("id", "3"); put("name", "Galina"); put("balance", "50000");
        }});
    }};

    @GetMapping()
    public List<Map<String, String>> getAll() {
        return clients;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return getClient(id);
    }

    private Map<String, String> getClient(@PathVariable String id) {
        return clients.stream()
                .filter(clients -> clients.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @PostMapping
    public Map<String, String> create(@RequestBody Map<String, String> client) {
        client.put("id", String.valueOf(counter++));
        clients.add(client);

        return client;
    }

    @PutMapping("{id}")
    public Map<String, String> edit(@PathVariable String id, @RequestBody Map<String, String> client) {
        Map<String, String> clientFromDb = getClient(id);
        clientFromDb.putAll(client);
        clientFromDb.put("id", id);

        return clientFromDb;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        Map<String, String> client = getClient(id);
        clients.remove(client);
    }
}
