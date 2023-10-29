package tn.esprit.spring.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class PisteServicesImplTest {

    @Mock
    IPisteRepository pisteRepository;

    @InjectMocks
    PisteServicesImpl pisteServices;

    @DisplayName("Retrieve all pistes - success scenario")
    @Test
    void testRetrieveAllPistes() {
        // Mocking
        List<Piste> mockPistes = new ArrayList<>();
        mockPistes.add(new Piste(1L, "Piste1", Color.RED, 100, 10, null));
        mockPistes.add(new Piste(2L, "Piste2", Color.BLUE, 150, 15, null));
        when(pisteRepository.findAll()).thenReturn(mockPistes);

        // Actual
         List<Piste> result = pisteServices.retrieveAllPistes();

        // Verification
          verify(pisteRepository, times(1)).findAll();

        // Assert
          Assertions.assertEquals(2, result.size());
    }

    @DisplayName("Add piste - success scenario")
    @Test
    void testAddPiste() {
        // Mocking
        Piste pisteToAdd = new Piste("NewPiste", Color.GREEN, 120, 12);
        when(pisteRepository.save(any(Piste.class))).thenReturn(pisteToAdd);

        // Actual
        Piste result = pisteServices.addPiste(pisteToAdd);

        // Verification
        verify(pisteRepository, times(1)).save(any(Piste.class));

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(pisteToAdd.getNamePiste(), result.getNamePiste());
    }

    @DisplayName("Remove piste - success scenario")
    @Test
    void testRemovePiste() {
        // Mocking
        Long numPisteToRemove = 1L;

        // Actual
        pisteServices.removePiste(numPisteToRemove);

        // Verification
        verify(pisteRepository, times(1)).deleteById(numPisteToRemove);
    }

    @DisplayName("Retrieve piste by id - success scenario")
    @Test
    void testRetrievePiste() {
        // Mocking
        Long numPisteToRetrieve = 1L;
        Piste mockPiste = new Piste(numPisteToRetrieve, "Piste1", Color.RED, 100, 10, null);
        when(pisteRepository.findById(numPisteToRetrieve)).thenReturn(Optional.of(mockPiste));

        // Actual
        Piste result = pisteServices.retrievePiste(numPisteToRetrieve);

        // Verification
        verify(pisteRepository, times(1)).findById(numPisteToRetrieve);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(mockPiste.getNumPiste(), result.getNumPiste());
    }
}