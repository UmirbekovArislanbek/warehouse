package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.InputProduct;

import java.util.List;

public interface InputProductRepasitory extends JpaRepository<InputProduct,Integer> {
    List<InputProduct> getInputProductsByInput_Id(Integer id);

}
