package qr.data.warehousespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.ProductDto;
import qr.data.warehousespring.entity.Attechment;
import qr.data.warehousespring.entity.Category;
import qr.data.warehousespring.entity.Measurement;
import qr.data.warehousespring.entity.Product;
import qr.data.warehousespring.repasitory.AttechmentRepasitory;
import qr.data.warehousespring.repasitory.CategoryRepasitory;
import qr.data.warehousespring.repasitory.MeasurementRepasitory;
import qr.data.warehousespring.repasitory.ProductRepasitory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    ProductRepasitory productRepository;
    CategoryRepasitory categoryRepository;
    MeasurementRepasitory measurementRepository;
    AttechmentRepasitory attachmentRepository;

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public Product getById(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        return byId.orElse(null);
    }

    public Result addProduct(ProductDto productDto) {
        Optional<Category> categoryById = categoryRepository.findById(productDto.getCategoryId());
        if (categoryById.isEmpty()) {
            return new Result("Category not found", false);
        }
        Category category = categoryById.get();
        Optional<Attechment> attachmentById = attachmentRepository.findById(productDto.getPhotoId());
        if (attachmentById.isEmpty()) {
            return new Result("Photo not found", false);
        }
        Attechment attachment = attachmentById.get();
        Optional<Measurement> measurementById = measurementRepository.findById(productDto.getMeasurementId());
        if (measurementById.isEmpty()) {
            return new Result("Measurement not found", false);
        }
        Measurement measurement = measurementById.get();
        Product product = new Product();
        product.setCategory(category);
        product.setMeasurement(measurement);

        String code = UUID.randomUUID().toString();
        boolean b = productRepository.existsProductByCode(code);
        if (b) {
            return new Result("This code already exist", false);
        }
        product.setCode(code);
        product.setPhotoId(attachment);
        product.setStatus(productDto.isActive());
        product.setName(productDto.getName());
        productRepository.save(product);
        return new Result("Successfull saved", true);
    }

    public Result update(Integer id, ProductDto productDto) {
        Optional<Product> byId1product = productRepository.findById(id);
        if (byId1product.isEmpty()) {
            return new Result("Product not found", false);
        }
        Optional<Category> categoryById = categoryRepository.findById(productDto.getCategoryId());
        if (categoryById.isEmpty()) {
            return new Result("Category not found", false);
        }
        Category category = categoryById.get();
        Optional<Attechment> attachmentById = attachmentRepository.findById(productDto.getPhotoId());
        if (attachmentById.isEmpty()) {
            return new Result("Photo not found", false);
        }
        Attechment attachment = attachmentById.get();
        Optional<Measurement> measurementById = measurementRepository.findById(productDto.getMeasurementId());
        if (measurementById.isEmpty()) {
            return new Result("Measurement not found", false);
        }
        Measurement measurement = measurementById.get();
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Product not found", false);
        }
        Product product = byId.get();
        product.setCategory(category);
        product.setMeasurement(measurement);
        boolean b = productRepository.existsProductByCode(productDto.getCode());
        if (b) {
            return new Result("This code already exist", false);
        }
        product.setCode(productDto.getCode());
        product.setPhotoId(attachment);
        product.setStatus(productDto.isActive());
        product.setName(productDto.getName());
        productRepository.save(product);
        return new Result("Successfull saved", true);
    }

    public Result delete(Integer id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            return new Result("Product not found", false);
        }
        productRepository.deleteById(id);
        return new Result("Successfull deleted", true);
    }

}
