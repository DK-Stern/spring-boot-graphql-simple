package sh.stern.springbootgraphqlsimple.repository;

import sh.stern.springbootgraphqlsimple.model.User;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private final List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public Optional<User> getUser(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }
}
