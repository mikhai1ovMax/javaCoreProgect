package models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(mappedBy = "writer")
    private List<Writer> writers;

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(String name) {
        this.name = name;
    }

    public Region() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return id == region.id && name.equals(region.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
