package in.da.mailinglist.service.impl;

import in.da.mailinglist.model.Subscriber;
import in.da.mailinglist.repository.SubscriberRepository;
import in.da.mailinglist.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubscriberServiceImpl implements SubscriberService {

    @Autowired
    private SubscriberRepository repository;

    @Override
    public ResponseEntity<String> subscribeGitaList(Subscriber subscriber) {
        if(!hasUserSubscribed(subscriber)){
            repository.save(subscriber);
        }
        return ResponseEntity.ok("Subscribed");
    }

    @Override
    public ResponseEntity<String> unsubscribeGitaList(String subscriberId) {
        if(!hasUserSubscribed(subscriberId)){
            repository.deleteById(subscriberId);
        }
        return ResponseEntity.ok("Unsubscribed");
    }

    private boolean hasUserSubscribed(Subscriber subscriber){
        return repository.findByEmail(subscriber.getEmail()).isPresent();
    }

    private boolean hasUserSubscribed(String sid){
        return repository.findById(sid).isPresent();
    }
}
