package repositories;

import com.google.gson.Gson;
import models.Writer;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonWriterRepository implements WriterRepository {
    Gson gson = new Gson();

    @Override
    public void saveData(Writer writer) {
        List<Writer> writers = new ArrayList<>();
        try (FileWriter fileWriter = new FileWriter("writers.json", false)) {
            writers = readData();
            writers.add(writer);
            fileWriter.write(gson.toJson(writers));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Writer> readData() {
        List<Writer> writers;
        try {
            FileReader fileReader = new FileReader("writers.json");
            writers = gson.fromJson(fileReader, ArrayList.class);
        } catch (FileNotFoundException e) {
            writers = new ArrayList<>();
        }
        return writers;
    }


    @Override
    public void updateData() {

    }
}
