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
    public ResponseEntity<Subscriber> subscribeGitaList(Subscriber subscriber) {
        Subscriber response = null;
        if(!hasUserSubscribed(subscriber)){
            response = repository.save(subscriber);
        }
        if(response != null){
            return ResponseEntity.ok(response);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<String> unsubscribeGitaList(String email) {
        if(!hasUserSubscribed(email)){
            long cnt = repository.deleteByEmail(email);
            if(cnt > 0){
                return ResponseEntity.ok("Unsubscribed");
            }
        }
        return ResponseEntity.badRequest().build();
    }

    private boolean hasUserSubscribed(Subscriber subscriber){
        return repository.findByEmail(subscriber.getEmail()).isPresent();
    }

    private boolean hasUserSubscribed(String sid){
        return repository.findById(sid).isPresent();
    }
}
