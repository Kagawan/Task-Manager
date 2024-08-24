/*package hexlet.code.utils;

import hexlet.code.model.User;
import org.instancio.Instancio;

import org.instancio.Model;
import org.instancio.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import jakarta.annotation.PostConstruct;
import lombok.Getter;
import net.datafaker.Faker;

import java.time.format.DateTimeFormatter;
@Getter
@Component
public class ModelGenerator {
    private Model<User> userModel;

    @Autowired
    private Faker faker;

    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @PostConstruct
    private void init() {

        userModel = Instancio.of(User.class)
                .ignore(Select.field(User::getId))
                .ignore(Select.field(User::getCreatedAt))
                .ignore(Select.field(User::getUpdatedAt))
                .supply(Select.field(User::getEmail), () -> faker.internet().emailAddress())
                .supply(Select.field(User::getFirstName), () -> faker.name().firstName())
                .supply(Select.field(User::getLastName), () -> faker.name().lastName())
                .supply(Select.field(User::getPassword), () -> faker.internet().password(3, 12))
                .toModel();
    }
}*/
