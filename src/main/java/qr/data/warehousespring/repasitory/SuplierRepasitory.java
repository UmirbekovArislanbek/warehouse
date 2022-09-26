package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Suplier;

public interface SuplierRepasitory extends JpaRepository<Suplier,Integer> {

    boolean  existsSuplierByPhoneNumber(String phoneNumber);





}
