package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
public class Car implements Serializable {

@Id
public String id;

public String brand;
public int year;
public String color;
public int price;
public boolean soldState;

    public Car(String id, String brand, int year, String color, int price, boolean soldState) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.price = price;
        this.soldState = soldState;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", brand='" + brand + '\'' +
                ", year=" + year +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", soldState=" + soldState +
                '}';
    }
}
