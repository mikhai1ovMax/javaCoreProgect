package repositories.DBRepositories;

import models.Region;
import repositories.RegionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBRegionRepository implements RegionRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String getAllQuery = "select * from region";

    public DBRegionRepository() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Region save(Region object) {
        try {
            preparedStatement = connection.prepareStatement("insert into region values (?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, object.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeAll();
        return object;
    }

    @Override
    public Region update(Region object) {
        try {
            preparedStatement = connection.prepareStatement("update region set name = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        closeAll();
        return object;
    }

    @Override
    public Region getById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(getAllQuery + " where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        Region region = getNextRegion(resultSet);
        closeAll();
        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                regions.add(getNextRegion(resultSet));
            }
            closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement("delete from region where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        closeAll();
    }

    private Region getNextRegion(ResultSet resultSet) {
        Region region = new Region();
        try {
            region.setId(resultSet.getInt("id"));
            region.setName(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return region;
    }

    private void closeAll() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
