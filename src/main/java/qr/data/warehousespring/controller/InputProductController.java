package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.InputProductDto;
import qr.data.warehousespring.entity.InputProduct;
import qr.data.warehousespring.service.InputProductService;

import java.util.List;

@RestController
@RequestMapping("/inputproduct")
@RequiredArgsConstructor
public class InputProductController {

    InputProductService inputProductService;


    @GetMapping
    public List<InputProduct> getAll() {
        return inputProductService.getAll();
    }

    @GetMapping("/{id}")
    public InputProduct getById(@PathVariable Integer id) {
        return inputProductService.getById(id);
    }

    @GetMapping("/{inputId}")
    public List<InputProduct> getByInputId(@PathVariable Integer inputId) {
        return inputProductService.getByInputId(inputId);
    }

    @PostMapping
    public Result add(@RequestBody InputProductDto inputProductDto) {
        return inputProductService.add(inputProductDto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody InputProductDto inputProductDto, @PathVariable Integer id) {
        return inputProductService.update(inputProductDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return inputProductService.deleteById(id);
    }

}
