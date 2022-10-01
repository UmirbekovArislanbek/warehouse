package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.User;

public interface UserRepasitory extends JpaRepository<User,Integer> {
    boolean existsByPhoneNumber(String phoneNumber);

    boolean existsByCode(String code);
}
