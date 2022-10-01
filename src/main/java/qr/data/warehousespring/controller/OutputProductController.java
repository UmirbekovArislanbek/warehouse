package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.OutputProductDto;
import qr.data.warehousespring.entity.OutputProduct;
import qr.data.warehousespring.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputproduct")
@RequiredArgsConstructor
public class OutputProductController {
    OutputProductService outputProductService;

    @GetMapping
    public List<OutputProduct> getAll() {
        return outputProductService.getAll();
    }

    @GetMapping("/{id}")
    public OutputProduct getById(@PathVariable Integer id) {
        return outputProductService.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody OutputProductDto outputProductDto) {
        return outputProductService.add(outputProductDto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody OutputProductDto outputProductDto, @PathVariable Integer id) {
        return outputProductService.update(id, outputProductDto);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return outputProductService.delete(id);
    }

}
