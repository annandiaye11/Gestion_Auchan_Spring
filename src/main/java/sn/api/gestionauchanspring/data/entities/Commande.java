package sn.api.gestionauchanspring.data.entities;

import jakarta.persistence.*;
import sn.api.gestionauchanspring.data.enumerations.EtatCommande;

import java.time.LocalDate;

@Entity
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private int montant;

    @Enumerated(EnumType.STRING)
    private EtatCommande etat;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


    public EtatCommande getEtat() {
        return etat;
    }

    public void setEtat(EtatCommande etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Commande(Long id, LocalDate date, int montant) {
        this.id = id;
        this.date = date;
        this.montant = montant;
    }

    public Commande() {
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


}
