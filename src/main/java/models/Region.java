package models;

import lombok.Data;

import java.util.Objects;

@Data
public class Region {
    private int id;
    private String name;

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
