package qr.data.warehousespring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import qr.data.warehousespring.entity.parent.Parent;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Category extends Parent {


    @ManyToOne
    Category parentcategory;


}
