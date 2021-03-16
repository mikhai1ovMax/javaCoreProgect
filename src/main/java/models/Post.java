package models;

import lombok.Data;

import java.time.LocalDateTime;

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

}
