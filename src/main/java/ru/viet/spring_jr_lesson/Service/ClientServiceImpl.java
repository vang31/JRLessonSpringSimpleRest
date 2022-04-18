package ru.viet.spring_jr_lesson.Service;

import org.springframework.stereotype.Service;
import ru.viet.spring_jr_lesson.model.Client;

import java.util.*;

@Service
public class ClientServiceImpl implements ClientService{

    /*
        Using a Map<UUID, Client> as container
    */

    private final Map<UUID, Client> client_Map_Holder = new LinkedHashMap<>();

    @Override
    public void create(Client client) {
        client_Map_Holder.put(client.getId(), client);
    }

    @Override
    public List<Client> readAll() {
        return new ArrayList<>(client_Map_Holder.values());
    }

    @Override
    public Client read(UUID id) {
        return client_Map_Holder.get(id);
    }

    @Override
    public boolean update(Client client, UUID id) {
        if(client_Map_Holder.containsKey(id)) {
            client_Map_Holder.put(client.getId(), client);
            return true;
        }

        return false;
    }

    @Override
    public boolean delete(UUID id) {
        return client_Map_Holder.remove(id) != null;
    }
}
