package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Suplier;
import qr.data.warehousespring.service.SuplierService;

import java.util.List;

@RestController
@RequestMapping("/suplier")
@RequiredArgsConstructor
public class SuplierController {

    SuplierService supplierService;

    @GetMapping
    public List<Suplier> getAll() {
        return supplierService.getAll();
    }

    @GetMapping("/{id}")
    public Suplier getById(@PathVariable Integer id) {
        return supplierService.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody Suplier supplier) {
        return supplierService.add(supplier);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody Suplier supplier) {
        return supplierService.uppdate(supplier, id);
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        return supplierService.delete(id);
    }

}
