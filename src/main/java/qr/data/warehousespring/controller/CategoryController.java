package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.CategoryDto;
import qr.data.warehousespring.entity.Category;
import qr.data.warehousespring.service.CaregoryServise;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/category")
public class CategoryController {
    CaregoryServise caregoryServise;

    @GetMapping
    public List<Category> getAll() {
        return caregoryServise.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id) {
        return caregoryServise.getById(id);
    }

    @PostMapping
    public Result add(@RequestBody CategoryDto categoryDto) {
        return caregoryServise.add(categoryDto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        return caregoryServise.uppdate(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return caregoryServise.delete(id);
    }
}
