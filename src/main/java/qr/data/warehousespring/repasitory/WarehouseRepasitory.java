package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Warehouse;

public interface WarehouseRepasitory extends JpaRepository<Warehouse,Integer>{
}
