package models;

import lombok.Data;

@Data
public class Region {
    private int id;
    private String name;

    public Region(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
