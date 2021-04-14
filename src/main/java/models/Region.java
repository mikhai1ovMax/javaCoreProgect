package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "region", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Region {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "writer")
    private List<Writer> writers;

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Region(String name) {
        this.name = name;
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
