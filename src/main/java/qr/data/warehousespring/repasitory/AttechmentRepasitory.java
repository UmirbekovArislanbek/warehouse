package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Attechment;

public interface AttechmentRepasitory extends JpaRepository<Attechment,Integer> {
}
