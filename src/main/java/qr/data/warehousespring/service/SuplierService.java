package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Client;
import qr.data.warehousespring.entity.Suplier;
import qr.data.warehousespring.repasitory.SuplierRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class SuplierService {

    @Autowired
    SuplierRepasitory suplierRepasitory;

    public List<Suplier> getAll() {
        return suplierRepasitory.findAll();
    }

    public Suplier getById(Integer id) {
        Optional<Suplier> byId = suplierRepasitory.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result add(Suplier suplier) {
        if (suplier.getPhoneNumber() == null) {
            return new Result("Phone Number is null", false);
        }
        if (suplierRepasitory.existsSuplierByPhoneNumber(suplier.getPhoneNumber())) {
            return new Result("This phone nummber alredy exist", false);
        }
        suplierRepasitory.save(suplier);
        return new Result("Successfull Added", true);
    }

    public Result uppdate(Suplier suplier, Integer id) {
        Optional<Suplier> byId = suplierRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Suplier Not Found", false);
        }
        if (suplier.getPhoneNumber() == null) {
            return new Result("Phone Number is null", false);
        }
        if (suplierRepasitory.existsSuplierByPhoneNumber(suplier.getPhoneNumber())) {
            return new Result("This phone nummber alredy exist", false);
        }
        Suplier updating = byId.get();
        updating.setName(suplier.getName());
        updating.setStatus(suplier.getStatus());
        updating.setPhoneNumber(suplier.getPhoneNumber());
        suplierRepasitory.save(updating);
        return new Result("Successfull uppdated", true);
    }

    public Result delete(Integer id) {
        Optional<Suplier> byId = suplierRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Suplier not found", false);
        }
        suplierRepasitory.deleteById(id);
        return new Result("Successfull  deleted", true);
    }
}
