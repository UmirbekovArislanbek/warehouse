package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.entity.Currency;
import qr.data.warehousespring.entity.Measurement;
import qr.data.warehousespring.repasitory.CurrencyRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepasitory currencyRepasitory;

    public List<Currency> getAll(){
        return currencyRepasitory.findAll();
    }

    public Currency getById(Integer id){
        Optional<Currency> byId = currencyRepasitory.findById(id);
        if (byId.isPresent()){
            return byId.get();
        }
        return null;
    }

    public Result add(Currency currency){
        if(currency.getName()==null){
            return new Result("Name is null",false);
        }
        currencyRepasitory.save(currency);
        return new Result("Successfull Added",true);

    }

    public  Result uppdate(Currency currency,Integer id){
        Optional<Currency> byId = currencyRepasitory.findById(id);
        if(byId.isEmpty()){
            return new Result("Currency Not Found",false);
        }
        if(currency.getName()==null){
            return new Result("Name is null",false);
        }
        Currency updating=byId.get();
        updating.setName(currency.getName());
        updating.setStatus(currency.getStatus());
        currencyRepasitory.save(updating);
        return new Result("Successfull uppdated",true);

    }

    public Result delete(Integer id) {
        Optional<Currency> byId = currencyRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Currency not found", false);
        }
        currencyRepasitory.deleteById(id);
        return new Result("Successfull  deleted", true);
    }
}
