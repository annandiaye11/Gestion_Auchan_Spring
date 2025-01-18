package sn.api.gestionauchanspring.services.impl;

import org.springframework.stereotype.Service;
import sn.api.gestionauchanspring.data.entities.Client;
import sn.api.gestionauchanspring.data.repositories.ClientRepository;
import sn.api.gestionauchanspring.services.ClientService;

import java.util.ArrayList;
import java.util.List;

@Service
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
    public Client update(Client client) {
        Client oldClient = clientRepository.findById(client.getId()).orElse(null);
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


}
