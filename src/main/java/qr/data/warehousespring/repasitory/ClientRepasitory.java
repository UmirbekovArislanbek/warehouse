package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Client;

public interface ClientRepasitory extends JpaRepository<Client,Integer> {

    boolean existsClientByPhoneNumber(String phoneNumber);
}
