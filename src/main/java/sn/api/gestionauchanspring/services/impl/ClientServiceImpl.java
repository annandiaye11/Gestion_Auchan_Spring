package sn.api.gestionauchanspring.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.repositories.ClientRepository;
import sn.api.gestionauchanspring.services.ClientService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client getById(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        return client;
    }

    @Override
    public Client create(Client client) {
        Client newClient = clientRepository.save(client);
        return newClient;
    }

    @Override
    public Client update(Long id, Client client) {
        Client oldClient = clientRepository.findById(id).orElse(null);
        if (oldClient != null) {
            oldClient.setName(client.getName());
            oldClient.setTelephone(client.getTelephone());
            clientRepository.save(oldClient);
        }
        return oldClient;
    }

    @Override
    public boolean delete(Long id) {
        Client client = clientRepository.findById(id).orElse(null);
        if (client != null) {
            clientRepository.delete(client);
            return true;
        }
        return false;
    }


    @Override
    public Page<Client> findAll(Pageable pageable) {
        return clientRepository.findAll(pageable);
    }
}
