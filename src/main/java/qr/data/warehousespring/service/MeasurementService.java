package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Measurement;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.repasitory.MeasurementRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepasitory measurementRepasitory;
    public List<Measurement> getAll(){
        return measurementRepasitory.findAll();
    }

    public Measurement getById(Integer id){
        Optional<Measurement> byId = measurementRepasitory.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public Result add(Measurement measurement){
        if(measurement.getName()==null){
            return new Result("Name is null",false);
        }
        measurementRepasitory.save(measurement);
        return new Result("Successfull Added",true);

    }

    public  Result uppdate(Measurement measurement,Integer id){
        Optional<Measurement> byId = measurementRepasitory.findById(id);
        if(byId.isEmpty()){
            return new Result("Measurement Not Found",false);
        }
        if(measurement.getName()==null){
            return new Result("Name is null",false);
        }
        Measurement updating=byId.get();
        updating.setName(measurement.getName());
        updating.setStatus(measurement.getStatus());
        measurementRepasitory.save(updating);
        return new Result("Successfull uppdated",true);

    }

    public Result delete(Integer id) {
        Optional<Measurement> byId = measurementRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Measurement not found", false);
        }
        measurementRepasitory.deleteById(id);
        return new Result("Successfull  deleted", true);
    }
}
