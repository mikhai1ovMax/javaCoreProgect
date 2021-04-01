package models;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Post {
    private int id;
    private String content;
    private LocalDateTime created;
    private LocalDateTime updated;

    public Post(int id, String content, LocalDateTime created) {
        this.id = id;
        this.content = content;
        this.created = created;
    }
    public Post(String content) {
        this.content = content;
    }

    public Post() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(content, post.content) && Objects.equals(created, post.created) && Objects.equals(updated, post.updated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, created, updated);
    }


}
