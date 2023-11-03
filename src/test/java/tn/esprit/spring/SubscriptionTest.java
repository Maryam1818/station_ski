package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@Slf4j
@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SubscriptionTest {
    @Autowired
    ISubscriptionRepository iSubscriptionRepository;
    static Subscription s= Subscription.builder().startDate(LocalDate.now()).endDate(LocalDate.now()).price((float)1.1).typeSub(TypeSubscription.ANNUAL).build();

    @Test
    @Order(0)
    public void testSubscriptionCreation() {
        s=iSubscriptionRepository.save(s);
        log.info("Ajout ==>", s);
        Assertions.assertNotNull(s.getNumSub());
        Assertions.assertNotEquals(0,s.getNumSub());
    }

    @Test
    @Order(1)
    public void testSubscriptionListe() {
        List<Subscription> list = (List<Subscription>) iSubscriptionRepository.findAll();
        log.info("Liste ==>",list.size());
        Assertions.assertTrue(list.size()>0);
    }
    @Test
    @Order(2)
    public void testSubscriptionChercher() {
        log.info("cherche Subscription avec ID ==>",s.getNumSub());
        Subscription s1 = iSubscriptionRepository.findById(s.getNumSub()).get();
        Assertions.assertEquals(s1.getNumSub(),s.getNumSub());

    }
    @Test
    @Order(3)
    public void testSubscriptionSupprimer() {
        iSubscriptionRepository.delete(s);

    }
}
