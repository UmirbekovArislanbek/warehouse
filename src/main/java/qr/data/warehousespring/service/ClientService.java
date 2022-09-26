package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Client;
import qr.data.warehousespring.repasitory.ClientRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepasitory clientRepasitory;

    public List<Client> getAll() {
        return clientRepasitory.findAll();
    }

    public Client getById(Integer id) {
        Optional<Client> byId = clientRepasitory.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result add(Client client) {
        if (client.getPhoneNumber() == null) {
            return new Result("Phone Number is null", false);
        }
        if (clientRepasitory.existsClientByPhoneNumber(client.getPhoneNumber())) {
            return new Result("This phone nummber alredy exist", false);
        }
        clientRepasitory.save(client);
        return new Result("Successfull Added", true);
    }

    public Result uppdate(Client client, Integer id) {
        Optional<Client> byId = clientRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Client Not Found", false);
        }
        if (client.getPhoneNumber() == null) {
            return new Result("Phone Number is null", false);
        }
        if (clientRepasitory.existsClientByPhoneNumber(client.getPhoneNumber())) {
            return new Result("This phone nummber alredy exist", false);
        }
        Client updating = byId.get();
        updating.setName(client.getName());
        updating.setPhoneNumber(client.getPhoneNumber());
        clientRepasitory.save(updating);
        return new Result("Successfull uppdated", true);
    }

    public Result delete(Integer id) {
        Optional<Client> byId = clientRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Client not found", false);
        }
        clientRepasitory.deleteById(id);
        return new Result("Successfull  deleted", true);
    }
}
