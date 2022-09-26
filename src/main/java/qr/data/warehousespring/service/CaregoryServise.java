package qr.data.warehousespring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qr.data.warehousespring.additional.Result;
import qr.data.warehousespring.dto.CategoryDto;
import qr.data.warehousespring.entity.Category;
import qr.data.warehousespring.repasitory.CategoryRepasitory;

import java.util.List;
import java.util.Optional;

@Service
public class CaregoryServise {
    @Autowired
    CategoryRepasitory categoryRepasitory;

    public List<Category> getAll() {
        return categoryRepasitory.findAll();
    }

    public Category getById(Integer id) {
        Optional<Category> byId = categoryRepasitory.findById(id);
        if (byId.isPresent()) {
            return byId.get();
        }
        return null;
    }

    public Result add(CategoryDto categoryDto) {
        if (categoryDto.getName() == null) {
            return new Result("Name is null", false);
        }
        Category category = new Category();
        category.setName(categoryDto.getName());
        category.setStatus(categoryDto.getStatus());
        if (categoryDto.getParentCategoryid() != null) {
            Optional<Category> byId = categoryRepasitory.findById(categoryDto.getParentCategoryid());
            if (byId.isEmpty()) {
                return new Result("Parent Category not found", false);
            }
            category.setParentcategory(byId.get());
        }
        categoryRepasitory.save(category);
        return new Result("Successfull Added", true);
    }

    public Result uppdate(CategoryDto categoryDto, Integer id) {
        Optional<Category> byId = categoryRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Category Not Found", false);
        }
        if (categoryDto.getName() == null) {
            return new Result("Name is null", false);
        }
        Category category = byId.get();
        category.setName(categoryDto.getName());
        category.setStatus(categoryDto.getStatus());
        if (categoryDto.getParentCategoryid() != null) {
            Optional<Category> byId1 = categoryRepasitory.findById(categoryDto.getParentCategoryid());
            if (byId.isEmpty()) {
                return new Result("Parent Category not found", false);
            }
            category.setParentcategory(byId1.get());
        }
        categoryRepasitory.save(category);
        return new Result("Successfull updated", true);

    }

    public Result delete(Integer id) {
        Optional<Category> byId = categoryRepasitory.findById(id);
        if (byId.isEmpty()) {
            return new Result("Category not found", false);
        }
        categoryRepasitory.deleteById(id);
        return new Result("Successfull  deleted", true);
    }
}
