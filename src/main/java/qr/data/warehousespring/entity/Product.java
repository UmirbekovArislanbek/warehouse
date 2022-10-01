package qr.data.warehousespring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import qr.data.warehousespring.entity.parent.Parent;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Product extends Parent {

    @ManyToOne
    private Category category;

    @OneToOne
    private Attechment photoId;


    @Column(nullable = false, unique = true)
    private String code;

    @ManyToOne
    private Measurement measurement;


}
