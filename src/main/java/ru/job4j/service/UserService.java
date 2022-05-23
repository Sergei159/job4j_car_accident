package ru.job4j.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.model.User;
import ru.job4j.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository store;

    public UserService(UserRepository store) {
        this.store = store;
    }

    public void save(User user) {
        store.save(user);
    }
}