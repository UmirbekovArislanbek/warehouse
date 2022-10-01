package qr.data.warehousespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.OutputDto;
import qr.data.warehousespring.entity.Client;
import qr.data.warehousespring.entity.Currency;
import qr.data.warehousespring.entity.Output;
import qr.data.warehousespring.entity.Warehouse;
import qr.data.warehousespring.repasitory.ClientRepasitory;
import qr.data.warehousespring.repasitory.CurrencyRepasitory;
import qr.data.warehousespring.repasitory.OutputRepasitory;
import qr.data.warehousespring.repasitory.WarehouseRepasitory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutPutService {

    OutputRepasitory outputRepository;
    WarehouseRepasitory warehouseRepository;
    CurrencyRepasitory currencyRepository;
    ClientRepasitory clientRepository;

    public List<Output> getAll() {
        return outputRepository.findAll();
    }

    public Output getById(Integer id) {
        Optional<Output> byId = outputRepository.findById(id);
        return byId.orElse(null);
    }

    public Result add(OutputDto outputDto) {
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(outputDto.getWarehouseId());
        if (warehouseRepositoryById.isEmpty()) {
            return new Result("Warehouse not found", false);
        }
        Warehouse warehouse = warehouseRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(outputDto.getCurrencyId());
        if (currencyRepositoryById.isEmpty()) {
            return new Result("Currency not found", false);
        }
        Currency currency = currencyRepositoryById.get();
        boolean b = clientRepository.existsClientByPhoneNumber(outputDto.getClientPhoneNumber());
        if (b) {
            return new Result("Client phone number already exist", false);
        }
        Client client = new Client(null, outputDto.getClientName(), outputDto.getClientPhoneNumber());
        Output output = new Output();
        output.setClient(client);
        output.setTimestamp(outputDto.getTimestamp());
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(output.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        outputRepository.save(output);
        return new Result("Successfull saved", true);

    }

    public Result update(OutputDto outputDto, Integer id) {
        Optional<Warehouse> warehouseRepositoryById = warehouseRepository.findById(outputDto.getWarehouseId());
        if (warehouseRepositoryById.isEmpty()) {
            return new Result("Warehouse not found", false);
        }
        Warehouse warehouse = warehouseRepositoryById.get();
        Optional<Currency> currencyRepositoryById = currencyRepository.findById(outputDto.getCurrencyId());
        if (currencyRepositoryById.isEmpty()) {
            return new Result("Currency not found", false);
        }
        Currency currency = currencyRepositoryById.get();
        boolean b = clientRepository.existsClientByPhoneNumber(outputDto.getClientPhoneNumber());
        if (b) {
            return new Result("Client phone number already exist", false);
        }
        Client client = new Client(null, outputDto.getClientName(), outputDto.getClientPhoneNumber());
        Optional<Output> byId = outputRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Output not found", false);
        }
        Output output = byId.get();
        output.setClient(client);
        output.setTimestamp(outputDto.getTimestamp());
        output.setCurrency(currency);
        output.setWarehouse(warehouse);
        output.setFactureNumber(output.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        outputRepository.save(output);
        return new Result("Successfull updated", true);
    }

    public Result deleteById(Integer id) {
        Optional<Output> byId = outputRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Output not found", false);
        }
        outputRepository.deleteById(id);
        return new Result("Successfull deleted", true);
    }
}
