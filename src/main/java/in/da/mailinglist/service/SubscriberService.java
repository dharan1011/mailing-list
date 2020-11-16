package in.da.mailinglist.service;

import in.da.mailinglist.model.Subscriber;
import org.springframework.http.ResponseEntity;

public interface SubscriberService {
    ResponseEntity<Subscriber> subscribeMailList(Subscriber subscriber);
    ResponseEntity<String> unsubscribeMailList(String email);
}
