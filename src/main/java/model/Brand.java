package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Brand {

    @Id
    String id;

    String brand;

    public Brand(String id,String brand){
        this.id=id;
        this.brand=brand;
    }
    public Brand() {
    }
}
