package models;

import lombok.Data;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer writer = (Writer) o;
        return id == writer.id && firstName.equals(writer.firstName) && lastName.equals(writer.lastName) && posts.equals(writer.posts) && region.equals(writer.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, posts, region);
    }
}
