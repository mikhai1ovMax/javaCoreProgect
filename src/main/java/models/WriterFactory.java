package models;

import repositories.GenericRepository;
import repositories.JsonPostRepository;
import repositories.PostRepository;

import java.util.List;

public class WriterFactory {
    Writer writer = new Writer();

    public void setId(int id) {
        writer.setId(id);
    }

    public void setName(String name) {
        writer.setFirstName(name);
    }

    public void setLastName(String lastName) {
        writer.setLastName(lastName);
    }

    public void setPosts(List<Post> posts) {
        writer.setPosts(posts);
    }

    public void setPostsByIdList(List<Integer> postIds){
        GenericRepository repository = new JsonPostRepository();
        List<Post> posts = repository.getAll();
        for (int i =0; i < posts.size(); i++){
            if(postIds.contains(posts.get(i).getId()))
                writer.getPosts().add(posts.get(i));
        }
    }

    public void setRegion(Region region) {
        writer.setRegion(region);
    }

    public Writer getWriter() {
        return writer;
    }

}
