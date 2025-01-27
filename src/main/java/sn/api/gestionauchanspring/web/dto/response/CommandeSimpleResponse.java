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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }
}
