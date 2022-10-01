package qr.data.warehousespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputProductDto {

    private Integer productId;
    private Double amount;
    private Double price;
    private Integer OutputId;

}
