package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Product;

public interface ProductRepasitory extends JpaRepository<Product,Integer> {
}
