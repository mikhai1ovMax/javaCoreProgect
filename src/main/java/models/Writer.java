package models;

import lombok.Data;

import java.util.List;

@Data
public class Writer {
    private int id;
    private String firstName;
    private String lastName;
    private List<Post> posts;
    private Region region;

    public Writer(int id, String firstName, String lastName, List<Post> posts, Region region) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.region = region;
    }

    public Writer(String firstName, String lastName, List<Post> posts, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.region = region;
    }

    public Writer(){}

}
