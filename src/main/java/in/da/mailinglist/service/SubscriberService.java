package in.da.mailinglist.service;

import in.da.mailinglist.model.Subscriber;
import org.springframework.http.ResponseEntity;

public interface SubscriberService {
    ResponseEntity<String> subscribeGitaList(Subscriber subscriber);
    ResponseEntity<String> unsubscribeGitaList(String subscriberId);
}
