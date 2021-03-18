package repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JsonWriterRepository implements WriterRepository {
    private final String JSON_PATH = "src\\main\\resources\\files\\writers.json";
    private final Type writerListType = new TypeToken<List<Writer>>(){}.getType();
    private final Gson gson = new Gson();

    @Override
    public Writer save(Writer writer) {
        List<Writer> writers = getAllInternal();

        if (Objects.isNull(writers))
            writers = new ArrayList<>();
        writer.setId(writers.size());
        writers.add(writer);
        saveWriterList(writers);
        return writer;
    }

    @Override
    public Writer update(Writer writer) {
        List<Writer> writers = getAllInternal();
        for (int i = 0; i < writers.size(); i++) {
            if (writers.get(i).getId() == writer.getId()) {
                writers.set(i, writer);
                break;
            }
        }
        saveWriterList(writers);
        return writer;
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
        if (writers == null)
            return null;
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
        writers.removeIf(i -> i.getId() == id);
        saveWriterList(writers);
    }
}
