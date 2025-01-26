package sn.api.gestionauchanspring.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.web.dto.request.ClientSimpleCreateRequest;
import sn.api.gestionauchanspring.web.dto.response.Response;

import java.util.Map;

@RequestMapping("api/v1/clients")
public interface ClientController {

    @GetMapping("/")
    ResponseEntity<Map<String, Object>> getClients(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getClientById(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Map<String, Object>> createClient(@RequestBody ClientSimpleCreateRequest client);

    @PutMapping("/{id}")
    ResponseEntity<Map<String, Object>> updateClient(@PathVariable Long id, @RequestBody Client client);

    @GetMapping("/{id}/commandes")
    ResponseEntity<Map<String, Object>> getClientWithCommandes(@PathVariable Long id);

}
