package tn.esprit.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.repositories.ISubscriptionRepository;
import tn.esprit.spring.services.ISubscriptionServices;
import tn.esprit.spring.services.SubscriptionServicesImpl;

import java.time.LocalDate;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceTest {
    @Mock
    private ISubscriptionRepository subscriptionRepository;

    @InjectMocks
    private SubscriptionServicesImpl subscriptionServices;

    Subscription subscription = Subscription.builder().startDate(LocalDate.now()).endDate(LocalDate.now()).price((float)1.1).typeSub(TypeSubscription.ANNUAL).build();

    @Test
    void addSubscription() {
        Mockito.when(subscriptionRepository.save(Mockito.any(Subscription.class))).then(inv -> {
            Subscription m = inv.getArgument(0, Subscription.class);
            m.setNumSub(1L);
            return m;
        });
        log.info("Before : " + subscription.getNumSub());
        Subscription sub = subscriptionServices.addSubscription(subscription);
        Assertions.assertSame(sub, subscription);
        log.info("After : " + subscription.getNumSub());
        Mockito.verify(subscriptionRepository).save(subscription);;
    }
}
