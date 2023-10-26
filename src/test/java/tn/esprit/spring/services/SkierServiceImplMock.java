package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.entities.Skier;
import tn.esprit.spring.repositories.IPisteRepository;
import tn.esprit.spring.repositories.ISkierRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class SkierServiceImplMock {

    @Mock
    ISkierRepository skierRepository;  // Corrected the variable name

    @InjectMocks
    SkierServicesImpl skierServices; // Corrected the variable name

    Skier skier = new Skier("aa", "bb");

    List<Skier> listSkiers = new ArrayList<Skier>() {
        {
            add(new Skier("aa", "bb"));
            add(new Skier("aaa", "bbb"));
        }
    };

    @Test
    public void testRetrieveSkier() {

        Mockito.when(skierRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(skier));
        Skier retrievedSkier = skierServices.retrieveSkier(1L);
        Assertions.assertNotNull(retrievedSkier);
    }
}
