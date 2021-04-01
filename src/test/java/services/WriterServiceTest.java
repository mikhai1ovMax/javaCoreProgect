package services;

import models.Post;
import models.Writer;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.WriterRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class WriterServiceTest {

    @Mock
    WriterRepository repository;

    WriterService service;

    public WriterServiceTest(){
        MockitoAnnotations.initMocks(this);
        service = new WriterService();
        service.setRepository(repository);
    }
    @Test
    void getAll() {
        List<Writer> writers = Arrays.asList(new Writer(1, "a", "b", null, null));
        given(repository.getAll()).willReturn(writers);
        assertEquals(service.getAll(), writers);
    }

    @Test
    void save() {
        Writer writer = new Writer(1, "a", "b", null, null);
        given(repository.save(writer)).willReturn(writer);
        assertEquals(service.save(writer), writer);
        verify(repository).save(writer);
    }

    @Test
    void update() {
        Writer writer = new Writer(1, "a", "b", null, null);
        given(repository.update(writer)).willReturn(writer);
        assertEquals(service.update(writer), writer);
        assertEquals(service.update(writer), writer);
    }
}