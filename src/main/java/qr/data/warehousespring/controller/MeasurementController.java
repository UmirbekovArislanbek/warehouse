package qr.data.warehousespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Measurement;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;
    @GetMapping
    public List<Measurement> getAll(){
        return measurementService.getAll();
    }
    @GetMapping("/{id}")
    public Measurement getById(@PathVariable Integer id){
        return   measurementService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Measurement measurement){
        return measurementService.add(measurement);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Measurement measurement){
        return measurementService.uppdate(measurement,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return measurementService.delete(id);
    }
}
