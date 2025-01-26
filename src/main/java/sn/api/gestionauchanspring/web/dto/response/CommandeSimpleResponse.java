package sn.api.gestionauchanspring.web.dto.response;

import jakarta.persistence.*;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.data.enums.EtatCommande;

import java.time.LocalDate;

public class CommandeSimpleResponse {
    private Long id;
    private LocalDate date;
    private int montant;
    private EtatCommande etat;

    public CommandeSimpleResponse(Commande commande) {
        this.id = commande.getId();
        this.date = commande.getDate();
        this.montant = commande.getMontant();
        this.etat = commande.getEtat();
    }
}
