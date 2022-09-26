package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Measurement;

public interface MeasurementRepasitory extends JpaRepository<Measurement,Integer> {
}
