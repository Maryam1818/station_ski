package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Skier;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SkierServiceImplTest {

    @Autowired
    private ISkierServices skierService; // Assuming SkierService is the correct service interface

    @Test
    public void testRetrieveAllSkiers() {
        List<Skier> skiers = skierService.retrieveAllSkiers();
        assertEquals(0, skiers.size()); // Update this assertion based on your application logic
    }
}
