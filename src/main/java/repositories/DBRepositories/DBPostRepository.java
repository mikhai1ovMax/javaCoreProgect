package repositories.DBRepositories;

import models.Post;
import repositories.PostRepository;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DBPostRepository implements PostRepository {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
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
        try {
            preparedStatement = connection.prepareStatement("insert into region values (?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, object.getContent());
            preparedStatement.setString(3, object.getCreated().format(formatter));
            preparedStatement.setString(4, object.getUpdated().format(formatter));
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
    }

    public List<Post> saveWriterIds(List<Post> posts, int writerId) {
        try {
            preparedStatement = connection.prepareStatement("update post set writer_id = ? where id = ?");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        posts.forEach(x -> {
            try {
                preparedStatement.setInt(1, writerId);
                preparedStatement.setInt(2, x.getId());
                preparedStatement.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
        return posts;
    }

    @Override
    public Post update(Post object) {
        try {
            preparedStatement = connection.prepareStatement("update post set content = ?, updated = ? where id = ?");
            preparedStatement.setString(1, object.getContent());
            preparedStatement.setString(2, LocalDateTime.now().format(formatter));
            preparedStatement.setInt(3, object.getId());
            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return object;
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
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return posts;
    }

    private Post getNextPost(ResultSet resultSet) {
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

    @Override
    public void closeConnection() {
        try {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
