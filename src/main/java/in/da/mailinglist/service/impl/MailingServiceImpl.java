package in.da.mailinglist.service.impl;

import in.da.mailinglist.repository.SubscriberRepository;
import in.da.mailinglist.service.MailingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingServiceImpl implements MailingService {

    @Autowired
    private SubscriberRepository repository;

    @Autowired
    JavaMailSender mailSender;

    @Override
    public void mailParticipants() {
    }

    @Override
    public void sendMail(String to, String subject) {

    }

}
