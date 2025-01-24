package sn.api.gestionauchanspring.web.controllers;


import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.web.dto.response.Response;

@RequestMapping("api/v1/clients")
public interface ClientController {

    @GetMapping("/")
    ResponseEntity<Response> getClients(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Response> getClientById(@PathVariable Long id);

    @PostMapping("/create")
    ResponseEntity<Client> createClient(@RequestBody Client client);

    @PutMapping("/{id}")
    ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client);

}
