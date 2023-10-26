package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Piste;

import java.util.List;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class PisteServicesImplTest {

    @Autowired
    private IPisteServices ps; // Autowire the PisteServices

    @Test
    @Order(1)
    public void testRetrieveAllPistes() {
        List<Piste> listUsers = ps.retrieveAllPistes();
        Assertions.assertEquals(0, listUsers.size());
    }
}
