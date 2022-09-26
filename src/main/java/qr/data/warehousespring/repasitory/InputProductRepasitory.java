package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.InputProduct;

public interface InputProductRepasitory extends JpaRepository<InputProduct,Integer> {
}
