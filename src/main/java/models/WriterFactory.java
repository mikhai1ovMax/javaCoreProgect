package models;

import repositories.JsonPostRepository;
import repositories.JsonRegionRepository;

import java.util.List;

public class WriterFactory {
    JsonPostRepository jsonPostRepository = new JsonPostRepository();
    JsonRegionRepository jsonRegionRepository = new JsonRegionRepository();

    Writer writer = new Writer();
    public void setId(int i){
        writer.setId(i);
    }
    public void setFirstName(String firstName){
        writer.setFirstName(firstName);
    }
    public void setLastName(String lastName){
        writer.setLastName(lastName);
    }
    public void setPostsByIdList(List<Integer> id){
        id.forEach(i->writer.getPosts().add(jsonPostRepository.getById(i)));
    }
    public void setRegionById(int id){
        writer.setRegion(jsonRegionRepository.getById(id));
    }
    public Writer getWriter(){
        return writer;
    }
}
