package qr.data.warehousespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputDto {

    private Timestamp timestamp;
    private Integer warehouseId;
    private Integer currencyId;
    private String factureNumber;
    private String clientName;
    private String clientPhoneNumber;
}
