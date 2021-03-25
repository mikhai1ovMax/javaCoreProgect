package repositories.DBRepositories;

import models.Post;
import models.Region;
import repositories.PostRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBPostRepository implements PostRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final String getAllQuery = "select * from post";

    public DBPostRepository() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post save(Post object) {
        return null;
    }

    @Override
    public Post update(Post object) {
        return null;
    }

    @Override
    public Post getById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(getAllQuery + " where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Post post = getNextPost(resultSet);
        closeAll();
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> posts = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                posts.add(getNextPost(resultSet));
            }
            closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    @Override
    public void deleteById(Integer id) {
        try {
            preparedStatement = connection.prepareStatement("delete from post where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Post> getPostsByWriterId(int id) {
        List<Post> posts = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(getAllQuery);
            resultSet = preparedStatement.executeQuery(getAllQuery);
            while (resultSet.next()) {
                if (resultSet.getInt("writer_id") == id)
                    posts.add(getNextPost(resultSet));
            }
            closeAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    private Post getNextPost(ResultSet resultSet) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        Post post = new Post();
        try {
            post.setId(resultSet.getInt("id"));
            post.setContent(resultSet.getString("content"));
            post.setCreated(LocalDateTime.parse(resultSet.getString("created"), formatter));
            post.setUpdated(LocalDateTime.parse(resultSet.getString("updated"), formatter));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return post;
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
