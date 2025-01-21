package sn.api.gestionauchanspring.services.impl;

import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Commande;
import sn.api.gestionauchanspring.data.repositories.CommandeRepository;
import sn.api.gestionauchanspring.services.CommandeService;

import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    public CommandeServiceImpl(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    @Override
    public List<Commande> getAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getById(Long id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        return commande;
    }

    @Override
    public Commande create(Commande data) {
        return commandeRepository.save(data);
    }

    @Override
    public Commande update(Long id, Commande data) {
        Commande oldCommande = commandeRepository.findById(id).orElse(null);
        if (oldCommande != null) {
            oldCommande.setMontant(data.getMontant());
            oldCommande.setEtat(data.getEtat());
            oldCommande.setDate(data.getDate());
            commandeRepository.save(oldCommande);
        }
        return oldCommande;
    }

    @Override
    public boolean delete(Long id) {
        Commande commande = commandeRepository.findById(id).orElse(null);
        if (commande != null) {
            commandeRepository.delete(commande);
            return true;
        }
        return false;
    }
}
