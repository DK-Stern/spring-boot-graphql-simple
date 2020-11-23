package sh.stern.springbootgraphqlsimple;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sh.stern.springbootgraphqlsimple.model.Message;
import sh.stern.springbootgraphqlsimple.model.User;
import sh.stern.springbootgraphqlsimple.repository.MessageRepository;
import sh.stern.springbootgraphqlsimple.repository.UserRepository;

import java.util.ArrayList;

@Configuration
public class SpringBootGraphqlSimpleConfiguration {

    @Bean
    public MessageRepository messageRepository() {
        final ArrayList<Message> messages = new ArrayList<>();

        final Message message = new Message();
        message.setId("1");
        message.setMessage("Hallo Welt!");
        message.setUserId("1");
        messages.add(message);

        return new MessageRepository(messages);
    }

    @Bean
    public UserRepository userRepository() {
        final ArrayList<User> users = new ArrayList<>();

        final User user = new User();
        user.setId("1");
        user.setName("Donkey");
        users.add(user);

        return new UserRepository(users);
    }

}
