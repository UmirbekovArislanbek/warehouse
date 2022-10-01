package qr.data.warehousespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.OutputProductDto;
import qr.data.warehousespring.entity.Output;
import qr.data.warehousespring.entity.OutputProduct;
import qr.data.warehousespring.entity.Product;
import qr.data.warehousespring.repasitory.OutputProductRepasitory;
import qr.data.warehousespring.repasitory.OutputRepasitory;
import qr.data.warehousespring.repasitory.ProductRepasitory;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputProductService {
    OutputProductRepasitory outputProductRepasitory;
    ProductRepasitory productRepasitory;
    OutputRepasitory outputRepasitory;

    public List<OutputProduct> getAll() {
        return outputProductRepasitory.findAll();
    }

    public OutputProduct getById(Integer id) {
        Optional<OutputProduct> byId = outputProductRepasitory.findById(id);
        return byId.orElse(null);
    }

    public Result add(OutputProductDto outputProductDto) {
        Optional<Product> productById = productRepasitory.findById(outputProductDto.getProductId());
        if (productById.isEmpty()) {
            return new Result("Product not found", false);
        }
        Product product = productById.get();
        Optional<Output> outputRepasitoryById = outputRepasitory.findById(outputProductDto.getOutputId());
        if (outputRepasitoryById.isEmpty()) {
            return new Result("Output not found", false);
        }
        Output output = outputRepasitoryById.get();
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(product);
        outputProduct.setOutput(output);
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepasitory.save(outputProduct);
        return new Result("Successfull added", true);
    }

    public Result update(Integer id, OutputProductDto outputProductDto) {
        Optional<OutputProduct> outputProductRepasitoryById = outputProductRepasitory.findById(id);
        if (outputProductRepasitoryById.isEmpty()) {
            return new Result("Output Product not found", false);
        }
        Optional<Product> productById = productRepasitory.findById(outputProductDto.getProductId());
        if (productById.isEmpty()) {
            return new Result("Product not found", false);
        }
        Product product = productById.get();
        Optional<Output> outputRepasitoryById = outputRepasitory.findById(outputProductDto.getOutputId());
        if (outputRepasitoryById.isEmpty()) {
            return new Result("Output not found", false);
        }
        Output output = outputRepasitoryById.get();
        OutputProduct outputProduct = new OutputProduct();
        outputProduct.setProduct(product);
        outputProduct.setOutput(output);
        outputProduct.setAmount(outputProductDto.getAmount());
        outputProduct.setPrice(outputProductDto.getPrice());
        outputProductRepasitory.save(outputProduct);
        return new Result("Successfull updated", true);
    }

    public Result delete(Integer id) {
        Optional<OutputProduct> byId = outputProductRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Output Product not found", false);
        }
        outputProductRepasitory.deleteById(id);
        return new Result("Successfull deleted", true);
    }

}



