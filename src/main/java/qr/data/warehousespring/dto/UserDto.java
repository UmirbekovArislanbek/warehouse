package qr.data.warehousespring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String firstName;

    private String lastName;
    private String phoneNumber;
    private String code;
    private String password;
    private boolean status;

    private List<Integer> warehousesId;
}
