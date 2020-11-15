package in.da.mailinglist.repository;

import in.da.mailinglist.model.Subscriber;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SubscriberRepository extends MongoRepository <Subscriber, String>{
    Optional<Subscriber> findByEmail(String email);
    Long deleteByEmail(String email);
}
