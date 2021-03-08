package repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Post;
import models.Region;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class JsonPostRepository implements PostRepository {
    public static final String JSON_PATH = "post.json";

    Type postListType = new TypeToken<List<Post>>(){}.getType();
    Gson gson = new Gson();

    @Override
    public void save(Post region) {
        List<Post> regions = getAllInternal();
        regions.add(region);
        savePostList(regions);
    }

    @Override
    public void update(Post post) {
        List<Post> posts = getAllInternal();
        for(int i = 0; i < posts.size(); i++){
            if(posts.get(i).getId() == post.getId()) {
                post.setUpdated(LocalDateTime.now());
                posts.set(i, post);
                break;
            }
        }
        savePostList(posts);
    }

    private void savePostList(List<Post> posts) {
        try (FileWriter fileWriter = new FileWriter(JSON_PATH)) {
            fileWriter.write(gson.toJson(posts));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getById(Integer id) {
        List<Post> posts = getAllInternal();
        return posts.stream().filter(post -> post.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Post> getAll() {
        return getAllInternal();
    }

    private List<Post> getAllInternal() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileReader(JSON_PATH));
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
        for (Post post : posts) {
            if(post.getId() == id){
                posts.remove(post);
                break;
            }
        }
        savePostList(posts);
    }
}
