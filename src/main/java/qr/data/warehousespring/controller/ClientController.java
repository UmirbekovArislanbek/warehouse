package qr.data.warehousespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Client;
import qr.data.warehousespring.service.ClientService;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id){
        return   clientService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Client client){
        return clientService.add(client);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Client client){
        return clientService.uppdate(client,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return clientService.delete(id);
    }
}
