package repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Post;
import models.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class JsonWriterRepository implements WriterRepository{
    public static final String JSON_PATH = "post.json";

    Type writerListType = new TypeToken<List<Writer>>(){}.getType();
    Gson gson = new Gson();

    @Override
    public void save(Writer writer) {
        List<Writer> writers = getAllInternal();
        writers.add(writer);
        saveWriterList(writers);
    }

    @Override
    public void update(Writer writer) {
        List<Writer> writers = getAllInternal();
        for(int i = 0; i < writers.size(); i++){
            if(writers.get(i).getId() == writer.getId()) {
                writers.set(i, writer);
                break;
            }
        }
        saveWriterList(writers);
    }

    private void saveWriterList(List<Writer> posts) {
        try (FileWriter fileWriter = new FileWriter(JSON_PATH)) {
            fileWriter.write(gson.toJson(posts));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Writer getById(Integer id) {
        List<Writer> writers = getAllInternal();
        return writers.stream().filter(writer -> writer.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Writer> getAll() {
        return getAllInternal();
    }

    private List<Writer> getAllInternal() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileReader(JSON_PATH));
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(stringBuilder.toString(), writerListType);
    }

    @Override
    public void deleteById(Integer id) {
        List<Writer> writers = getAllInternal();
        for (Writer writer : writers) {
            if(writer.getId() == id){
                writers.remove(writer);
                break;
            }
        }
        saveWriterList(writers);
    }
}
