package sn.api.gestionauchanspring.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.web.dto.request.CommandeRequest;

import java.util.Map;

@RequestMapping("api/v1/commandes")
public interface CommandeController{

    @GetMapping("/")
    ResponseEntity<Map<String, Object>> getAllCommandes(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Map<String, Object>> getCommandeById(@PathVariable("id") Long id);

    @PostMapping("/create/{id}")
    ResponseEntity<Map<String, Object>> createCommande(@RequestBody CommandeRequest commande, @PathVariable("id") Long id );

    @PutMapping("/update/{id}")
    ResponseEntity<Map<String, Object>> updateCommande(@PathVariable Long id, @RequestBody Commande commande);

}
