package tn.esprit.spring.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;
import tn.esprit.spring.services.ISubscriptionServices;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/subscription")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SubscriptionRestController {

    private final ISubscriptionServices subscriptionServices;

    @PostMapping("/add")
    public Subscription addSubscription(@RequestBody Subscription subscription){
        return  subscriptionServices.addSubscription(subscription);
    }
    @GetMapping("/get/{id-subscription}")
    public Subscription getById(@PathVariable("id-subscription") Long numSubscription){
        return subscriptionServices.retrieveSubscriptionById(numSubscription);
    }
    

    @GetMapping("/all/{typeSub}")
    public Set<Subscription> getSubscriptionsByType(@PathVariable("typeSub")TypeSubscription typeSubscription){
        return subscriptionServices.getSubscriptionByType(typeSubscription);
    }
    @PutMapping("/update")
    public Subscription updateSubscription(@RequestBody Subscription subscription){
        return  subscriptionServices.updateSubscription(subscription);
    }
    @GetMapping("/all/{date1}/{date2}")
    public List<Subscription> getSubscriptionsByDates(@PathVariable("date1") LocalDate startDate,
                                                      @PathVariable("date2") LocalDate endDate){
        return subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate);
    }
    @GetMapping("/allSubscriptions")
    public List<Subscription> getAllSubscriptions(){
        return subscriptionServices.getAllSubscriptions();
    }
}
