package repositories;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Post;
import models.Region;

import javax.print.DocFlavor;
import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonRegionRepository implements RegionRepository {
    private final String JSON_PATH = "src\\main\\resources\\files\\region.json";

    Type regionListType = new TypeToken<List<Region>>(){}.getType();
    Gson gson = new Gson();

    @Override
    public Region save(Region region) {
        List<Region> regions = getAllInternal();
        if(regions == null)
            regions = new ArrayList<>();
        region.setId(regions.size());
        regions.add(region);
        saveRegionList(regions);
        return region;
    }

    @Override
    public Region update(Region region) {
        List<Region> regions = getAllInternal();
        for(int i = 0; i < regions.size(); i++){
            if(regions.get(i).getId() == region.getId()) {
                regions.set(i, region);
                break;
            }
        }
        saveRegionList(regions);
        return region;
    }

    private void saveRegionList(List<Region> regions){
        try (FileWriter fileWriter = new FileWriter(JSON_PATH)){
            fileWriter.write(gson.toJson(regions));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Region getById(Integer id) {
        List<Region> regions = getAllInternal();
        if(regions == null)
            return null;
        return regions.stream().filter(region -> region.getId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Region> getAll() {
        return getAllInternal();
    }

    private List<Region> getAllInternal() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new FileReader(JSON_PATH));
            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return gson.fromJson(stringBuilder.toString(), regionListType);
    }

    @Override
    public void deleteById(Integer id) {
        List<Region> regions = getAllInternal();
        regions.removeIf(i-> i.getId() == id);
        saveRegionList(regions);
    }
}
