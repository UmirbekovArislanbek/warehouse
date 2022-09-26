package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Category;

public interface CategoryRepasitory extends JpaRepository<Category,Integer> {
}
