package in.da.mailinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MailingListApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailingListApplication.class, args);
    }

}
