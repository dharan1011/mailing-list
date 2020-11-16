package in.da.mailinglist.controller;

import in.da.mailinglist.model.Subscriber;
import in.da.mailinglist.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/mail")
public class MailListController {

    final SubscriberService service;

    public MailListController(SubscriberService service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Subscriber> subscribeMailList(@RequestBody Subscriber subscriber){
        return service.subscribeMailList(subscriber);
    }

    @GetMapping("/unsubscribe/{email}")
    public ResponseEntity<String> unSubscribeMailList(@PathVariable String email){
        return service.unsubscribeMailList(email);
    }
}
