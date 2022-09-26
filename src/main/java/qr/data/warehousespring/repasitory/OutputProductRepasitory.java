package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.OutputProduct;

public interface OutputProductRepasitory extends JpaRepository<OutputProduct,Integer> {
}
