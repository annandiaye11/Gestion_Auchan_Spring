package sn.api.gestionauchanspring.data.mocks;


import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.data.enums.EtatCommande;
import sn.api.gestionauchanspring.services.ClientService;
import sn.api.gestionauchanspring.services.CommandeService;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Order(2)
@Component
public class CommandeMock implements CommandLineRunner {
    private final CommandeService commandeService;
    private final ClientService clientService;


    public CommandeMock(CommandeService commandeService, ClientService clientService) {
        this.commandeService = commandeService;
        this.clientService = clientService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Commande commande = new Commande();
            commande.setDate(LocalDate.now());
            commande.setMontant(1000);
            if (i % 2 == 0) {
                 commande.setEtat(EtatCommande.EN_ATTENTE);
                 commande.setClient(clientService.getById(2L));
            } else {commande.setEtat(EtatCommande.FINALISER);
                commande.setClient(clientService.getById(3L));
            }
            commandeService.create(commande);
        }
    }
}

