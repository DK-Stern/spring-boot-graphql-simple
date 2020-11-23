package sh.stern.springbootgraphqlsimple.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import sh.stern.springbootgraphqlsimple.model.Message;
import sh.stern.springbootgraphqlsimple.repository.MessageRepository;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {
    public final MessageRepository messageRepository;

    public QueryResolver(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getRecentMessages(int count, int offset) {
        return messageRepository.getRecentMessages(count, offset);
    }
}
