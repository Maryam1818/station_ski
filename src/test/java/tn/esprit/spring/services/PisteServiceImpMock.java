package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class PisteServiceImpMock {

    @Mock
    IPisteRepository pisteRepository;  // Corrected the variable name

    @InjectMocks
    PisteServicesImpl pisteServices;

    Piste piste = new Piste("f1", Color.RED, 1, 10);

    List<Piste> listPistes = new ArrayList<Piste>() {
        {
            add(new Piste("f2", Color.BLACK, 2, 20));
            add(new Piste("f3", Color.GREEN, 3, 30));
        }
    };

    @Test
    public void testRetrievePiste() {  // Corrected the method name

        Mockito.when(pisteRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(piste));  // Corrected the method call
        Piste retrievedPiste = pisteServices.retrievePiste(1L);  // Corrected the method call
        Assertions.assertNotNull(retrievedPiste);
    }
}
