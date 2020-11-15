package in.da.mailinglist;

import com.google.gson.Gson;
import in.da.mailinglist.model.Subscriber;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class GitaListControllerTest {
    @Autowired
    private MockMvc mvc;

    private final Gson gson = new Gson();;

    @Test
    @Order(1)
    public void subscribeToGitaList() throws Exception {
        Subscriber stubSubscriber = new Subscriber("Dharan","Aditya","dharan.aditya@gmail.com");
        this.mvc.perform(post("/v1/gita/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(stubSubscriber))).andExpect(status().isOk());
    }

    @Test
    @Order(2)
    public void subscribeToGitaListRedundant() throws Exception {
        Subscriber stubSubscriber = new Subscriber("Dharan","Aditya","dharan.aditya@gmail.com");
        this.mvc.perform(post("/v1/gita/subscribe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(stubSubscriber)))
                .andExpect(status().isBadRequest());

    }

    @Test
    @Order(3)
    public void unsubscribeToGitaList() throws Exception {
        this.mvc.perform(get("/v1/gita/unsubscribe/dharan.aditya@gmail.com"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(4)
    public void unsubscribeToGitaListRedundant() throws Exception {
        this.mvc.perform(get("/v1/gita/unsubscribe/dharan.aditya@gmail.com"))
                .andExpect(status().isBadRequest());
    }
}
