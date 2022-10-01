package qr.data.warehousespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.InputDto;
import qr.data.warehousespring.entity.Input;
import qr.data.warehousespring.service.InputService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/input")
public class InputController {

    InputService inputService;

    @GetMapping
    public List<Input> getAll(){
        return inputService.getAll();
    }
    @GetMapping("/{id}")
    public Input get(@PathVariable Integer id){
        return inputService.getById(id);
    }
    @PostMapping
    public Result  add(@RequestBody InputDto input){
        return inputService.add(input);
    }
    @PutMapping("/{id}")
    public Result update(@RequestBody InputDto inputDto,@PathVariable Integer id){
        return inputService.update(inputDto,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return inputService.deleteById(id);
    }

}
