package qr.data.warehousespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Currency;
import qr.data.warehousespring.service.CurrencyService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;
    @GetMapping
    public List<Currency> getAll(){
        return currencyService.getAll();
    }
    @GetMapping("/{id}")
    public Currency getById(@PathVariable Integer id){
        return   currencyService.getById(id);
    }
    @PostMapping
    public Result add(@RequestBody Currency currency){
        return currencyService.add(currency);
    }
    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Currency currency){
        return currencyService.uppdate(currency,id);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return currencyService.delete(id);
    }
}
