package qr.data.warehousespring.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import qr.data.warehousespring.entity.parent.Parent;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
public class Warehouse extends Parent {


}
