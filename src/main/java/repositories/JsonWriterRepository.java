package repositories;

import com.google.gson.Gson;
import models.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriterRepository implements WriterRepository{
    Gson gson = new Gson();
    @Override
    public void saveData(Writer writer) {
        try(FileWriter fileWriter = new FileWriter("writers.json", true)){
            fileWriter.write(gson.toJson(writer));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Writer readData() {
        return null;
    }

    @Override
    public void updateData() {

    }
}
