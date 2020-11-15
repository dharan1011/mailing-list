package in.da.mailinglist.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "subscribers")
@NoArgsConstructor
public class Subscriber {
    @Id
    private String sid;
    private String firstName, lastName;
    private String email;

    public Subscriber(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
