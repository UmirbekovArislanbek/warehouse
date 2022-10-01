package qr.data.warehousespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.InputDto;
import qr.data.warehousespring.entity.Currency;
import qr.data.warehousespring.entity.Input;
import qr.data.warehousespring.entity.Suplier;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.repasitory.CurrencyRepasitory;
import qr.data.warehousespring.repasitory.InputRepasitory;
import qr.data.warehousespring.repasitory.SuplierRepasitory;
import qr.data.warehousespring.repasitory.WarehouseRepasitory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@RequiredArgsConstructor
public class InputService {
    InputRepasitory inputRepository;
    WarehouseRepasitory warehouseRepository;
    SuplierRepasitory supplierRepository;
    CurrencyRepasitory currencyRepository;

    public List<Input> getAll() {
        return inputRepository.findAll();
    }

    public Input getById(Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        return byId.orElse(null);
    }

    public Result add(InputDto inputDto) {
        Optional<Warehouse> warehouseById = warehouseRepository.findById(inputDto.getWarehouseId());
        if (warehouseById.isEmpty()) {
            return new Result("Warehouse not found", false);
        }
        Warehouse warehouse = warehouseById.get();
        Optional<Suplier> supplierRepositoryById = supplierRepository.findById(inputDto.getSupplierId());
        if (supplierRepositoryById.isEmpty()) {
            return new Result("Supplier not found", false);
        }
        Suplier supplier = supplierRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(inputDto.getCurrencyId());
        if (currencyRepositoryById.isEmpty()) {
            return new Result("Currency not found", false);
        }
        Currency currency = currencyRepositoryById.get();
        Input input = new Input();
        input.setCode(UUID.randomUUID().toString());
        input.setTimestamp(inputDto.getTimestamp());
        input.setFactureNumber(input.getFactureNumber());
        input.setSuplier(supplier);
        input.setWarehouse(warehouse);
        input.setCurrency(currency);
        inputRepository.save(input);
        return new Result("Successfull saved", true);
    }

    public Result update(InputDto inputDto, Integer id) {
        Optional<Warehouse> warehouseById = warehouseRepository.findById(inputDto.getWarehouseId());
        if (warehouseById.isEmpty()) {
            return new Result("Warehouse not found", false);
        }
        Warehouse warehouse = warehouseById.get();
        Optional<Suplier> supplierRepositoryById = supplierRepository.findById(inputDto.getSupplierId());
        if (supplierRepositoryById.isEmpty()) {
            return new Result("Supplier not found", false);
        }
        Suplier supplier = supplierRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(inputDto.getCurrencyId());
        if (currencyRepositoryById.isEmpty()) {
            return new Result("Currency not found", false);
        }
        Currency currency = currencyRepositoryById.get();

        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Input not found", false);
        }
        Input input = byId.get();
        input.setTimestamp(inputDto.getTimestamp());
        input.setFactureNumber(input.getFactureNumber());
        input.setSuplier(supplier);
        input.setWarehouse(warehouse);
        input.setCurrency(currency);
        inputRepository.save(input);
        return new Result("Successfull saved", true);
    }

    public Result deleteById(Integer id) {
        Optional<Input> byId = inputRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Input not found", false);
        }
        inputRepository.deleteById(id);
        return new Result("Successfull deleted", true);
    }
}
