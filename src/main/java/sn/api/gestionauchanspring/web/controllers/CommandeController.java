package sn.api.gestionauchanspring.web.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.api.gestionauchanspring.data.entities.Commande;

@RequestMapping("api/v1/commandes")
public interface CommandeController {

    @GetMapping("/")
    ResponseEntity<Commande> getAllCommandes( @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size);

    @GetMapping("/{id}")
    ResponseEntity<Commande> getCommandeById(@PathVariable("id") Long id);

    @PostMapping("/create")
    ResponseEntity<Commande> createCommande(@RequestBody Commande commande);

    @PutMapping("/update/{id}")
    ResponseEntity<Commande> updateCommande(@PathVariable Long id, @RequestBody Commande commande);

}
