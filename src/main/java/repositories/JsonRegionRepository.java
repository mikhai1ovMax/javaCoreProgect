package repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Region;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonRegionRepository implements RegionRepository {
    public static final String JSON_PATH = "region.json";
    Gson gson = new Gson();
    @Override
    public void save(Region object) {
        try (Writer writer = new BufferedWriter(new FileWriter(JSON_PATH))) {
            List<Region> regions = getAll();
            writer.write(gson.toJson(Arrays.asList(regions, object)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Region writer) {

    }

    @Override
    public Region getById(Integer id) {
        return null;
    }

    @Override
    public List<Region> getAll() {
        Reader reader = null;
        try {
             reader = new BufferedReader(new FileReader(JSON_PATH));
             return  gson.fromJson(reader,  new TypeToken<List<String>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<Region>();
    }

    @Override
    public void deleteById(Integer id) {

    }
}
