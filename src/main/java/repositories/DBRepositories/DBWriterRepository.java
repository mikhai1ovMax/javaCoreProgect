package repositories.DBRepositories;

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





    @Override
    public Writer save(Writer object) {
        try {
            preparedStatement = DBConnector.getStatement("insert into writer values (?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, object.getFirstName());
            preparedStatement.setString(3, object.getLastName());
            preparedStatement.setInt(4, object.getRegion().getId());
            preparedStatement.execute();
            dbPostRepository.saveWriterIds(object.getPosts(), object.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Writer update(Writer object) {
        try {
            preparedStatement = DBConnector.getStatement("update writer set first_name = ?, last_name = ? where id = ?");
            preparedStatement.setString(1, object.getFirstName());
            preparedStatement.setString(2, object.getLastName());
            preparedStatement.setInt(3, object.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
    }

    @Override
    public Writer getById(Integer id) {
        try {
            preparedStatement = DBConnector.getStatement(getAllQuery + " where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Writer writer = getNextWriter(resultSet);
        return writer;
    }

    @Override
    public List<Writer> getAll() {
        List<Writer> writers = new ArrayList<>();
        try {
            preparedStatement = DBConnector.getStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                writers.add(getNextWriter(resultSet));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return writers;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            preparedStatement = DBConnector.getStatement("delete from writer where id = ?");
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


}
