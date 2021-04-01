package services;

import models.Post;
import models.Region;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.PostRepository;
import repositories.RegionRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class PostServiceTest {
    @Mock
    PostRepository repository;

    PostService service;

    public PostServiceTest(){
        MockitoAnnotations.initMocks(this);
        service = new PostService();
        service.setRepository(repository);
    }
    @Test
    void getAll() {
        List<Post> posts = Arrays.asList(new Post(1, "q", LocalDateTime.now()), new Post(2, "w", LocalDateTime.now()));
        given(repository.getAll()).willReturn(posts);
        assertEquals(service.getAll(), posts);
    }

    @Test
    void save() {
        Post post = new Post(1, "a", LocalDateTime.now());
        given(repository.save(post)).willReturn(post);
        assertEquals(service.save(post), post);
        verify(repository).save(post);
    }

    @Test
    void update() {
        Post post = new Post(1, "a", LocalDateTime.now());
        given(repository.update(post)).willReturn(post);
        assertEquals(service.update(post), post);
    }
}