package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.Currency;

public interface CurrencyRepasitory extends JpaRepository<Currency,Integer> {
}
