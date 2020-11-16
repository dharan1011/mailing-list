package in.da.mailinglist.service;

public interface MailingService {
    void mailParticipants();
    void sendMail(String to, String subject);
}
