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
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "region", targetEntity = Writer.class)
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
