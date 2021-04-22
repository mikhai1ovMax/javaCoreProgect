package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "writer", schema = "public")
@NoArgsConstructor
@AllArgsConstructor
public class Writer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @OneToMany(mappedBy = "writer", fetch = FetchType.LAZY)
    private List<Post> posts;
    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    public Writer(String firstName, String lastName, List<Post> posts, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
        this.region = region;
    }

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
