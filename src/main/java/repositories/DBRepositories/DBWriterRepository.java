package repositories.DBRepositories;

import models.Region;
import models.Writer;
import repositories.WriterRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWriterRepository implements WriterRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private DBPostRepository dbPostRepository = new DBPostRepository();
    private DBRegionRepository dbRegionRepository = new DBRegionRepository();
    private final String getAllQuery = "select * from writer";

    public DBWriterRepository() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Writer save(Writer object) {
        return null;
    }

    @Override
    public Writer update(Writer object) {
        return null;
    }

    @Override
    public Writer getById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(getAllQuery + " where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Writer writer = getNextWriter(resultSet);
        closeAll();
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                writers.add(getNextWriter(resultSet));
            }
            closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return writers;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement("delete from writer where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private Writer getNextWriter(ResultSet resultSet) {
        //TODO rewrite using join
        Writer writer = new Writer();
        try {
            writer.setId(resultSet.getInt("id"));
            writer.setFirstName(resultSet.getString("first_name"));
            writer.setLastName(resultSet.getString("last_name"));
            writer.setRegion(dbRegionRepository.getById(resultSet.getInt("region_id")));
            writer.setPosts(dbPostRepository.getPostsByWriterId(writer.getId()));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return writer;
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
