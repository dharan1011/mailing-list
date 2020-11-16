package in.da.mailinglist.job;

import in.da.mailinglist.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MailScheduler {

    @Autowired
    MailingService mailingService;

    @Scheduled(cron = "0 0 6 * * *")
    public void mailGitaParticipants(){
        mailingService.mailParticipants();
    }
}
