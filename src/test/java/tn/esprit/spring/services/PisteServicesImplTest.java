package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Color;
import tn.esprit.spring.entities.Piste;
import tn.esprit.spring.repositories.IPisteRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@Slf4j
class PisteServiceMockTest {

    @InjectMocks
    private PisteServicesImpl pisteServices;

    @Mock
    private IPisteRepository pisteRepository;

    @Test
    public void testAddPiste() {
        Piste piste = new Piste("Blue Slope", Color.BLUE, 500, 15);

        // Mock the repository's save method
        when(pisteRepository.save(piste)).thenReturn(piste);

        Piste result = pisteServices.addPiste(piste);

        // Verify that the save method was called once
        verify(pisteRepository, times(1)).save(piste);

        // Verify that the result is not null
        assertNotNull(result);

        // Verify that the result is the same as the input piste
        assertEquals(piste, result);
    }

    @Test
    public void testRetrieveAllPistes() {
        // Create a set of Piste objects using the parameterized constructor
        Set<Piste> pistes = new HashSet<>();
        pistes.add(new Piste("Red Slope", Color.RED, 700, 20));
        pistes.add(new Piste("Green Slope", Color.GREEN, 400, 10));

        // Mock the behavior of the pisteRepository to return the set of pistes
        when(pisteRepository.findAll()).thenReturn((List<Piste>) pistes);

        List<Piste> result = pisteServices.retrieveAllPistes();

        // Verify that the service method returns the expected result
        assertEquals(pistes, result);
    }

    @Test
    public void testRetrievePiste() {
        // Create a sample Piste object for testing
        Long numPiste = 1L;
        Piste samplePiste = new Piste("Black Slope", Color.BLACK, 800, 25);

        // Mock the behavior of the pisteRepository to return the samplePiste when findById is called with numPiste
        when(pisteRepository.findById(numPiste)).thenReturn(Optional.of(samplePiste));

        // Call the retrievePiste function
        Piste retrievedPiste = pisteServices.retrievePiste(numPiste);

        // Verify that the retrieved piste is the same as the samplePiste
        assertEquals(samplePiste, retrievedPiste);
    }

    @Test
    public void testRemovePiste() {
        // Create a sample piste ID for testing
        Long numPisteToRemove = 1L;

        // Call the removePiste function with the numPiste
        pisteServices.removePiste(numPisteToRemove);

        // Verify that the deleteById method of pisteRepository is called with the numPisteToRemove
        verify(pisteRepository, times(1)).deleteById(numPisteToRemove);
    }
}
