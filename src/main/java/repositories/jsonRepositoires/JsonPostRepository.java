package repositories.jsonRepositoires;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Post;
import repositories.PostRepository;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;

public class JsonPostRepository implements PostRepository {
    private final String JSON_PATH = "src\\main\\resources\\files\\post.json";
    private final Type postListType = new TypeToken<List<Post>>() {}.getType();
    private final Gson gson = new Gson();

    private Scanner scanner;
    private FileWriter fileWriter;

    @Override
    public Post save(Post post) {
        List<Post> posts = getAllInternal();
        if (Objects.isNull(posts))
            posts = new ArrayList<>();
        post.setId(posts.size());
        post.setCreated(LocalDateTime.now());
        posts.add(post);
        savePostList(posts);
        return post;
    }

    @Override
    public Post update(Post post) {
        List<Post> posts = getAllInternal();
        posts.forEach(x -> {
            if (x.getId() == post.getId()) {
                x.setContent(post.getContent());
                x.setUpdated(LocalDateTime.now());
            }
        });
        savePostList(posts);
        return post;
    }

    private void savePostList(List<Post> posts) {
        try {
            fileWriter = new FileWriter(JSON_PATH);
            fileWriter.write(gson.toJson(posts));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getById(Integer id) {
        List<Post> posts = getAllInternal();
        if (posts == null)
            return null;
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return getAllInternal();
    }

    private List<Post> getAllInternal() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            scanner = new Scanner(new FileReader(JSON_PATH));
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(stringBuilder.toString(), postListType);
    }

    @Override
    public void deleteById(Integer id) {
        List<Post> posts = getAllInternal();
        posts.removeIf(i -> i.getId() == id);
        savePostList(posts);
    }
}
