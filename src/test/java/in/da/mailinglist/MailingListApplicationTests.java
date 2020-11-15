package in.da.mailinglist;

import in.da.mailinglist.controller.GitaListController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MailingListApplicationTests {

    @Autowired
    GitaListController gitaListController;

    @Test
    void contextLoads() {
        assertThat(gitaListController).isNotNull();
    }
}
