package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Output;

public interface OutputRepasitory extends JpaRepository<Output,Integer> {
}
