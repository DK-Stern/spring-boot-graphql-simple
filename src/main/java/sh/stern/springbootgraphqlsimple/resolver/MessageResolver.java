package sh.stern.springbootgraphqlsimple.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import sh.stern.springbootgraphqlsimple.model.Message;
import sh.stern.springbootgraphqlsimple.model.User;
import sh.stern.springbootgraphqlsimple.repository.UserRepository;

@Component
public class MessageResolver implements GraphQLResolver<Message> {

    private final UserRepository userRepository;

    public MessageResolver(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(Message message) {
        return userRepository.getUser(message.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
