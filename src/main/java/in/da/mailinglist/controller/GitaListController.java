package in.da.mailinglist.controller;

import in.da.mailinglist.model.Subscriber;
import in.da.mailinglist.service.SubscriberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/gita")
public class GitaListController {

    final SubscriberService service;

    public GitaListController(SubscriberService service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<Subscriber> subscribeGitaList(@RequestBody Subscriber subscriber){
        return service.subscribeGitaList(subscriber);
    }

    @GetMapping("/unsubscribe/{email}")
    public ResponseEntity<String> unSubscribeGitaList(@PathVariable String email){
        return service.unsubscribeGitaList(email);
    }
}
