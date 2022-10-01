package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
@RequiredArgsConstructor
public class WarehouseController {


    WarehouseService warehouseService;

    @GetMapping
    public List<Warehouse> getAll(){
        return warehouseService.getAll();
    }
    @GetMapping("/{id}")
    public Warehouse getById(@PathVariable Integer id){
      return   warehouseService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Warehouse warehouse){
        return warehouseService.add(warehouse);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Warehouse warehouse){
        return warehouseService.uppdate(warehouse,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
            return warehouseService.delete(id);
    }
}
