package qr.data.warehousespring.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.repasitory.WarehouseRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
      WarehouseRepasitory warehouseRepasitory;

    public List<Warehouse> getAll(){
        return warehouseRepasitory.findAll();
    }

    public Warehouse getById(Integer id){
        Optional<Warehouse> byId = warehouseRepasitory.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public Result add(Warehouse warehouse){
        if(warehouse.getName()==null){
            return new Result("Name is null",false);
        }
        warehouseRepasitory.save(warehouse);
        return new Result("Successfull Added",true);

    }

    public  Result uppdate(Warehouse warehouse,Integer id){
        Optional<Warehouse> byId = warehouseRepasitory.findById(id);
        if(byId.isEmpty()){
            return new Result("Warehouse Not Found",false);
        }
        if(warehouse.getName()==null){
            return new Result("Name is null",false);
        }
        Warehouse warehouseUPP=byId.get();
        warehouseUPP.setName(warehouse.getName());
        warehouseUPP.setStatus(warehouse.getStatus());
        warehouseRepasitory.save(warehouseUPP);
        return new Result("Successfull uppdated",true);

    }

    public Result delete(Integer id){
        Optional<Warehouse> byId = warehouseRepasitory.findById(id);
        if(byId.isEmpty()){
            return new Result("Warehouse not found",false);
        }
        warehouseRepasitory.deleteById(id);
        return new Result("Successfull  deleted",true);
    }

}
