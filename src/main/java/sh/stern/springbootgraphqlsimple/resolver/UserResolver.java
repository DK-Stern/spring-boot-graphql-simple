package sh.stern.springbootgraphqlsimple.resolver;

import graphql.kickstart.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import sh.stern.springbootgraphqlsimple.model.Message;
import sh.stern.springbootgraphqlsimple.model.User;
import sh.stern.springbootgraphqlsimple.repository.MessageRepository;

import java.util.List;

@Component
public class UserResolver implements GraphQLResolver<User> {

    private final MessageRepository messageRepository;

    public UserResolver(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(User user) {
        return messageRepository.getUserMessages(user.getId());
    }

}
