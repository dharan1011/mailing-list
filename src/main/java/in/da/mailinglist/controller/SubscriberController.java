package in.da.mailinglist.controller;

import in.da.mailinglist.model.Subscriber;
import in.da.mailinglist.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/gita")
public class SubscriberController {

    final SubscriberService service;

    public SubscriberController(SubscriberService service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribeGitaList(@RequestBody Subscriber subscriber){
        return service.subscribeGitaList(subscriber);
    }

    @GetMapping("/unsubscribe/{sid}")
    public ResponseEntity<String> unSubscribeGitaList(@PathVariable String sid){
        return service.unsubscribeGitaList(sid);
    }
}
