package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Input;

public interface InputRepasitory extends JpaRepository<Input,Integer> {
}
