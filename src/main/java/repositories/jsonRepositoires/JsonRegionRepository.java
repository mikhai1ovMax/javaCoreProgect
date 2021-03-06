package repositories.jsonRepositoires;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import models.Region;
import repositories.RegionRepository;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class JsonRegionRepository implements RegionRepository {
    private final String JSON_PATH = "src\\main\\resources\\files\\region.json";
    private final Type regionListType = new TypeToken<List<Region>>() {
    }.getType();
    private final Gson gson = new Gson();

    private Scanner scanner;
    private FileWriter fileWriter;

    @Override
    public Region save(Region region) {
        List<Region> regions = getAllInternal();
        if (Objects.isNull(regions))
            regions = new ArrayList<>();
        region.setId(regions.size());
        regions.add(region);
        saveRegionList(regions);
        return region;
    }

    @Override
    public Region update(Region region) {
        List<Region> regions = getAllInternal();
        regions.forEach(x -> {
            if (x.getId() == region.getId())
                x.setName(region.getName());
        });
        saveRegionList(regions);
        return region;
    }

    private void saveRegionList(List<Region> regions) {
        try {
            FileWriter fileWriter = new FileWriter(JSON_PATH);
            fileWriter.write(gson.toJson(regions));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Region getById(Integer id) {
        List<Region> regions = getAllInternal();
        if (regions == null)
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
            scanner = new Scanner(new FileReader(JSON_PATH));
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
        regions.removeIf(i -> i.getId() == id);
        saveRegionList(regions);
    }

}
