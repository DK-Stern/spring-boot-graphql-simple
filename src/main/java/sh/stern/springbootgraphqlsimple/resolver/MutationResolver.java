package sh.stern.springbootgraphqlsimple.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import sh.stern.springbootgraphqlsimple.model.Message;
import sh.stern.springbootgraphqlsimple.repository.MessageRepository;

@Component
public class MutationResolver implements GraphQLMutationResolver {
    private final MessageRepository messageRepository;

    public MutationResolver(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message writeMessage(String message, String userId) {
        return messageRepository.saveMessage(message, userId);
    }
}
