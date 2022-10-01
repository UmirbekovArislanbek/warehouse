package qr.data.warehousespring.repasitory;

import org.springframework.data.jpa.repository.JpaRepository;
import qr.data.warehousespring.entity.AttechmentContent;

import java.util.Optional;

public interface AttechmentContentRepasitory extends JpaRepository<AttechmentContent,Integer> {
    Optional<AttechmentContent> getAttechmentContentByAttechment(Integer attachment_id);
}
