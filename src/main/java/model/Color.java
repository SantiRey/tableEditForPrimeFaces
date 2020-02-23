package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Color {
    @Id
    String id;

    String color;

    public Color(String id, String color) {
        this.id=id;
        this.color=color;
    }
    public Color() {

    }

    @Override
    public String toString() {
        return "Colors{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
