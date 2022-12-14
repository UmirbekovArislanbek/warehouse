package qr.data.warehousespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Timestamp timestamp;

    @ManyToOne
    private Warehouse warehouse;

    @ManyToOne
    private Currency currency;


    @Column(nullable = false, unique = true)
    private String factureNumber;

    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Client client;


}
