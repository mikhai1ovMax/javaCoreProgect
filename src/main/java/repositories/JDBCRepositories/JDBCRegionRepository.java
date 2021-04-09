package repositories.JDBCRepositories;

import models.Region;
import repositories.RegionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCRegionRepository implements RegionRepository {

    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String getAllQuery = "select * from region";



    @Override
    public Region save(Region object) {
        try {
            preparedStatement = JDBCConnector.getStatement("insert into region values (?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, object.getName());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
    }

    @Override
    public Region update(Region object) {
        try {
            preparedStatement = JDBCConnector.getStatement("update region set name = ? where id = ?");
            preparedStatement.setString(1, object.getName());
            preparedStatement.setInt(2, object.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
    }

    @Override
    public Region getById(Integer id) {
        try {
            preparedStatement = JDBCConnector.getStatement(getAllQuery + " where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        Region region = getNextRegion(resultSet);
        return region;
    }

    @Override
    public List<Region> getAll() {
        List<Region> regions = new ArrayList<>();
        try {
            preparedStatement = JDBCConnector.getStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                regions.add(getNextRegion(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return regions;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            preparedStatement = JDBCConnector.getStatement("delete from region where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
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

}
