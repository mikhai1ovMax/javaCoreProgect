package services;

import models.Region;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repositories.GenericRepository;
import repositories.RegionRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

class RegionServiceTest {
    @Mock
    RegionRepository repository;

    RegionService service;

    public RegionServiceTest() {
        MockitoAnnotations.initMocks(this);
        service = new RegionService();
        service.setRepository(repository);
    }

    @Test
    void getAll() {
        List<Region> regions = Arrays.asList(new Region(1, "a"), new Region(2,"b"));
        given(repository.getAll()).willReturn(regions);
        assertEquals(service.getAll(), regions);

    }

    @Test
    void save() {
        Region region = new Region(1, "a");
        given(repository.save(region)).willReturn(region);
        assertEquals(service.save(region), region);
        verify(repository).save(region);
    }

    @Test
    void update() {
        Region region = new Region(1, "a");
        given(repository.save(region)).willReturn(region);
        assertEquals(service.save(region), region);
    }

}