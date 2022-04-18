package ru.viet.spring_jr_lesson.Service;

import ru.viet.spring_jr_lesson.model.Client;

import java.util.List;
import java.util.UUID;

public interface ClientService {
    /*
        Create a client
    */
    void create(Client client);

    /*
        Get all clients
    */
    List<Client> readAll();

    /*
        Get client by id
    */
    Client read(UUID id);

    /*
        update client by id
    */
    boolean update(Client client, UUID id);

    /*
        delete client by id
    */
    boolean delete(UUID id);
}
