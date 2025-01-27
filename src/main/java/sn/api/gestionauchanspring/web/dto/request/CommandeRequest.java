package sn.api.gestionauchanspring.web.dto.request;

import jakarta.persistence.*;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.data.enums.EtatCommande;

import java.time.LocalDate;

public class CommandeRequest {
    private Long id;

    private final LocalDate date = LocalDate.now();

    private int montant;


    private String etat;

    private Long client;

    public Commande toEntity(Client client) {
        Commande commande = new Commande();
        commande.setId(id);
        commande.setDate(date);
        commande.setMontant(montant);
        commande.setEtat(EtatCommande.fromValue(etat));
        commande.setClient(client);
        return commande;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }
}
