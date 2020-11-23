package sh.stern.springbootgraphqlsimple.repository;

import sh.stern.springbootgraphqlsimple.model.Message;

import java.util.List;
import java.util.stream.Collectors;

public class MessageRepository {
    private final List<Message> messages;

    public MessageRepository(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getRecentMessages(int count, int offset) {
        return messages.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public List<Message> getUserMessages(String userId) {
        return messages.stream().filter(message -> message.getUserId().equals(userId)).collect(Collectors.toList());
    }

    public Message saveMessage(String messageString, String userId) {
        final Message message = new Message();
        message.setId(String.valueOf(messages.size() + 1));
        message.setMessage(messageString);
        message.setUserId(userId);
        messages.add(0, message);

        return message;
    }
}
