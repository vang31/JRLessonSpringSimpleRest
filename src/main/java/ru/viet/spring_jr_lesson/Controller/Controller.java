package ru.viet.spring_jr_lesson.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.viet.spring_jr_lesson.Service.ClientService;
import ru.viet.spring_jr_lesson.model.Client;

import java.util.List;
import java.util.UUID;

import static java.util.Objects.nonNull;


@RestController
public class Controller {

    private final ClientService clientService;

    @Autowired
    public Controller(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping(value = "/clients")
    public ResponseEntity<List<Client>> readAll() {
        List<Client> clients = clientService.readAll();

        return nonNull(clients) && !clients.isEmpty() ?
                new ResponseEntity<>(clients, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/clients/{id}")
    public ResponseEntity<Client> read(@PathVariable UUID id) {
        Client clients = clientService.read(id);

        return nonNull(clients) ?
                new ResponseEntity<>(clients, HttpStatus.OK):
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping(value = "/clients")
    public ResponseEntity<?> create(@RequestBody Client client) {
        clientService.create(client);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/clients/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id,
                                    @RequestBody Client client) {
        final boolean updated = clientService.update(client, id);

        return  updated ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/clients/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        final boolean deleted = clientService.delete(id);

        return deleted ?
                new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
